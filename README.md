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
1. Clone this repository: [git clone](https://github.com/ErDmYLmZ/ThreatFabricAssignment.git) 
2. Navigate to the project directory: `cd ThreatFabricAssignment`
* Run all tests: `mvn test -Dtest=com.threat_fabric.runners.AllTestsRunner`
* Run API tests: `mvn test -Dtest=com.threat_fabric.runners.ApiTestsRunner`

    
* Run UI tests with a defined browser: `mvn test -Dtest=com.threat_fabric.runners.UiTestsRunner`
   
    -_To run the UI tests with a defined browser, please add the `-Dbrowser=webkit` or `-Dbrowser=firefox`at the end of mvn command. (Since the default browser is chrome, no need to add `-Dbrowser=chrome` at the end of mvn command.). Example: `mvn test -Dtest=com.threat_fabric.runners.UiTestsRunner -Dbrowser=webkit`_


* Run CrossBrowser tests: `mvn test -Dtest=CrossBrowserRunner`

    -_To run cross-browser UI testing sequentially with a single execution._


* Run Failed tests : `mvn test -Dtest=com.threat_fabric.runners.FailedTestsRunner`

    -_In case of failed test cases, they are saved into the "failed_tests.txt" file under the target folder. By running this command, the failed tests are re-run._
---
## Test Reports
Generated reports can be found in the `target/test-reports` directory. These reports are;
* cucumber_reports
* json_reports
* pdf_reports
* screenshots
* spark_report
* xml_report
---
## Contact
In case of any support/questions, please contact _e.yilmaz.qa@gmail.com_
