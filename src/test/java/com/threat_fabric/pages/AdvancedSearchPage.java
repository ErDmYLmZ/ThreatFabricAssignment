package com.threat_fabric.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AdvancedSearchPage {

    private final Page page;
    private final Locator titleBox;
    private final Locator authorBox;
    private final Locator searchButton;

    public AdvancedSearchPage(Page page) {
        this.page = page;
        this.authorBox = page.locator("#qtop-author");
        this.titleBox = page.locator("#qtop-title");
        this.searchButton = page.locator("//*[@id='contentBody']/form/button");
    }

    public void fillTitleBox(String title) {
        titleBox.fill(title);
    }

    public void fillAuthorBox(String author) {
        authorBox.fill(author);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
