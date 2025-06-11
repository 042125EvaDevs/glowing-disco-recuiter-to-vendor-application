package xyz.catuns.recruiter_to_vendor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity(debug = true)
@SpringBootApplication
public class RecruiterToVendorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruiterToVendorApplication.class, args);
	}

}
