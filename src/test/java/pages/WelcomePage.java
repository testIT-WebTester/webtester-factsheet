package pages;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;

import info.novatec.testit.webtester.pages.Page;


public interface WelcomePage extends Page {

    @PostConstruct
    default void assertCorrectPage() {
        assertThat(browser().currentPageTitle()).isEqualTo("Fact Sheet - Main");
    }

    default String getMessage() {
        return find("#welcomeMessage").getVisibleText();
    }

}
