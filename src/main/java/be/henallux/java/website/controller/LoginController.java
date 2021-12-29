package be.henallux.java.website.controller;

import be.henallux.java.website.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private MessageSource messageSource;

    @Autowired
    public LoginController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model, Locale locale,@RequestParam(required = false)String error){
        if(error != null){
            model.addAttribute("badCredentials",messageSource.getMessage("invalidLogin", new Object[0], locale));
        }
        model.addAttribute("title", messageSource.getMessage("login", new Object[0], locale));
        model.addAttribute("customerLogin",new Customer());
        return "integrated:login";
    }
}
