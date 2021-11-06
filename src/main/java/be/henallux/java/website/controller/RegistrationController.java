package be.henallux.java.website.controller;

import be.henallux.java.website.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

    @RequestMapping(method = RequestMethod.GET)
    public String userRegistration(Model model){
        model.addAttribute("registrationForm",new Customer());
        return "integrated:registration";
    }
}
