package be.henallux.java.website.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "discount")
public class DiscountEntity {

    @Id
    @Column(name = "discount_id")
    private Integer discount_id;

    @Column(name = "percentage_off")
    private Float percentage_off;

    @Column(name = "start_date")
    private java.util.Date start_date;

    @Column(name = "end_date")
    private java.util.Date end_date;

    //---Getters
    public Integer getDiscount_id() {
        return discount_id;
    }

    public Float getPercentage_off() {
        return percentage_off;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    //---Setters--

    public void setDiscount_id(Integer discount_id) {
        this.discount_id = discount_id;
    }


    public void setPercentage_off(Float percentage_off) {
        this.percentage_off = percentage_off;
    }


    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }


    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

}
