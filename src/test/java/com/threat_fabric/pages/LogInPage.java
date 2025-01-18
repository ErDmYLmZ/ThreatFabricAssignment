package com.threat_fabric.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LogInPage {
    private final Page page;
    private final Locator emailBox;
    private final Locator passwordBox;
    private final Locator loginButton;

    public LogInPage(Page page) {
        this.page = page;
        this.emailBox = page.getByPlaceholder("Email");
        this.passwordBox = page.getByPlaceholder("Password");
        this.loginButton = page.getByTitle("Log In");
    }

    public void enterEmail(String email) {
        emailBox.fill(email);
    }

    public void enterPassword(String password) {
        passwordBox.fill(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
