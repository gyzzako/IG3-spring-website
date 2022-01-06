package be.henallux.java.website.controller;

import be.henallux.java.website.Constants;
import be.henallux.java.website.model.Customer;
import be.henallux.java.website.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping(value = "/registration")
@SessionAttributes({Constants.CURRENT_USER})
public class RegistrationController {

    private CustomerService customerService;
    private MessageSource messageSource;

    @Autowired
    public RegistrationController(CustomerService customerService, MessageSource messageSource){
        this.customerService = customerService;
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
        model.addAttribute("mandatory",messageSource.getMessage("mandatoryMessage",new Object[0],locale));
        return "integrated:registration";
    }

    @RequestMapping( method = RequestMethod.POST)
    public String getUserFormData(Model model,Locale locale, @Valid @ModelAttribute(value =Constants.CURRENT_USER) Customer customer, final BindingResult errors){

        //vérifie si les deux mots de passes sont les identiques
        if(!customer.getMatchingPassword().equals(customer.getPassword())) {
            model.addAttribute("passwordDontMatch", messageSource.getMessage("passwordDontMatch",new Object[0],locale));
        }

        if(!errors.hasErrors() && !model.containsAttribute("passwordDontMatch")){
            boolean isRegistered = customerService.saveCustomer(customer);
            if(isRegistered){
                return "redirect:/";
            }else{
                model.addAttribute("customerExists", messageSource.getMessage("userAlreadyExist", new Object[0], locale));
                return "integrated:registration";
            }
        }
        model.addAttribute("errors",errors);
        return "integrated:registration";
    }

}
