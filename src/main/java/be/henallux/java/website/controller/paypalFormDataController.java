package be.henallux.java.website.controller;

import be.henallux.java.website.Constants;
import be.henallux.java.website.model.Cart;
import be.henallux.java.website.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping(value="/paypalFormData")
@SessionAttributes({Constants.CURRENT_CART})
public class paypalFormDataController {

    @Autowired
    public paypalFormDataController(){
    }

    @ModelAttribute(Constants.CURRENT_CART)
    public Cart cart(){
        return new Cart();
    }

    @RequestMapping(method= RequestMethod.GET)
    public String home(Model model, @ModelAttribute(value= Constants.CURRENT_CART) Cart cart){
        model.addAttribute("cart", cart);
        model.addAttribute("cartItem",new CartItem());
        return "integrated:paypalFormData";
    }
}