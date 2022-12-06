package ma.enset.securityservice.service;

import lombok.AllArgsConstructor;
import ma.enset.securityservice.exceptions.NoRefreshToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthService {
    private JwtEncoder jwtEncoder;
    private JwtDecoder jwtDecoder;
    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    public Map<String, String> jwtToken(String grantType, String username, String password, boolean withRefreshToken, String refreshToken) throws Exception {
        String subject=null;
        String scope=null;
        if(grantType.equals("password")){
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            System.out.println("authentication = " + authentication);
            subject=authentication.getName();
            scope=authentication.getAuthorities()
                    .stream().map(aut -> aut.getAuthority())
                    .collect(Collectors.joining(" "));

        } else if(grantType.equals("refreshToken")){
            if(refreshToken==null) {
                throw new NoRefreshToken("Refresh Token is required");
            }
            Jwt decodeJWT = null;
            try {
                decodeJWT = jwtDecoder.decode(refreshToken);
            } catch (JwtException e) {
                throw new NoRefreshToken(e.getMessage());
            }
            subject=decodeJWT.getSubject();
            UserDetails userDetails = userDetailsService.loadUserByUsername(subject);
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            scope=authorities.stream().map(auth->auth.getAuthority()).collect(Collectors.joining(" "));
        }
        Map<String, String> idToken=new HashMap<>();
        Instant instant=Instant.now();
        JwtClaimsSet jwtClaimsSet=JwtClaimsSet.builder()
                .subject(subject)
                .issuedAt(instant)
                .expiresAt(instant.plus(withRefreshToken?1:5, ChronoUnit.MINUTES))
                .issuer("security-service")
                .claim("scope",scope)
                .build();
        String jwtAccessToken=jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
        idToken.put("accessToken",jwtAccessToken);
        if(withRefreshToken){
            JwtClaimsSet jwtClaimsSetRefresh=JwtClaimsSet.builder()
                    .subject(subject)
                    .issuedAt(instant)
                    .expiresAt(instant.plus(5, ChronoUnit.MINUTES))
                    .issuer("security-service")
                    .build();
            String jwtRefreshToken=jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSetRefresh)).getTokenValue();
            idToken.put("refreshToken",jwtRefreshToken);
        }
        return idToken;
    }
}
