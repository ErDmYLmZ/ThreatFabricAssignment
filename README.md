# OpenLibrary Test Automation Framework

## Project Description
This project provides a test automation framework for validating the Open Library API and UI. It uses:
- **RestAssured**: For API testing
- **Cucumber**: For BDD
- **Playwright (Java)**: For UI testing

## Requirements
- Java 17+
- Maven

## Setup Instructions
1. Clone this repository: `git clone <repo-url>`
2. Navigate to the project directory: `cd openlibrary-tests`
3. Run API tests: `mvn test -Dtest=OpenLibraryAPITests`
4. Run UI tests: `mvn test -Dtest=OpenLibraryUITests`
5. Run Cucumber tests: `mvn test -Dcucumber.features=src/test/resources/features`

## Additional Tests
1. Validate the correct ISBN for a selected book via the API.
2. Validate search functionality for different keywords in the UI.

## Test Reports
Generated reports can be found in the `target/surefire-reports` directory.
