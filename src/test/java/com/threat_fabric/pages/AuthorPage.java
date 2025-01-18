package com.threat_fabric.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AuthorPage {
    private final Page page;
    private final Locator sortingMenu;
    private final Locator topRatedOption;
    private final Locator topRatedBook;

    public AuthorPage(Page page) {
        this.page = page;
        this.sortingMenu = page.getByAltText("Sorting by");
        this.topRatedOption = page.locator("text=Top Rated");
        this.topRatedBook = page.locator("ul.list-books li.searchResultItem h3.booktitle a").first();
    }

    public void clickSortingMenu() {
        sortingMenu.click();
    }

    public void clickTopRatedOption() {
        topRatedOption.click();
    }

    public String getTopRatedBook() {
        return topRatedBook.textContent();

    }
}
