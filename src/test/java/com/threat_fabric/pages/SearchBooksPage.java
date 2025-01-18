package com.threat_fabric.pages;

import com.microsoft.playwright.Page;

public class SearchBooksPage {
    private final Page page;

    public SearchBooksPage(Page page) {
        this.page = page;
    }

    public void clickAuthorName(String authorName) {
        page.click("text=" + authorName);
    }
}
