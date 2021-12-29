package be.henallux.java.website.controller;

import be.henallux.java.website.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
@RequestMapping(value = "/login")
public class LoginController {


    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model, Locale locale,@RequestParam(required = false)String error){
        if(error != null){
            model.addAttribute("badCredentials","mot de passe ou email non valide !");
        }
        model.addAttribute("title","Se connecter");
        model.addAttribute("customerLogin",new Customer());
        return "integrated:login";
    }
}
