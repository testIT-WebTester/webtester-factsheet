package ui.pages;

import static info.novatec.testit.webtester.support.assertj.WebTesterAssertions.assertThat;

import javax.annotation.PostConstruct;

import info.novatec.testit.webtester.pagefragments.Button;
import info.novatec.testit.webtester.pagefragments.PasswordField;
import info.novatec.testit.webtester.pagefragments.TextField;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pages.Page;
import info.novatec.webtester.factsheet.controller.model.Credentials;


public interface LoginPage extends Page {

    @IdentifyUsing("#username")
    TextField usernameField();
    @IdentifyUsing("#password")
    PasswordField passwordField();
    @IdentifyUsing("#login")
    Button loginButton();

    @PostConstruct
    default void correctPageIsDisplayed(){
        assertThat(usernameField()).isVisible();
        assertThat(passwordField()).isVisible();
        assertThat(loginButton()).isVisible();
    }

    default WelcomePage login(Credentials credentials) {
        return setUsername(credentials.getUsername())
            .setPassword(credentials.getPassword())
            .clickLogin();
    }

    default ErrorPage loginExpectingError(Credentials credentials) {
        return setUsername(credentials.getUsername())
            .setPassword(credentials.getPassword())
            .clickLoginExpectingError();
    }

    default LoginPage setUsername(String username) {
        usernameField().setText(username);
        return this;
    }

    default LoginPage setPassword(String password) {
        passwordField().setText(password);
        return this;
    }

    default WelcomePage clickLogin() {
        loginButton().click();
        return create(WelcomePage.class);
    }

    default ErrorPage clickLoginExpectingError() {
        loginButton().click();
        return create(ErrorPage.class);
    }

}
