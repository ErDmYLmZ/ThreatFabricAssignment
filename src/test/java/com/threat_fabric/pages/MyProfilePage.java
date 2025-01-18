package com.threat_fabric.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MyProfilePage {
    private final Page page;
    private final Locator displayName;

    public MyProfilePage(Page page) {
        this.page = page;
        this.displayName = page.locator("//*[@id='contentHead']/h1[2]");
    }

    public String getDisplayName() {
        return displayName.textContent();
    }
}

