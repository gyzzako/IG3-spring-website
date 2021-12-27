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
    @NotNull
    @Min(value = 1)
    private Integer customer_id;

    @NotNull
    @Size(min = 5, max = 45)
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String username;

    @NotNull
    @Size(min = 10, max = 50)
    @Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@" +
            "(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+" +
            "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    private String email;

    @NotNull
    @Size(min = 8, max = 50)
    private String password;

    @NotNull
    @Size(min = 5, max = 50)
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String firstname;

    @NotNull
    @Size(min = 5, max = 50)
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String lastname;

    @Max(value = 10)
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
    public Customer(Integer customer_id, String email, String password, String lastname, String firstname, String phone_number, String address, String gender){
        setCustomer_id(customer_id);
        setEmail(email);
        setFirstname(firstname);
        setLastname(lastname);
        setPhone_number(phone_number);
        setAddress(address);
        setPassword(password);
        setGender(gender);
    }
    public Customer(){
        this(null, null, null, null, null, null, null, null);
    }
    //endregion


    //region GETTERS
    public Integer getCustomer_id(){
        return this.customer_id;
    }
    public String getEmail(){
        return this.email;
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

    //endregion

    // ------méthodes implementées de l'interface UserDetails de spring. -> voir labo 7
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

}
