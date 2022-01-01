package be.henallux.java.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class WebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsiteApplication.class, args);
	}

}
