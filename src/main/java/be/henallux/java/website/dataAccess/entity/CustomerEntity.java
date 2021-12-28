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
    private String gender;

    @Column(name="authorities")
    private String authorities;

    @Column(name = "credentials_non_expired")
    private Boolean credentials_non_expired;

    @Column(name = "account_non_expired")
    private Boolean account_non_expired;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "non_locked")
    private Boolean non_locked;
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
    public String getGender(){
        return this.gender;
    }

    public String getAuthorities() {
        return authorities;
    }

    public Boolean getCredentials_non_expired() {
        return credentials_non_expired;
    }
    public Boolean getEnabled() {
        return enabled;
    }
    public Boolean getNon_locked() {
        return non_locked;
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
    public void setGender(String gender){
        this.gender = gender;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public void setCredentials_non_expired(Boolean credentials_non_expired) {
        this.credentials_non_expired = credentials_non_expired;
    }

    public Boolean getAccount_non_expired() {
        return account_non_expired;
    }

    public void setAccount_non_expired(Boolean account_non_expired) {
        this.account_non_expired = account_non_expired;
    }


    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setNon_locked(Boolean non_locked) {
        this.non_locked = non_locked;
    }
    //endregion



}
