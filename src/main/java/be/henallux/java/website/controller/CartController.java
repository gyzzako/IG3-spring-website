package be.henallux.java.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value="/cart")
public class CartController {
    private MessageSource messageSource;

    @Autowired
    public CartController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String home(Model model, Locale locale){
        model.addAttribute("title", messageSource.getMessage("cart", new Object[0], locale));
        return "integrated:cart";
    }
}
