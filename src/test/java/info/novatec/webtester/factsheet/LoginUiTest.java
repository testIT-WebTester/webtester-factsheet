package info.novatec.webtester.factsheet;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.ConfigurableApplicationContext;

import pages.LoginPage;

import info.novatec.testit.webtester.browser.Browser;
import info.novatec.testit.webtester.browser.WebDriverBrowser;
import info.novatec.webtester.factsheet.controller.model.Credentials;


public class LoginUiTest {

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\_tmp\\chromedriver.exe");
    }

    private static ConfigurableApplicationContext application;
    static Browser browser = WebDriverBrowser.buildForWebDriver(new ChromeDriver());

    Credentials validCredentials = Credentials.builder().username("tester_en").password("123456").build();
    Credentials unknownCredentials = Credentials.builder().username("unknown").password("123456").build();

    @BeforeClass
    public static void setUp() {
        application = Application.start();
    }

    @AfterClass
    public static void tearDown() {
        if (application != null) {
            application.close();
        }
        if (browser != null) {
            browser.close();
        }
    }

    @Before
    public void openLogin() {
        browser.open("http://localhost:8080/login");
    }

    @Test
    public void loginWithValidUserCredentialsWorks() {
        String welcomeMessage = browser.create(LoginPage.class).login(validCredentials).getMessage();
        assertThat(welcomeMessage).isEqualTo("You successfully logged in!");
    }

    @Test
    public void loginWithUnknownUserCredentialsDisplaysError() {
        String errorMessage = browser.create(LoginPage.class).loginWithError(unknownCredentials).error().getMessage();
        assertThat(errorMessage).isEqualTo("Unknown user: 'unknown'");
    }

}
