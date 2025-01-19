@UiTests
Feature: Open Library UI Tests

  Scenario Outline: Validate log in function
    Given a user navigates to the Open Library website
    When user logs in with "<email>" and "<password>"
    And user navigates to my_profile page
    Then user asserts that the title contains the "<display name>" of the user

    Examples: Credentials
      | email                          | password           | display name |
      | threatfabrictestdata@gmail.com | Threatfabric2025%! | TFtestdata   |



  Scenario Outline: Validate Top Rated Work via UI
    Given a user navigates to the Open Library website
    When user performs an advanced search for "<book title>" by "<author name>"
    And user clicks on the author's name "<author link>"
    And user sorts the works by rating
    Then the top-rated work should be the "<top book title>"

    Examples: Validate works
      | book title   | author name | author link   | top book title                           |
      | Harry Potter | Rowling     | J. K. Rowling | Harry Potter and the Prisoner of Azkaban |

#NOTE: Although the expected top-rated book of the J.K.Rowling is "Harry Potter and the Half-Blood Prince" in the given assignment,
#      the actual top-rated book is "Harry Potter and the Prisoner of Azkaban" on the url "https://openlibrary.org/authors/OL23919A/J._K._Rowling?sort=rating".
#      Therefore, "Harry Potter and the Prisoner of Azkaban" is used as the expected test data instead of "Harry Potter and the Half-Blood Prince".