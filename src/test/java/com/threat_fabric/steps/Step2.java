package com.threat_fabric.steps;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Step2 {

    private static Page page;
    private static Browser browser;

    @Given("I navigate to the Open Library website")
    public void i_navigate_to_the_open_library_website() {
        browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").setSlowMo(50));
        page = browser.newPage();
        page.navigate("https://openlibrary.org");
        PlaywrightAssertions.assertThat(page).hasTitle("Welcome to Open Library | Open Library");
    }

    @When("I perform an advanced search for {string} by {string}")
    public void i_perform_an_advanced_search_for_by(String title, String author) {
        Locator AdvancedSearchLoc = page.locator("select");
        AdvancedSearchLoc.selectOption("Advanced");
        page.locator("xpath=//*[@id='qtop-title']").fill(title);
        page.locator("xpath=//*[@id='qtop-author']").fill(author);
        page.click("xpath=//*[@id='contentBody']/form/button");
        assertTrue(page.isVisible("text=" + author), "Author name not visible in search results");
    }

    @When("I click on the author's name {string}")
    public void i_click_on_the_author_s_name(String authorName) {
        page.click("text=" + authorName);
        assertTrue(page.url().contains("/authors/"), "Author page URL does not match expected format");
    }

    @When("I sort works by rating")
    public void i_sort_works_by_rating() throws InterruptedException {
        page.locator("//*[@id='books']/span/span/details/summary/p").click();
        page.locator("xpath=//*[@id='books']/span/span/details/span/span/a[4]").click();
        PlaywrightAssertions.assertThat(page).hasTitle("J. K. Rowling | Open Library");
    }

    @Then("the top-rated work should be {string}")
    public void the_top_rated_work_should_be(String topRatedWork) {
        String actualTopRatedWork = page.textContent("xpath=//*[@id='searchResults']/ul/li[1]/div/div[1]/div/h3/a");
        assertEquals(topRatedWork, actualTopRatedWork, "Top-rated work does not match expected value");
    }
//    @AfterAll
//            public static void teardown(){
//        page.close();
//        browser.close();
//    }
    @When("I log in with {string} and {string}")
    public void i_log_in_with_and(String email, String password) {
        page.locator("xpath=//*[@id='header-bar']/ul[2]/li[1]/a").click();
        page.getByPlaceholder("Email").clear();
        page.getByPlaceholder("Email").fill(email);
        page.getByPlaceholder("Password").clear();
        page.getByPlaceholder("Password").fill(password);
        page.getByTitle("Log In").click();

}
    @And("I go to my profile")
    public void i_go_to_my_profile() {
    page.locator("xpath=//*[@id='header-bar']/div[3]/details/summary/img[2]").click();
    page.locator( "xpath=//*[@id='header-bar']/div[3]/details/div[2]/ul/li[3]/a").click();

    }

    @Then("I assert that the title contains my {string}")
    public void i_assert_that_the_title_contains_my(String displayName) {
        String name =page.locator("xpath=//*[@id='contentHead']/h1[2]").textContent();
        assertEquals(displayName, name, "Display name does not match");
    }

}
