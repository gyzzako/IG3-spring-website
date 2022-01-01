package be.henallux.java.website.dataAccess.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customer")
public class CustomerEntity {
    //region Attributs
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;


    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private String gender;

    @Column(name="authorities")
    private String authorities;

    @Column(name = "credentials_non_expired")
    private Boolean credentialsNonExpired;

    @Column(name = "account_non_expired")
    private Boolean accountNonExpired;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "non_locked")
    private Boolean nonLocked;
    //endregion

    public CustomerEntity(){

    }

    //region GETTERS

    public Integer getCustomerId() {
        return customerId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getAuthorities() {
        return authorities;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public Boolean getNonLocked() {
        return nonLocked;
    }
    //endregion



    //region SETTERS

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        if(gender.equals("")){ // car gender peut être vide depuis le formulaire car champs optionnel
            this.gender = null;
        }else{
            this.gender = gender;
        }
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setNonLocked(Boolean nonLocked) {
        this.nonLocked = nonLocked;
    }

    //endregion
}
