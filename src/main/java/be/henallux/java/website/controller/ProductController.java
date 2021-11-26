package be.henallux.java.website.controller;

import be.henallux.java.website.dataAccess.dao.CategoryDataAccess;
import be.henallux.java.website.dataAccess.dao.ProductDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/product/{id}")
public class ProductController {
    private ProductDataAccess productDAO;
    private CategoryDataAccess categoryDAO;

    @Autowired
    public ProductController(ProductDataAccess productDAO, CategoryDataAccess categoryDAO){
        this.productDAO = productDAO;
        this.categoryDAO = categoryDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String userRegistration(Model model, @PathVariable Integer id){
        model.addAttribute("categories", categoryDAO.getAllCategories()); //TODO: faire pour qu'on ne doive pas tout le temps faire appel à la db pour réafficher les catégories
        model.addAttribute("product", productDAO.getProductById(id));
        return "integrated:product";
    }

    @RequestMapping(value="/send", method=RequestMethod.POST)
    public String getFormData(Model model, @ModelAttribute(value="AddToCartForm") MagicKeyForm form)
}
