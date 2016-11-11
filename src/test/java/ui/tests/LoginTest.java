package ui.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import extensions.EmbeddedApplication;
import ui.pages.ErrorPage;
import ui.pages.LoginPage;
import ui.pages.WelcomePage;

import info.novatec.testit.webtester.browser.Browser;
import info.novatec.testit.webtester.browser.factories.FirefoxFactory;
import info.novatec.testit.webtester.junit5.EnableWebTesterExtensions;
import info.novatec.testit.webtester.junit5.extensions.browsers.CreateUsing;
import info.novatec.testit.webtester.junit5.extensions.browsers.EntryPoint;
import info.novatec.testit.webtester.junit5.extensions.browsers.Managed;
import info.novatec.testit.webtester.junit5.extensions.pages.Initialized;
import info.novatec.webtester.factsheet.controller.model.Credentials;


@EnableWebTesterExtensions
@ExtendWith(EmbeddedApplication.class)
public class LoginTest {

    @Managed
    @CreateUsing(FirefoxFactory.class)
    @EntryPoint("http://localhost:8080/login")
    static Browser browser;

    @Initialized
    LoginPage loginPage;

    @Test
    void loginWithExistingCredentials() {
        Credentials credentials = Credentials.builder()
            .username("tester_de")
            .password("123456")
            .build();
        WelcomePage welcomePage = loginPage.login(credentials);
        assertThat(welcomePage.getWelcomeMessage()).isEqualTo("You successfully logged in!");
    }

    @Test
    void loginWithUnknownUser() {
        Credentials credentials = Credentials.builder()
            .username("unknown")
            .password("123456")
            .build();
        ErrorPage errorPage = loginPage.loginExpectingError(credentials);
        assertThat(errorPage.getErrorMessage()).isEqualTo("Unknown user: 'unknown'");
    }

    @Test
    void loginWithWrongPassword() {
        Credentials credentials = Credentials.builder()
            .username("tester_de")
            .password("wrong")
            .build();
        ErrorPage errorPage = loginPage.loginExpectingError(credentials);
        assertThat(errorPage.getErrorMessage()).isEqualTo("Wrong password!");
    }

}
