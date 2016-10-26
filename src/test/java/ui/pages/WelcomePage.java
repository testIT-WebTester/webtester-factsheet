package ui.pages;

import info.novatec.testit.webtester.conditions.pagefragments.Visible;
import info.novatec.testit.webtester.pagefragments.GenericElement;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pagefragments.annotations.PostConstructMustBe;
import info.novatec.testit.webtester.pages.Page;


public interface WelcomePage extends Page {

    @IdentifyUsing("#welcomeMessage")
    @PostConstructMustBe(Visible.class)
    GenericElement welcomeMessage();

    default String getWelcomeMessage(){
        return welcomeMessage().getVisibleText();
    }

}
