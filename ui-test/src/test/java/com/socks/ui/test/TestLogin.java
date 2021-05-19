package com.socks.ui.test;

import com.socks.api.payloads.UserPayload;
import com.socks.api.services.UserApiService;
import com.socks.ui.LoggedUserPage;
import com.socks.ui.MainPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.socks.api.conditions.Conditions.statusCode;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class TestLogin extends BaseUITest {

    private final UserApiService userApiService = new UserApiService();

    @Test
    public void userCanLoginWithValidCredentials() {

        // Arrange
        UserPayload user = new UserPayload()
                .username(randomAlphabetic(6))
                .email("test@mail.com")
                .password("test123456");

        userApiService.registerUser(user)
                .shouldHave(statusCode(200));

        // Act
        MainPage.open()
                .loginAs(user.username(), user.password());

        // Assert
        LoggedUserPage loggedUserPage = at(LoggedUserPage.class);
        loggedUserPage.logoutButton().shouldHave(text("Logout"));
        loggedUserPage.userName().shouldHave(text("Logged in as"));
    }
}
