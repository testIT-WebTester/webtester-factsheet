package ui.fragments;

import info.novatec.testit.webtester.pagefragments.PageFragment;
import info.novatec.testit.webtester.pagefragments.annotations.Mapping;


@Mapping(tag = "div", attribute = "class", values = "error")
public interface Error extends PageFragment {

    default String getMessage() {
        return find("#message").getVisibleText();
    }

}
