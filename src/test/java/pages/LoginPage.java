package pages;

import info.novatec.testit.webtester.pagefragments.Button;
import info.novatec.testit.webtester.pagefragments.PasswordField;
import info.novatec.testit.webtester.pagefragments.TextField;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pages.Page;
import info.novatec.webtester.factsheet.controller.model.Credentials;


public interface LoginPage extends Page {

    @IdentifyUsing("#username")
    TextField username();

    @IdentifyUsing("#password")
    PasswordField password();

    @IdentifyUsing("#login")
    Button login();

    default WelcomePage login(Credentials credentials) {
        return setUsername(credentials.getUsername()).setPassword(credentials.getPassword()).clickLogin();
    }

    default ErrorPage loginWithError(Credentials credentials) {
        return setUsername(credentials.getUsername()).setPassword(credentials.getPassword()).clickLoginWithError();
    }

    default LoginPage setUsername(String username) {
        username().setText(username);
        return this;
    }

    default LoginPage setPassword(String password) {
        password().setText(password);
        return this;
    }

    default WelcomePage clickLogin() {
        login().click();
        return create(WelcomePage.class);
    }

    default ErrorPage clickLoginWithError() {
        login().click();
        return create(ErrorPage.class);
    }

}
