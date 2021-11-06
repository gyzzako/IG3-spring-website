package be.henallux.java.website.controller;

import be.henallux.java.website.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("customerLogin",new Customer());
        return "integrated:login";
    }
}
