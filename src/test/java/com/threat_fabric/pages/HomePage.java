package com.threat_fabric.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    private final Page page;
    private final Locator searchBy;
    private final Locator logInLink;
    private final Locator hamburgerMenu;
    private final Locator myProfileLink;

    public HomePage(Page page) {
        this.page = page;
        this.searchBy = page.locator("select");
        this.logInLink = page.locator("//a[@class='btn']");
        this.hamburgerMenu = page.locator("img[alt='additional options menu']");
        this.myProfileLink = page.locator("text=My Profile");

    }

    public void SearchByOptions() {
        searchBy.selectOption("Advanced");
    }

    public void clickLogIn() {
        logInLink.click();
    }

    public void clickHamburgerMenu() {
        hamburgerMenu.click();
    }

    public void clickMyProfile() {
        myProfileLink.click();
    }
}