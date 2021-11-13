package be.henallux.java.website.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @Column(name = "product_id")
    private Integer product_id;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "description")
    private String description;

    @Column(name = "brand")
    private String brand;

    @JoinColumn(name = "discount_fk", referencedColumnName = "discount_id")
    @ManyToOne
    private DiscountEntity discount_fk;

    @JoinColumn(name = "category_fk", referencedColumnName = "category_id")
    @ManyToOne
    private CategoryEntity category_fk;

    @Column(name = "price")
    private Float price;

    //---Getters
    public Integer getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public DiscountEntity getDiscount_fk() {
        return discount_fk;
    }

    public CategoryEntity getCategory_fk() {
        return category_fk;
    }
    public Float getPrice() {
        return price;
    }
    //---Setters

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }


    public void setDiscount_fk(DiscountEntity discount_fk) {
        this.discount_fk = discount_fk;
    }


    public void setCategory_fk(CategoryEntity category_fk) {
        this.category_fk = category_fk;
    }


    public void setPrice(Float price) {
        this.price = price;
    }
}
