package be.henallux.java.website.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {
    //region Attributs
    @Id
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "brand")
    private String brand;

    @JoinColumn(name = "discount_fk", referencedColumnName = "discount_id")
    @ManyToOne
    private DiscountEntity discount;

    @JoinColumn(name = "category_fk", referencedColumnName = "category_id")
    @ManyToOne
    private CategoryEntity category;

    @Column(name = "price")
    private Float price;

    @Column(name = "image")
    private String imageName;
    //endregion

    public ProductEntity(){

    }

    //region GETTERS

    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public DiscountEntity getDiscount() {
        return discount;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public Float getPrice() {
        return price;
    }

    public String getImageName() {
        return imageName;
    }

    //endregion


    //region SETTERS

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDiscount(DiscountEntity discount) {
        this.discount = discount;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    //endregion
}
