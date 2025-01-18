package com.threat_fabric.steps;

import com.threat_fabric.test_base.TestBase;
import com.threat_fabric.utils.ConfigurationReader;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class ApiTestsSteps extends TestBase {

    @Given("the Open Library search API is available")
    public void the_open_library_search_api_is_available() {
        RestAssured.baseURI = ConfigurationReader.get("baseUrl");
    }

    @When("I search for a book titled {string} and the {string}")
    public void i_search_for_a_book_by_title_and_author(String title, String author) {
        response = given()
                .queryParam("title", title)
                .when()
                .get(ConfigurationReader.get("search"));
        response.then().statusCode(200);
        String authorName = response.jsonPath().getString("docs[0].author_name[0]");
        assertEquals("Author name does not match", author, authorName);
        authorKey = response.jsonPath().getString("docs[0].author_key[0]");
    }

    @When("I search for a book titled {string}")
    public void i_Search_For_A_BookTitled(String title) {
        Response response = given()
                .queryParam("title", title)
                .when()
                .get(ConfigurationReader.get("search"));
        response.then().statusCode(200);
        authorKey = response.jsonPath().getString("docs[0].author_key[0]");

    }

    @And("I should be able to get the number of total works of the author")
    public void iShouldBeAbleToGetTheTotalWorksOfTheAuthor() {
        Response authorResponse = given()
                .when()
                .get(ConfigurationReader.get("authors") + authorKey + ConfigurationReader.get("works"));
        authorResponse.then().statusCode(200);
        totalSize = authorResponse.jsonPath().getInt("size");

    }

    @Then("all the author works should have the author key")
    public void allTheAuthorWorksShouldHaveTheAuthorKey() {
        Response authorResponse = given()
                .queryParam("limit", totalSize)
                .when()
                .get(ConfigurationReader.get("authors") + authorKey + ConfigurationReader.get("works"));
        authorResponse.then().statusCode(200);

        List<String> authorKeyList = authorResponse.jsonPath().getList("entries.authors.author.key");
        assertEquals("All the author works should have the author key", totalSize, authorKeyList.size());


    }

    @Then("I should be able to retrieve the author details using the author key")
    public void i_should_be_able_to_retrieve_the_author_details_using_the_author_key() {
        Response authorResponse = given()
                .when()
                .get(ConfigurationReader.get("authors") + authorKey + ".json");
        assertEquals("Expected status code 200 for author details", 200, authorResponse.getStatusCode());
    }

    @Then("the author website should be {string}")
    public void the_author_website_should_be(String expectedWebsite) {
        Response authorResponse = given()
                .when()
                .get(ConfigurationReader.get("authors") + authorKey + ".json");
        List<String> actualWebsite = authorResponse.jsonPath().getList("links.url");
        assertTrue(actualWebsite.stream().anyMatch(t -> t.equals(expectedWebsite)));
    }


}



