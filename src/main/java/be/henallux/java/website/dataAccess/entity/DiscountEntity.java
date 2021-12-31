package be.henallux.java.website.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "discount")
public class DiscountEntity {
    //region Attributs
    @Id
    @Column(name = "discount_id")
    private Integer discountId;

    @Column(name = "percentage_off")
    private Float percentageOff;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;
    //endregion


    public DiscountEntity(){

    }


    //region GETTERS

    public Integer getDiscountId() {
        return discountId;
    }

    public Float getPercentageOff() {
        return percentageOff;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    //endregion



    //region SETTERS

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public void setPercentageOff(Float percentageOff) {
        this.percentageOff = percentageOff;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    //endregion

}
