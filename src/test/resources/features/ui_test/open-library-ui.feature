@UiTests
Feature: Open Library UI Tests

  Scenario Outline: Validate log in function
    Given I navigate to the Open Library website
    When I log in with "<email>" and "<password>"
    And I go to my profile
    Then I assert that the title contains my "<display name>"

    Examples: Credentials
      | email                          | password           | display name |
      | threatfabrictestdata@gmail.com | Threatfabric2025%! | TFtestdata   |


  Scenario Outline: Validate Top Rated Work via UI
    Given I navigate to the Open Library website
    When I perform an advanced search for "<book title>" by "<author name>"
    And I click on the author's name "<author link>"
    And I sort works by rating
    Then the top-rated work should be the "<top book title>"

    Examples: Validate works
      | book title   | author name | author link   | top book title                           |
      | Harry Potter | Rowling     | J. K. Rowling | Harry Potter and the Prisoner of Azkaban |

