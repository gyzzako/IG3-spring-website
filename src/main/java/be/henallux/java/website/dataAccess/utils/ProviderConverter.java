package be.henallux.java.website.dataAccess.utils;

import be.henallux.java.website.dataAccess.entity.*;
import be.henallux.java.website.model.*;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {


    //region Category converter
    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity){
        Category category = new Category();
        category.setCategory_id(categoryEntity.getCategory_id());
        return category;
    }

    public CategoryEntity categoryModelToCategoryEntity(Category category){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategory_id(category.getCategory_id());
        return categoryEntity;
    }
    //endregion

    //region Category converter
    public CustomerEntity customerModelToCustomerEntity(Customer customer){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomer_id(customer.getCustomer_id());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setFirstname(customer.getFirstname());
        customerEntity.setLastname(customer.getLastname());
        customerEntity.setPhoneNumber(customer.getPhone_number());
        customerEntity.setAddress(customer.getAddress());
        customerEntity.setPassword(customer.getPassword());
        customerEntity.setGender(customer.getGender());
        //customerEntity.setAuthorities(customer.getAuthorities());
        customerEntity.setEnabled(customer.isEnabled());
        customerEntity.setNon_locked(customer.isAccountNonLocked());
        customerEntity.setAccount_non_expired(customer.isAccountNonExpired());
        customerEntity.setCredentials_non_expired(customer.isCredentialsNonExpired());
        return customerEntity;
    }

    public Customer customerEntityToCustomerModel(CustomerEntity customerEntity){
        Customer customer = new Customer();
        customer.setCustomer_id(customerEntity.getCustomer_id());
        customer.setEmail(customerEntity.getEmail());
        customer.setFirstname(customerEntity.getFirstname());
        customer.setLastname(customerEntity.getLastname());
        customer.setPhone_number(customerEntity.getPhoneNumber());
        customer.setAddress(customerEntity.getAddress());
        customer.setPassword(customerEntity.getPassword());
        customer.setGender(customerEntity.getGender());

        customer.setEnabled(customerEntity.getEnabled());
        customer.setAuthorities(customerEntity.getAuthorities());
        customer.setCredentials_non_expired(customerEntity.getCredentials_non_expired());
        customer.setAccount_non_locked(customerEntity.getNon_locked());
        customer.setAccount_non_expired(customerEntity.getAccount_non_expired());
        return customer;
    }
    //endregion


    //region Discount converter
    public Discount discountEntityToDiscountModel(DiscountEntity discountEntity){
        Discount discount = new Discount();
        if(discountEntity != null){
            discount.setDiscount_id(discountEntity.getDiscount_id());
            discount.setPercentage_off(discountEntity.getPercentage_off());
            discount.setStart_date(discountEntity.getStart_date());
            discount.setEnd_date(discountEntity.getEnd_date());
        }
        return discount;
    }

    public DiscountEntity discountModelToDiscountEntity(Discount discount){
        DiscountEntity discountEntity = new DiscountEntity();
        discountEntity.setDiscount_id(discount.getDiscount_id());
        discountEntity.setPercentage_off(discount.getPercentage_off());
        discountEntity.setStart_date(discount.getStart_date());
        discountEntity.setEnd_date(discount.getEnd_date());
        return discountEntity;
    }
    //endregion


    //region Language converter
    public Language languageEntityToLanguageModel(LanguageEntity languageEntity){
        Language language = new Language();
        language.setLanguage_id(languageEntity.getLanguage_id());
        return language;
    }

    public LanguageEntity languageModelToLanguageEntity(Language language){
        LanguageEntity languageEntity = new LanguageEntity();
        languageEntity.setLanguage_id(language.getLanguage_id());
        return languageEntity;
    }
    //endregion

    //region Order converter
    public OrderEntity orderModelToOrderEntity(Order order){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrder_id(order.getOrder_id());
        orderEntity.setOrder_date(order.getOrder_date());
        orderEntity.setIs_order_paid(order.getIs_order_paid());
        orderEntity.setCustomer_fk(customerModelToCustomerEntity(order.getCustomer()));
        orderEntity.setDelivery_date(order.getDelivery_date());
        return orderEntity;
    }

    public Order orderEntityToOrderModel(OrderEntity orderEntity){
        Order order = new Order();
        order.setOrder_id(orderEntity.getOrder_id());
        order.setOrder_date(orderEntity.getOrder_date());
        order.setIs_order_paid(orderEntity.getIs_order_paid());
        order.setCustomer(customerEntityToCustomerModel(orderEntity.getCustomer_fk()));
        order.setDelivery_date(orderEntity.getDelivery_date());
        return order;
    }
    //endregion


    //region OrderLine converter
    public OrderLineEntity orderLineModelToOrderLineEntity(OrderLine orderLine){
        OrderLineEntity orderLineEntity = new OrderLineEntity();
        orderLineEntity.setOrder_line_id(orderLine.getOrder_line_id());
        orderLineEntity.setQuantity(orderLine.getQuantity());
        orderLineEntity.setReal_price(orderLine.getReal_price());
        orderLineEntity.setOrder_fk(orderModelToOrderEntity(orderLine.getOrder()));
        orderLineEntity.setProduct_fk(productModelToProductEntity(orderLine.getProduct()));
        return orderLineEntity;
    }

    public OrderLine orderLineEntityToOrderLineModel(OrderLineEntity orderLineEntity){
        OrderLine orderLine = new OrderLine();
        orderLine.setOrder_line_id(orderLineEntity.getOrder_line_id());
        orderLine.setQuantity(orderLineEntity.getQuantity());
        orderLine.setReal_price(orderLineEntity.getReal_price());
        orderLine.setOrder(orderEntityToOrderModel(orderLineEntity.getOrder_fk()));
        orderLine.setProduct(productEntityToProductModel(orderLineEntity.getProduct_fk()));
        return orderLine;
    }
    //endregion

    //region Product converter
    public ProductEntity productModelToProductEntity(Product product){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProduct_id(product.getProduct_id());
        productEntity.setProduct_name(product.getProduct_name());
        productEntity.setBrand(product.getBrand());
        productEntity.setPrice(product.getPrice());
        productEntity.setDescription(product.getDescription());
        productEntity.setCategory_fk(categoryModelToCategoryEntity(product.getCategory_fk()));
        productEntity.setDiscount_fk(discountModelToDiscountEntity(product.getDiscount_fk()));
        productEntity.setImageName(product.getImageName());
        return productEntity;
    }

    public Product productEntityToProductModel(ProductEntity productEntity){
        Product product = new Product();
        product.setProduct_id(productEntity.getProduct_id());
        product.setProduct_name(productEntity.getProduct_name());
        product.setBrand(productEntity.getBrand());
        product.setPrice(productEntity.getPrice());
        product.setDescription(productEntity.getDescription());
        product.setCategory_fk(categoryEntityToCategoryModel(productEntity.getCategory_fk()));
        product.setDiscount_fk(discountEntityToDiscountModel(productEntity.getDiscount_fk()));
        product.setImageName(productEntity.getImageName());
        return product;
    }
    //endregion

    //region Translation converter
    public TranslationEntity translationModelToTranslationEntity(Translation translation){
        TranslationEntity translationEntity = new TranslationEntity();
        translationEntity.setTranslation_id(translation.getTranslation_id());
        translationEntity.setLabel(translation.getLabel());
        translationEntity.setCategory_fk(categoryModelToCategoryEntity(translation.getCategory()));
        translationEntity.setLanguage_fk(languageModelToLanguageEntity(translation.getLanguage()));
        return translationEntity;
    }

    public Translation translationEntityToTranslationModel(TranslationEntity translationEntity){
        Translation translation = new Translation();
        translation.setTranslation_id(translationEntity.getTranslation_id());
        translation.setLabel(translationEntity.getLabel());
        translation.setLanguage(languageEntityToLanguageModel(translationEntity.getLanguage_fk()));
        translation.setCategory(categoryEntityToCategoryModel(translationEntity.getCategory_fk()));
        return translation;
    }
    //endregion


}
