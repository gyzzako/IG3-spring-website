package be.henallux.java.website.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class Discount {
    //region Attributs
    @NotNull
    @Min(value = 1)
    private Integer discountId;

    @NotNull
    @Min(value = 1)
    private Float percentageOff;

    private Date startDate;
    private Date endDate;
    //endregion


    //region Constructors
    public Discount(Integer discountId,Float percentageOff,Date startDate, Date endDate){
        setDiscountId(discountId);
        setEndDate(endDate);
        setStartDate(startDate);
        setPercentageOff(percentageOff);
    }
    public Discount(){

    }
    //endregion


    //region GETTERS
    public Integer getDiscountId(){
        return this.discountId;
    }

    public Float getPercentageOff(){
        return this.percentageOff;
    }
    public Date getStartDate(){
        return this.startDate;
    }
    public Date getEndDate(){
        return this.endDate;
    }
    //endregion


    //region SETTERS
    public void setDiscountId(Integer discountId){
        this.discountId = discountId;
    }
    public void setPercentageOff(Float percentageOff){
        this.percentageOff = percentageOff;
    }
    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }
    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }
    //endregion
}
