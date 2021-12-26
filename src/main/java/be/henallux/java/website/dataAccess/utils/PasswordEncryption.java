package be.henallux.java.website.dataAccess.utils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncryption {

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public String cryptPassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }
}
