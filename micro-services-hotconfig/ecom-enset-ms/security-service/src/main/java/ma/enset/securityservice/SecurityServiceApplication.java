package ma.enset.securityservice;

import ma.enset.securityservice.config.RSAKeyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.management.MXBean;

@SpringBootApplication
//add this annotation to enable the configuration properties
@EnableConfigurationProperties(RSAKeyConfig.class)
public class SecurityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityServiceApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
