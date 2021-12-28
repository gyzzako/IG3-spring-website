package be.henallux.java.website.controller;

import be.henallux.java.website.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

    @RequestMapping(method = RequestMethod.GET)
    public String userRegistration(Model model, Locale locale){
        System.out.println("je suis dans le controller");
        model.addAttribute("registrationForm",new Customer());
        return "integrated:registration";
    }
}
