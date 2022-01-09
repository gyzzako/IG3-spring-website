package be.henallux.java.website.services;

import be.henallux.java.website.model.Discount;
import be.henallux.java.website.model.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DiscountService {

    @Autowired
    public DiscountService(){
    }

    public Float getPriceOnDiscount(ProductEntity product){
        if(isDiscountAvailable(product.getDiscount())){
            return product.getPrice() - (product.getPrice() * product.getDiscount().getPercentageOff()/100);
        }else {
            return product.getPrice();
        }
    }

    private boolean isDiscountAvailable(Discount discount){
        if(discount.getDiscountId() != null && discount.getPercentageOff() > 0 && discount.getPercentageOff() <= 100){ //ex: 20 -> 20% de réduction
            Date startDate = discount.getStartDate();
            Date endDate = discount.getEndDate();
            Date currentDate = new Date();
            return currentDate.getTime() >= startDate.getTime() && endDate.getTime() >= currentDate.getTime();
        }
        return false;
    }
}
