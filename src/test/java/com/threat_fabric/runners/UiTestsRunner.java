package com.threat_fabric.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/test-reports/cucumber-reports/cucumber-reports.html",
                "json:target/test-reports/json-reports/cucumber.json",
                "junit:target/test-reports/xml-report/cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed-tests.txt",

        },
        features = "src/test/resources/features",
        glue = {"com/threat_fabric/steps"},
        tags = "@UiTests"
)

public class UiTestsRunner {
}
