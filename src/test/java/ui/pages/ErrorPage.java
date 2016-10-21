package ui.pages;

import ui.fragments.Error;

import info.novatec.testit.webtester.conditions.pagefragments.Visible;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pagefragments.annotations.PostConstructMustBe;
import info.novatec.testit.webtester.pages.Page;


public interface ErrorPage extends Page {

    @IdentifyUsing("#error")
    @PostConstructMustBe(Visible.class)
    Error error();

    default String getErrorMessage() {
        return error().getMessage();
    }

}
