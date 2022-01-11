package be.henallux.java.website.dataAccess.utils;

import be.henallux.java.website.dataAccess.entity.*;
import be.henallux.java.website.model.*;
import be.henallux.java.website.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {


    //region Category converter
    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity){
        Category category = new Category();
        category.setCategoryId(categoryEntity.getCategoryId());
        return category;
    }

    public CategoryEntity categoryModelToCategoryEntity(Category category){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(category.getCategoryId());
        return categoryEntity;
    }
    //endregion

    //region Customer converter
    public CustomerEntity customerModelToCustomerEntity(Customer customer){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setPassword(customer.getPassword());
        customerEntity.setCustomerId(customer.getCustomerId());
        customerEntity.setUsername(customer.getUsername());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setFirstname(customer.getFirstname());
        customerEntity.setLastname(customer.getLastname());
        customerEntity.setPhoneNumber(customer.getPhoneNumber());
        customerEntity.setAddress(customer.getAddress());
        customerEntity.setGender(customer.getGender());
        customerEntity.setAuthorities(customer.getAuthoritiesInString());
        customerEntity.setEnabled(customer.isEnabled());
        customerEntity.setNonLocked(customer.isAccountNonLocked());
        customerEntity.setAccountNonExpired(customer.isAccountNonExpired());
        customerEntity.setCredentialsNonExpired(customer.isCredentialsNonExpired());
        return customerEntity;
    }

    public Customer customerEntityToCustomerModel(CustomerEntity customerEntity){
        Customer customer = new Customer();
        customer.setCustomerId(customerEntity.getCustomerId());
        customer.setEmail(customerEntity.getEmail());
        customer.setUsername(customerEntity.getUsername());
        customer.setFirstname(customerEntity.getFirstname());
        customer.setLastname(customerEntity.getLastname());
        customer.setPhoneNumber(customerEntity.getPhoneNumber());
        customer.setAddress(customerEntity.getAddress());
        customer.setPassword(customerEntity.getPassword());
        customer.setGender(customerEntity.getGender());
        customer.setAuthorities(customerEntity.getAuthorities());
        customer.setEnabled(customerEntity.getEnabled());
        customer.setAuthorities(customerEntity.getAuthorities());
        customer.setCredentialsNonExpired(customerEntity.getCredentialsNonExpired());
        customer.setAccountNonLocked(customerEntity.getNonLocked());
        customer.setAccountNonExpired(customerEntity.getAccountNonExpired());
        return customer;
    }
    //endregion


    //region Discount converter
    public Discount discountEntityToDiscountModel(DiscountEntity discountEntity){
        Discount discount = new Discount();
        if(discountEntity != null){
            discount.setDiscountId(discountEntity.getDiscountId());
            discount.setPercentageOff(discountEntity.getPercentageOff());
            discount.setStartDate(discountEntity.getStartDate());
            discount.setEndDate(discountEntity.getEndDate());
        }
        return discount;
    }

    public DiscountEntity discountModelToDiscountEntity(Discount discount){
        DiscountEntity discountEntity = new DiscountEntity();
        discountEntity.setDiscountId(discount.getDiscountId());
        discountEntity.setPercentageOff(discount.getPercentageOff());
        discountEntity.setStartDate(discount.getStartDate());
        discountEntity.setEndDate(discount.getEndDate());
        return discountEntity;
    }
    //endregion


    //region Language converter
    public Language languageEntityToLanguageModel(LanguageEntity languageEntity){
        Language language = new Language();
        language.setLanguageId(languageEntity.getLanguageId());
        return language;
    }

    public LanguageEntity languageModelToLanguageEntity(Language language){
        LanguageEntity languageEntity = new LanguageEntity();
        languageEntity.setLanguageId(language.getLanguageId());
        return languageEntity;
    }
    //endregion

    //region Order converter
    public OrderEntity orderModelToOrderEntity(Order order){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(order.getOrderId());
        orderEntity.setOrderDate(order.getOrderDate());
        orderEntity.setDeliveryDate(order.getDeliveryDate());
        orderEntity.setIsOrderPaid(order.getIsOrderPaid());
        orderEntity.setCustomer(customerModelToCustomerEntity(order.getCustomer()));
        return orderEntity;
    }

    public Order orderEntityToOrderModel(OrderEntity orderEntity){
        Order order = new Order();
        order.setOrderId(orderEntity.getOrderId());
        order.setOrderDate(orderEntity.getOrderDate());
        order.setDeliveryDate(orderEntity.getDeliveryDate());
        order.setIsOrderPaid(orderEntity.getIsOrderPaid());
        order.setCustomer(customerEntityToCustomerModel(orderEntity.getCustomer()));
        return order;
    }
    //endregion


    //region OrderLine converter
    public OrderLineEntity orderLineModelToOrderLineEntity(OrderLine orderLine){
        OrderLineEntity orderLineEntity = new OrderLineEntity();
        orderLineEntity.setOrderLineId(orderLine.getOrderLineId());
        orderLineEntity.setQuantity(orderLine.getQuantity());
        orderLineEntity.setRealPrice(orderLine.getRealPrice());
        orderLineEntity.setOrder(orderModelToOrderEntity(orderLine.getOrder()));
        orderLineEntity.setProduct(productModelToProductEntity(orderLine.getProduct()));
        return orderLineEntity;
    }

    public OrderLine orderLineEntityToOrderLineModel(OrderLineEntity orderLineEntity){
        OrderLine orderLine = new OrderLine();
        orderLine.setOrderLineId(orderLineEntity.getOrderLineId());
        orderLine.setQuantity(orderLineEntity.getQuantity());
        orderLine.setRealPrice(orderLineEntity.getRealPrice());
        orderLine.setOrder(orderEntityToOrderModel(orderLineEntity.getOrder()));
        orderLine.setProduct(productEntityToProductModel(orderLineEntity.getProduct()));
        return orderLine;
    }
    //endregion

    //region Product converter
    public ProductEntity productModelToProductEntity(Product product){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(product.getProductId());
        productEntity.setProductName(product.getProductName());
        productEntity.setBrand(product.getBrand());
        productEntity.setPrice(product.getPrice());
        productEntity.setDescription(product.getDescription());
        productEntity.setCategory(categoryModelToCategoryEntity(product.getCategory()));
        productEntity.setDiscount(discountModelToDiscountEntity(product.getDiscount()));
        productEntity.setImageName(product.getImageName());
        return productEntity;
    }

    public Product productEntityToProductModel(ProductEntity productEntity){
        Product product = new Product();
        product.setProductId(productEntity.getProductId());
        product.setProductName(productEntity.getProductName());
        product.setBrand(productEntity.getBrand());
        product.setPrice(productEntity.getPrice());
        product.setDescription(productEntity.getDescription());
        product.setCategory(categoryEntityToCategoryModel(productEntity.getCategory()));
        product.setDiscount(discountEntityToDiscountModel(productEntity.getDiscount()));
        product.setImageName(productEntity.getImageName());
        return product;
    }
    //endregion

    //region Translation converter
    public TranslationEntity translationModelToTranslationEntity(Translation translation){
        TranslationEntity translationEntity = new TranslationEntity();
        translationEntity.setTranslationId(translation.getTranslationId());
        translationEntity.setLabel(translation.getLabel());
        translationEntity.setCategory(categoryModelToCategoryEntity(translation.getCategory()));
        translationEntity.setLanguage(languageModelToLanguageEntity(translation.getLanguage()));
        return translationEntity;
    }

    public Translation translationEntityToTranslationModel(TranslationEntity translationEntity){
        Translation translation = new Translation();
        translation.setTranslationId(translationEntity.getTranslationId());
        translation.setLabel(translationEntity.getLabel());
        translation.setLanguage(languageEntityToLanguageModel(translationEntity.getLanguage()));
        translation.setCategory(categoryEntityToCategoryModel(translationEntity.getCategory()));
        return translation;
    }
    //endregion


}
