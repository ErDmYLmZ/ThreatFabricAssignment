@ApiTests
Feature: Open Library API Tests

  Scenario: Validate Author Details via author key
    Given the Open Library search API is available
    When I search for a book titled "Harry Potter" by "Rowling"
#    Then I should be able to retrieve the author details using the author key
#    And the author website should be "http://www.jkrowling.com/"

#  Scenario: Validate Author Details via author name
#    Given the Open Library search API is available
#    When I search for a author by the name "J. K. Rowling"
#    And I should be able to get the author key
#    Then the author key should match the author



