# OpenLibrary Test Automation Framework
## Project Overview
The OpenLibrary Test Automation Framework is designed to validate the functionality of the Open Library application at both API and UI levels. It leverages:

- **RestAssured**: For API testing and validation.

- **Cucumber**: To provide a Behavior-Driven Development (BDD) approach.

- **Playwright (Java)**: For robust and scalable UI automation.

This framework ensures adherence to QA best practices while offering modularity, flexibility, and ease of use.

---
## Requirements
- Java 17 or higher
- Maven (for dependency management and build automation).

---
## Setup Instructions
1. Clone this repository: [git clone](https://github.com/ErDmYLmZ/ThreatFabricAssignment.git) 
2. Navigate to the project directory:

`cd ThreatFabricAssignment`
3. Execute tests
* Run all tests: 
  * `mvn test -Dtest=com.threat_fabric.runners.AllTestsRunner`
* Run API tests: 
  * `mvn test -Dtest=com.threat_fabric.runners.ApiTestsRunner`

* Run UI tests (with a defined browser): 
  * `mvn test -Dtest=com.threat_fabric.runners.UiTestsRunner -Dbrowser=<browser_name>`
  _Replace <browser_name> with webkit, firefox, or chrome (default)._

* Run CrossBrowser tests: 
  * `mvn test -Dtest=CrossBrowserRunner`
  _This will execute UI tests sequentially across multiple browsers._

* Run Failed tests : 
  * `mvn test -Dtest=com.threat_fabric.runners.FailedTestsRunner`
      _Failed tests are logged in target/failed_tests.txt and can be re-run using this command._
  
---
## Test Reports
Test reports are automatically generated and stored in the `target/test-reports` directory. Reports include:
* Cucumber Reports: Detailed BDD execution reports.
* JSON Reports: Machine-readable test result logs.
* PDF Reports: Comprehensive, printable summaries.
* Screenshots: Captured on UI test failures.
* Spark Reports: Interactive HTML reports.
* XML Reports: Standardized test result logs for integration.

---
## Dependencies

The framework uses the following dependencies (defined in pom.xml):
* RestAssured: For API testing.
* Cucumber: For BDD support.
* Playwright (Java): For UI automation.
* Dependencies are automatically managed via Maven.

---

## Rationale Behind Choices

1. RestAssured:

* Chosen for its simplicity and power in handling RESTful APIs.

* Provides rich functionality like JSON/XML parsing, validation, and parameterization.

* Alternatives considered: Postman (Newman CLI) and Karate.

  * Postman lacks native integration with Java code.

  * Karate, while feature-rich, has a steeper learning curve and lesser community support compared to RestAssured.

2. Cucumber:

* BDD enables clear communication with stakeholders using Gherkin syntax.

* Allows non-technical team members to understand and contribute to test scenarios.

* Alternatives considered: TestNG.

  * TestNG could have been used, both support BDD-style test creation and Gherkin syntax, which are key requirements for this project.

3. Playwright (Java):

* Offers robust cross-browser testing support with great speed and flexibility.

* Supports modern web automation needs like handling iframes, network requests, and multiple contexts.

* Alternatives considered: Selenium and Cypress.

  * Selenium: Though widely used, Playwright provides better modern web capabilities.

  * Cypress: Limited to JavaScript/TypeScript, whereas Playwright (Java) integrates seamlessly with this Java-based framework.

4. Maven:

* Chosen for its dependency management and integration with CI/CD pipelines.

* Alternatives considered: Gradle.

  * While Gradle offers better performance for larger projects, Maven’s simplicity and community support made it the preferred choice for this framework.

---

## Approach and Decision-Making Process

### Approach Overview

The framework is designed to provide a modular and scalable test automation solution for the Open Library application. It combines API and UI testing capabilities by ensuring easy maintainability, extensibility, and readability.

### Decision-Making Process

1. Framework Design:

* Modular Architecture: The framework separates API and UI tests into distinct modules, allowing independent maintenance and execution.

* Reusability: Common utilities, configurations, Page object modeling, and test data are centralized, minimizing duplication and maximizing code reusability.

* Ease of Use: A parameterized design allows running tests with flexible input data, catering to various test scenarios.

2. Technology Choices:

* JUnit 5: Chosen for its modern features like annotations, parameterized tests, and dynamic tests. JUnit 5 integrates seamlessly with Maven and Cucumber, making it ideal for both unit and integration testing.

* RestAssured: Selected for its ability to simplify API testing with minimal boilerplate. It provides robust methods for handling HTTP requests, assertions, and JSON validation.

* Cucumber: Used to enable BDD, making test cases readable and understandable for both technical and non-technical stakeholders.

* Playwright (Java): A modern, fast, and reliable UI automation tool with built-in cross-browser support. It simplifies handling dynamic and modern web elements like iframes, network requests, and JavaScript-heavy interfaces.

* Maven: Used for dependency management, build automation, and seamless integration with CI/CD tools. Maven ensures consistency across environments.

3. Testing Strategy:

* API Testing: Validates data integrity, endpoint functionality, and parameterized scenarios to ensure robust backend verification.

* UI Testing: Simulates real-user behavior, verifies UI integrity, and ensures the correct interaction between UI components.

* Cross-Browser Testing: Ensures compatibility across major browsers (Chrome, Firefox, Webkit).

* Failure Recovery: Implements re-run capabilities for failed tests, reducing the need for manual intervention.

4. Reporting and Debugging:

* A comprehensive reporting mechanism includes HTML, JSON, PDF, and screenshots for detailed insights into test execution.

* Failed tests are logged for easy identification and re-execution.

### Key Strengths of the Approach

* Scalability: The modular architecture allows easy addition of new tests and functionalities.

* Readability: Use of BDD with Cucumber ensures that test cases are accessible and understandable by all stakeholders.

* Efficiency: Playwright and RestAssured streamline complex UI and API testing tasks.

* Flexibility: Parameterized tests and cross-browser capabilities cater to diverse testing requirements.

---
## Key Features

* Modular design supporting API and UI test integration.
* Parameterized test execution for flexible test scenarios.
* Cross-browser testing capabilities.
* Re-run mechanism for failed tests.

---

## Future Enhancements

* Integration with CI/CD pipelines (e.g., Jenkins or GitHub Actions).
* Extend test coverage for Open Library functionalities.
* Incorporate performance testing for APIs.

---
## Contact
For support or questions, please contact:
* _e.yilmaz.qa@gmail.com_
