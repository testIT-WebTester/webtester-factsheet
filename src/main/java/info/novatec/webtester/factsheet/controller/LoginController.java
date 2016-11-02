package info.novatec.webtester.factsheet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import info.novatec.webtester.factsheet.controller.exceptions.CredentialsException;
import info.novatec.webtester.factsheet.controller.model.ErrorData;
import info.novatec.webtester.factsheet.controller.model.Credentials;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("credentials", new Credentials());
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute Credentials credentials) {
        assertUsername(credentials);
        assertPassword(credentials);
        return "main";
    }

    private void assertUsername(@ModelAttribute Credentials form) {
        String username = form.getUsername();
        if (!"tester_de".equals(username)) {
            throw new CredentialsException("Unknown user: '" + username + "'");
        }
    }

    private void assertPassword(@ModelAttribute Credentials form) {
        String password = form.getPassword();
        if (!"123456".equals(password)) {
            throw new CredentialsException("Wrong password!");
        }
    }

    @ExceptionHandler(CredentialsException.class)
    public String handleException(CredentialsException exception, Model model) {
        ErrorData error = new ErrorData();
        error.setMessage(exception.getMessage());
        model.addAttribute("error", error);
        return "error";
    }

}
