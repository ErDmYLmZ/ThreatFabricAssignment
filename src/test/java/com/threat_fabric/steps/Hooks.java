package com.threat_fabric.steps;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.threat_fabric.test_base.TestBase;
import groovy.util.logging.Slf4j;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.cucumber.java.Scenario;

import java.nio.file.Paths;

@Slf4j
public class Hooks extends TestBase {
    private static final Logger log = LoggerFactory.getLogger(Hooks.class);

    @Before(value = "@UiTests")
    public static void setup() {
        String browserType = System.getProperty("browser", "chromium");

        playwright = Playwright.create();

        switch (browserType.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                        .setChannel("chrome")
                        .setHeadless(false)
                        .setSlowMo(200));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(200));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(200));
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }

        page = browser.newPage();
        log.info("Browser '{}' started", browserType);
    }

    @After(value = "@UiTests")
    public static void teardown() {
        if (page != null) page.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
        log.info("Tear down is successful");
    }

    @After
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                String screenshotName = "target/test-reports/screenshots/" + scenario.getName().replaceAll("[^a-zA-Z0-9]", "_") + ".png";

                page.screenshot(new Page.ScreenshotOptions()
                        .setPath(Paths.get(screenshotName))
                        .setFullPage(true));

                log.info("{} is saved", screenshotName);
            } catch (Exception e) {
                log.error("Failed to capture screenshot: {} ", e.getMessage());
            }
        }
    }
}
