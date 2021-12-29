package be.henallux.java.website.controller;

import be.henallux.java.website.Constants;
import be.henallux.java.website.dataAccess.dao.CustomerDAO;
import be.henallux.java.website.dataAccess.dao.CustomerDataAccess;
import be.henallux.java.website.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
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
    private MessageSource messageSource;

    @Autowired
    public RegistrationController(CustomerDAO customerDAO, MessageSource messageSource){
        this.customerDAO = customerDAO;
        this.messageSource = messageSource;
    }

    @ModelAttribute(Constants.CURRENT_USER)
    public Customer customer(){
        return new Customer();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String userRegistration(Model model, Locale locale){
        model.addAttribute("registrationForm",new Customer());
        model.addAttribute("title", messageSource.getMessage("signup", new Object[0], locale));
        return "integrated:registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getUserFormData(Model model, @Valid @ModelAttribute(value =Constants.CURRENT_USER) Customer customer, final BindingResult errors, Locale locale){

        //checker si l'utilisateur qu'on veut inscrire existe dejà dans la bd, si oui alors on renvoie une erreur/message.
        Customer customerExistsCheck = customerDAO.findByUsername(customer.getUsername());
        if(customerExistsCheck != null){
            model.addAttribute("customerExists", messageSource.getMessage("userAlreadyExist", new Object[0], locale));
            return "integrated:registration";
        }
        customer.setAuthorities("ROLE_USER");
        customer.setCredentials_non_expired(true);
        customer.setEnabled(true);
        customer.setAccount_non_locked(true);
        customer.setAccount_non_expired(true);

        // l'inscription ne se fait que s'il n'y a aucune erreur.
        if(!errors.hasErrors()){
            customerDAO.save(customer);
            return "redirect:/";
        }
        model.addAttribute("errors",errors);
        return "integrated:registration";
    }
}
