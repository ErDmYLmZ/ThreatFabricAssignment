@ApiTests
Feature: Open Library API Tests

  Scenario Outline: Validate Author Details via author key
    Given the Open Library search API is available
    When a user searches for a book titled "<book titles>" and the "<author name>"
    Then user should be able to retrieve the author details using the author key
    And the author website should match "<links>"

    Examples: Titles and links
      | book titles           | author name    | links                                    |
      | Harry Potter          | J. K. Rowling  | http://www.jkrowling.com/                |
      | The Lord of the Rings | J.R.R. Tolkien | http://www.tolkiensociety.org/index.html |
      | The Lord of the Rings | J.R.R. Tolkien | http://www.tolkienestate.com/            |
      | Digital Fortress      | Dan Brown      | http://www.danbrown.com/                 |


  Scenario Outline: Validate Author works are belong to the author
    Given the Open Library search API is available
    When a user searches for a book titled "<book titles>"
    And user should be able to get the number of total works of the author
    Then all the author works should have the author key

    Examples: Total size and limit
      | book titles           |
      | Harry Potter          |
      | The Lord of the Rings |
      | Digital Fortress      |





