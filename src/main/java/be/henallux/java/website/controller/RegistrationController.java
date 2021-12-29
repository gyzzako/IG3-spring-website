package be.henallux.java.website.controller;

import be.henallux.java.website.Constants;
import be.henallux.java.website.dataAccess.dao.CustomerDAO;
import be.henallux.java.website.dataAccess.dao.CustomerDataAccess;
import be.henallux.java.website.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping(value = "/registration")
@SessionAttributes({Constants.CURRENT_USER})
public class RegistrationController {

    private CustomerDataAccess customerDAO;

    @Autowired
    public RegistrationController(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }

    @ModelAttribute(Constants.CURRENT_USER)
    public Customer customer(){
        return new Customer();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String userRegistration(Model model, Locale locale){
        model.addAttribute("registrationForm",new Customer());
        model.addAttribute("title","Inscription");
        return "integrated:registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getUserFormData(Model model, @Valid @ModelAttribute(value =Constants.CURRENT_USER) Customer customer, final BindingResult errors){

        //checker si l'utilisateur qu'on veut inscrire existe dejà dans la bd, si oui alors on renvoie une erreur/message.
        Customer customerExistsCheck = customerDAO.findByUsername(customer.getUsername());
        if(customerExistsCheck != null){
            model.addAttribute("customerExists","ce client existe dejà !");
        }
        // l'inscription ne se fait que s'il n'y a aucune erreur.
        if(!errors.hasErrors() && !model.containsAttribute("customerExists")){
            customerDAO.save(customer);
            return "redirect:/";
        }
        model.addAttribute("errors",errors);
        return "integrated:registration";
    }
}
