package pages;

import info.novatec.testit.webtester.conditions.pagefragments.PresentAndVisible;
import info.novatec.testit.webtester.pagefragments.PageFragment;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pagefragments.annotations.Mapping;
import info.novatec.testit.webtester.pagefragments.annotations.PostConstructMustBe;
import info.novatec.testit.webtester.pages.Page;


public interface ErrorPage extends Page {

    @PostConstructMustBe(PresentAndVisible.class)
    @IdentifyUsing("#error")
    Error error();

    @Mapping(tag = "div")
    interface Error extends PageFragment {

        default String getMessage() {
            return find("#message").getVisibleText();
        }

    }

}
