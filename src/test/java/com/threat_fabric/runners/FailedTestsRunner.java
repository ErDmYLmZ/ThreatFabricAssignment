package com.threat_fabric.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/test-reports/cucumber_reports/cucumber-reports.html",
                "json:target/test-reports/json_reports/cucumber.json",
                "junit:target/test-reports/xml_report/cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",

        },
        features = "@target/failed_tests.txt",
        glue = {"com/threat_fabric/steps"}
)
public class FailedTestsRunner {
}
