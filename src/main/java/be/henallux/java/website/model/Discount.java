package be.henallux.java.website.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class Discount {
    //region Attributs
    @NotNull
    @Min(value = 1)
    private Integer discount_id;

    @NotNull
    @Min(value = 1)
    private Float percentage_off;

    private Date start_date;
    private Date end_date;
    //endregion


    //region Constructors
    public Discount(Integer discount_id,Float percentage_off,Date start_date, Date end_date){
        setDiscount_id(discount_id);
        setEnd_date(end_date);
        setStart_date(start_date);
        setPercentage_off(percentage_off);
    }
    public Discount(){
        this(null, null, null, null);
    }
    //endregion


    //region GETTERS
    public Integer getDiscount_id(){
        return this.discount_id;
    }

    public Float getPercentage_off(){
        return this.percentage_off;
    }
    public Date getStart_date(){
        return this.start_date;
    }
    public Date getEnd_date(){
        return this.end_date;
    }
    //endregion


    //region SETTERS
    public void setDiscount_id(Integer discount_id){
        this.discount_id = discount_id;
    }
    public void setPercentage_off(Float percentage_off){
        this.percentage_off = percentage_off;
    }
    public void setStart_date(Date start_date){
        this.start_date = start_date;
    }
    public void setEnd_date(Date end_date){
        this.end_date = end_date;
    }
    //endregion
}
