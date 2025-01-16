@UiTests
Feature: Open Library UI Tests

  Scenario: Validate log in function
    Given I navigate to the Open Library website
    When I log in with "threatfabrictestdata@gmail.com" and "Threatfabric2025%!"
    And I go to my profile
    Then I assert that the title contains my "TFtestdata"

  Scenario: Validate Top Rated Work via UI
    Given I navigate to the Open Library website
    When I perform an advanced search for "Harry Potter" by "Rowling"
    And I click on the author's name "J. K. Rowling"
    And I sort works by rating
    Then the top-rated work should be "Harry Potter and the Prisoner of Azkaban"
#    Then the top-rated work should be "Harry Potter and the Half-Blood Prince"

