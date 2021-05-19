package com.socks.ui.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.socks.api.ProjectConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseUITest {

    @BeforeSuite
    public void setUp() {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
        RestAssured.baseURI = config.baseUrl();
        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = "com.socks.ui.SelenoidDriverProvider";
        Configuration.timeout = 8000;
    }

    protected <T> T at(Class<T> pageClass) { return Selenide.page(pageClass); }
}
