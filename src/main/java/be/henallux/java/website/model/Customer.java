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
    private Integer customerId;

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
    private String phoneNumber;

    @NotNull
    @Size(min = 5, max = 50)
    private String address;

    @NotNull
    @Size(min = 4, max = 10)
    private String gender;

    private String authorities;
    private Boolean credentialsNonExpired;
    private Boolean enabled;
    private Boolean accountNonLocked;
    private Boolean accountNonExpired;
    //endregion


    //region Constructors
    public Customer(Integer customerId, String username, String password, String lastname, String firstname, String phoneNumber, String address, String gender,String authorities,
                    Boolean credentialsNonExpired,Boolean enabled,Boolean accountNonExpired,Boolean accountNonLocked){
        setCustomerId(customerId);
        setFirstname(firstname);
        setLastname(lastname);
        setPhoneNumber(phoneNumber);
        setAddress(address);
        setPassword(password);
        setGender(gender);
        setUsername(username);
        this.enabled = enabled;
        this.authorities = authorities;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;

    }

    public Customer(){
    }
    //endregion


    //region GETTERS
    public Integer getCustomerId(){
        return this.customerId;
    }
    public String getLastname(){
        return this.lastname;
    }
    public String getFirstname(){
        return this.firstname;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
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
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
    //endregion


    //region SETTERS
    public void setCustomerId(Integer customerId){
        this.customerId = customerId;
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
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
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

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    //endregion


}
