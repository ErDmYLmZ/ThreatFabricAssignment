package com.threat_fabric.test_base;

import com.microsoft.playwright.*;
import com.threat_fabric.pages.*;
import io.restassured.response.Response;

public class TestBase {
    protected Response response;
    protected String authorKey;
    protected int totalSize;

    protected static Playwright playwright;
    protected static Browser browser;
    protected static Page page;

    protected HomePage homePage;
    protected AdvancedSearchPage advancedSearchPage;
    protected SearchBooksPage searchBooksPage;
    protected AuthorPage authorPage;
    protected LogInPage logInPage;
    protected MyProfilePage myProfilePage;


}
