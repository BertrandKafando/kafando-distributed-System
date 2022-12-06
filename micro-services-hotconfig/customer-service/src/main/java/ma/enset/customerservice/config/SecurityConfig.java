package ma.enset.customerservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {
    private final RSAKeyConfig rsaKeyConfig;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      return http
              .csrf().disable()
              .authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
              .oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer.jwt())
              .build();
    }
    @Bean
    JwtDecoder jwtDecoder(){
        return  NimbusJwtDecoder.withPublicKey( rsaKeyConfig.publicKey()).build();
    }
}
