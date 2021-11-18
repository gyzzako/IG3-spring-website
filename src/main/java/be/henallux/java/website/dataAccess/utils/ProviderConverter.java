package be.henallux.java.website.dataAccess.utils;

import be.henallux.java.website.dataAccess.entity.CategoryEntity;
import be.henallux.java.website.dataAccess.entity.CustomerEntity;
import be.henallux.java.website.dataAccess.entity.DiscountEntity;
import be.henallux.java.website.dataAccess.entity.LanguageEntity;
import be.henallux.java.website.model.Category;
import be.henallux.java.website.model.Customer;
import be.henallux.java.website.model.Discount;
import be.henallux.java.website.model.Language;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {


    //region Category converter
    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity){
        Category category = new Category();
        category.setCategory_id(categoryEntity.getCategory_id());
        return category;
    }
    //endregion

    //region Category converter
    public CustomerEntity customerModelToCustomerEntity(Customer customer){
        CustomerEntity customerEntity = new CustomerEntity();
        setCustomerAttributes(customerEntity, customer);
        return customerEntity;
    }

    public Customer customerEntityToCustomerModel(CustomerEntity customerEntity){
        Customer customer = new Customer();
        setCustomerAttributes(customer, customerEntity);
        return customer;
    }

    private void setCustomerAttributes(Object customerToFill, Object customerWithInfos){
        CustomerEntity customerToModify = null;
        Customer customerWithData = null;

        if(customerToFill.getClass().getName().equalsIgnoreCase("CustomerEntity") && customerWithInfos.getClass().getName().equalsIgnoreCase("Customer")){
            customerToModify = (CustomerEntity) customerToFill;
            customerWithData = (Customer) customerWithInfos;
        }else if(customerToFill.getClass().getName().equalsIgnoreCase("Customer") && customerWithInfos.getClass().getName().equalsIgnoreCase("CustomerEntity")){
            customerToModify = (CustomerEntity) customerWithInfos;
            customerWithData = (Customer) customerToFill;
        }

        if(customerToModify != null){
            customerToModify.setCustomer_id(customerWithData.getCustomer_id());
            customerToModify.setEmail(customerWithData.getEmail());
            customerToModify.setFirstname(customerWithData.getFirstname());
            customerToModify.setLastname(customerWithData.getLastname());
            customerToModify.setPhone_number(customerWithData.getPhone_number());
            customerToModify.setAddress(customerWithData.getAddress());
            customerToModify.setPassword(customerWithData.getPassword());
            customerToModify.setIsMale(customerWithData.getIsMale());
        }
    }
    //endregion


    //region Discount converter
    public Discount discountEntityToDiscountModel(DiscountEntity discountEntity){
        Discount discount = new Discount();
        discount.setDiscount_id(discountEntity.getDiscount_id());
        discount.setPercentage_off(discountEntity.getPercentage_off());
        discount.setStart_date(discountEntity.getStart_date());
        discount.setEnd_date(discountEntity.getEnd_date());
        return discount;
    }
    //endregion


    //region Discount converter
    public Language languageEntityToLanguageModel(LanguageEntity languageEntity){
        Language language = new Language();
        language.setLanguage_id(languageEntity.getLanguage_id());
        return language;
    }
    //endregion

}
