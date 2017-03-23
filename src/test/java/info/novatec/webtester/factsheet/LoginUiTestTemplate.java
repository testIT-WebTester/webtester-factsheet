package info.novatec.webtester.factsheet;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import extensions.EmbeddedApplication;

import info.novatec.testit.webtester.browser.Browser;
import info.novatec.testit.webtester.browser.factories.ChromeFactory;
import info.novatec.testit.webtester.junit5.EnableWebTesterExtensions;
import info.novatec.testit.webtester.junit5.extensions.browsers.CreateUsing;
import info.novatec.testit.webtester.junit5.extensions.browsers.EntryPoint;
import info.novatec.testit.webtester.junit5.extensions.browsers.Managed;
import info.novatec.testit.webtester.junit5.extensions.pages.Initialized;
import info.novatec.testit.webtester.pages.Page;
import info.novatec.testit.webtester.waiting.Wait;


@EnableWebTesterExtensions
@ExtendWith(EmbeddedApplication.class)
class LoginUiTestTemplate {

    @Managed
    //@CreateUsing(FirefoxFactory.class)
    @CreateUsing(ChromeFactory.class)
    @EntryPoint("http://localhost:8080/login")
    static Browser browser;

    @Initialized
    LoginPage loginPage;

    @Test
    void abc() {
        loginPage.find("#username").sendKeys("hello");
        Wait.exactly(2, TimeUnit.SECONDS);
    }

    public interface LoginPage extends Page {

    }

}
