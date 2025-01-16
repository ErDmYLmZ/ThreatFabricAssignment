package com.threat_fabric.steps;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Step1 {
    private String authorKey_1;
    private String authorKey_2;
    private Response response;

    @Given("the Open Library search API is available")
    public void the_open_library_search_api_is_available() {
        RestAssured.baseURI = "https://openlibrary.org";
    }

    @When("I search for a book titled {string} by {string}")
    public void i_search_for_a_book_titled_by(String title, String author) {
        response = given()
                .queryParam("title", title)
                .when()
                .get("/search.json");
        assertEquals("Expected status code 200",200, response.getStatusCode());
        String authorName= response.jsonPath().getString("docs[0].author_name[0]");
        assertTrue("Author name does not exactly contain 'Rowling'", authorName.matches(".*\\bRowling\\b.*"));
        authorKey_1 = response.jsonPath().getString("docs[0].author_key[0]");
    }

    @Then("I should be able to retrieve the author details using the author key")
    public void i_should_be_able_to_retrieve_the_author_details_using_the_author_key() {
        Response authorResponse = given()
                .when()
                .get("/authors/" + authorKey_1 + ".json");
        assertEquals("Expected status code 200 for author details",200 , authorResponse.getStatusCode());
    }

    @Then("the author website should be {string}")
    public void the_author_website_should_be(String expectedWebsite) {
        Response authorResponse = given()
                .when()
                .get("/authors/" + authorKey_1 + ".json");
        String actualWebsite = authorResponse.jsonPath().getString("links[0].url");
        assertEquals("Author website does not match",expectedWebsite, actualWebsite );
    }
//TODO yeni ve bağımsız bir test case yaz
    @When("I search for a author by the name {string}")
    public void i_search_for_a_author_by_the_name(String author) {
        response = given()
//                .queryParam("author" ,author)
                .when()
                .get("/search/authors.json?q="+author);
        response.prettyPrint();

//        assertEquals("Expected status code 200",200, response.getStatusCode());

    }
//    @And("I should be able to get the author key")
//    public void i_should_be_able_to_get_the_author_key() {
//       var listi  = response.jsonPath().getString("docs[0]");
//        System.out.println("listi = " + listi);
//        System.out.println("authorKey_2 = " + authorKey_2);
//        assertNotNull(authorKey_2, "Author key should not be null");
//    }
//    @Then("the author key should match the author")
//    public void the_author_key_should_match_the_author() {
//    assertEquals("Author keys don't match",authorKey_1, authorKey_2 );
//        System.out.println("authorKey_1 = " + authorKey_1);
//        System.out.println("authorKey_2 = " + authorKey_2);
//    }
//    private String authorKey;
//    private Response response;
//
//    @Given("the Open Library search API is available")
//    public void the_open_library_search_api_is_available() {
//        RestAssured.baseURI = "https://openlibrary.org";
//    }
//
//    @When("I search for a book titled {string} by {string}")
//    public void i_search_for_a_book_titled_by(String title, String author) {
//        response = given()
//                .queryParam("title", title)
//                .queryParam("author", author)
//                .when()
//                .get("/search.json");
//        authorKey = response.then()
//                .statusCode(200)
//                .body("docs[0].author_key[0]", notNullValue())
//                .extract()
//                .path("docs[0].author_key[0]");
//    }
//
//    @Then("I should be able to retrieve the author details using the author key")
//    public void i_should_be_able_to_retrieve_the_author_details_using_the_author_key() {
//        response = given()
//                .when()
//                .get("/authors/" + authorKey + ".json");
//    }
//
//    @Then("the author website should be {string}")
//    public void the_author_website_should_be(String expectedWebsite) {
////        given()
////                .when()
////                .get("/authors/" + authorKey + ".json")
////                .then()
////                .body("website", equalTo(expectedWebsite));
//
//        Assert.assertEquals("test", expectedWebsite,response.body().path("links[0].url"));
//    }
}
