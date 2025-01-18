package com.threat_fabric.runners;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Slf4j
public class CrossBrowserRunner {

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox", "webkit"})
    void runTests(String browserType) {
        System.setProperty("browser", browserType);

        org.junit.runner.JUnitCore.runClasses(UiTestsRunner.class);

        log.info("Tests completed for browser: {}", browserType);
    }
}

