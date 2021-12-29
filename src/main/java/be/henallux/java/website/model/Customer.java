package be.henallux.java.website.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Customer implements UserDetails {
    //region Attributs
    @Min(value = 1)
    private Integer customer_id;

    @NotNull
    @Size(min = 5, max = 50)
    private String username;

    @NotNull(message = "le mot de passe est obligatoire !")
    @Size(min = 5, max = 50)
    private String password;

    @NotNull
    @Size(min = 2, max = 50)
    private String firstname;

    @NotNull
    @Size(min = 2, max = 50)
    private String lastname;

    @Size(max = 10)
    private String phone_number;

    @NotNull
    @Size(min = 5, max = 50)
    private String address;

    @NotNull
    @Size(min = 4, max = 10)
    private String gender;

    private String authorities;
    private Boolean credentials_non_expired;
    private Boolean enabled;
    private Boolean account_non_locked;
    private Boolean account_non_expired;
    //endregion


    //region Constructors
    public Customer(Integer customer_id, String username, String password, String lastname, String firstname, String phone_number, String address, String gender,String authorities,
                    Boolean credentials_non_expired,Boolean enabled,Boolean account_non_expired,Boolean account_non_locked){
        setCustomer_id(customer_id);
        setFirstname(firstname);
        setLastname(lastname);
        setPhone_number(phone_number);
        setAddress(address);
        setPassword(password);
        setGender(gender);
        setUsername(username);
        this.enabled = enabled;
        this.authorities = authorities;
        this.account_non_expired = account_non_expired;
        this.account_non_locked = account_non_locked;
        this.credentials_non_expired = credentials_non_expired;

    }

    // il nous faut au moins un constructeur vide.
    public Customer(){
    }
    //endregion


    //region GETTERS
    public Integer getCustomer_id(){
        return this.customer_id;
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
        return this.address;
    }
    public String getGender(){
        return this.gender;
    }

    // -- session informations
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if(authorities != null && !authorities.isEmpty()){
            String[] authoritiesArray = authorities.split(",");

            for(String authority : authoritiesArray){
                if(authority != null && !authorities.isEmpty()){
                    grantedAuthorities.add(new SimpleGrantedAuthority(authority));
                }
            }
        }
        return grantedAuthorities;
    }

    public String getAuthoritiesInString(){
        return authorities;
    }

    public String getPassword(){
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.account_non_expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.account_non_locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentials_non_expired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
    //endregion


    //region SETTERS
    public void setCustomer_id(Integer customer_id){
        this.customer_id = customer_id;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public void setCredentials_non_expired(Boolean credentials_non_expired) {
        this.credentials_non_expired = credentials_non_expired;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setAccount_non_locked(Boolean account_non_locked) {
        this.account_non_locked = account_non_locked;
    }

    public void setAccount_non_expired(Boolean account_non_expired) {
        this.account_non_expired = account_non_expired;
    }

    //endregion


}
