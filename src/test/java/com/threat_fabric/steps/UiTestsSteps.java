package com.threat_fabric.steps;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.threat_fabric.pages.*;
import com.threat_fabric.test_base.TestBase;
import com.threat_fabric.utils.ConfigurationReader;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

public class UiTestsSteps extends TestBase {

    @Given("a user navigates to the Open Library website")
    public void aUserNavigatesToTheOpenLibraryWebsite() {
        page.navigate(ConfigurationReader.get("baseUrl"));
        PlaywrightAssertions.assertThat(page).hasTitle("Welcome to Open Library | Open Library");
    }

    @When("user performs an advanced search for {string} by {string}")
    public void userPerformsAnAdvancedSearch(String title, String author) {
        if (homePage == null) homePage = new HomePage(page);
        homePage.SearchByOptions();

        if (advancedSearchPage == null) advancedSearchPage = new AdvancedSearchPage(page);
        advancedSearchPage.fillTitleBox(title);
        advancedSearchPage.fillAuthorBox(author);
        advancedSearchPage.clickSearchButton();

        assertTrue(page.isVisible("text=" + author), "Author name not visible in search results");
    }

    @When("user clicks on the author's name {string}")
    public void i_click_on_the_author_s_name(String authorName) {
        if (searchBooksPage == null) searchBooksPage = new SearchBooksPage(page);
        searchBooksPage.clickAuthorName(authorName);

        assertTrue(page.url().contains(ConfigurationReader.get("authors")), "Author page URL does not match expected format");
    }

    @When("user sorts the works by rating")
    public void userSortsTheWorksByRating() {
        if (authorPage == null) authorPage = new AuthorPage(page);
        authorPage.clickSortingMenu();
        authorPage.clickTopRatedOption();

        PlaywrightAssertions.assertThat(page).hasTitle("J. K. Rowling | Open Library");
    }

    @Then("the top-rated work should be the {string}")
    public void theTopRatedWorkShouldBeTHe(String topRatedWork) {
        if (authorPage == null) authorPage = new AuthorPage(page);
        String actualTopRatedWork = authorPage.getTopRatedBook();

        assertEquals(topRatedWork, actualTopRatedWork, "Top-rated work does not match expected value");
    }

    @When("user logs in with {string} and {string}")
    public void userLogsInWithCredentials(String email, String password) {
        if (homePage == null) homePage = new HomePage(page);
        homePage.clickLogIn();

        if (logInPage == null) logInPage = new LogInPage(page);
        logInPage.enterEmail(email);
        logInPage.enterPassword(password);
        logInPage.clickLoginButton();
    }

    @And("user navigates to my_profile page")
    public void userNavigatesToMyProfilePage() {
        if (homePage == null) homePage = new HomePage(page);
        homePage.clickHamburgerMenu();
        homePage.clickMyProfile();
    }

    @Then("user asserts that the title contains the {string} of the user")
    public void userAssertsThatTheTitleContainsDisplayName(String displayName) {
        if (myProfilePage == null) myProfilePage = new MyProfilePage(page);
        String actualDisplayName = myProfilePage.getDisplayName();

        assertEquals(displayName, actualDisplayName, "Display name does not match");
    }


}
