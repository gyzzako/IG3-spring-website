package be.henallux.java.website.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity {
    //region Attributs
    @Id
    @Column(name = "customer_id")
    private Integer customer_id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "phone_numnber")
    private String phone_number;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private Boolean isMale;
    //endregion

    public CustomerEntity(){

    }

    //region GETTERS
    public Integer getCustomer_id(){
        return this.customer_id;
    }

    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }

    public String getLastname(){
        return this.lastname;
    }

    public String getFirstname(){
        return this.firstname;
    }

    public String getPhone_number(){
        return this.phone_number;
    }
    public String getAddress(){
        return  this.address;
    }
    public Boolean getIsMale(){
        return this.isMale;
    }
    //endregion



    //region SETTERS
    public void setCustomer_id(Integer customer_id){
        this.customer_id = customer_id;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    public void setPhone_number(String phone_number){
        this.phone_number = phone_number;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setIsMale(Boolean isMale){
        this.isMale = isMale;
    }
    //endregion
}
