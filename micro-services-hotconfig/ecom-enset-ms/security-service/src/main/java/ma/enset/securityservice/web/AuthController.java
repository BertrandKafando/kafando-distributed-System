package ma.enset.securityservice.web;

import lombok.AllArgsConstructor;
import ma.enset.securityservice.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@AllArgsConstructor
public class AuthController {
    private AuthService authService;

    @PostMapping("/token")
    public ResponseEntity<Map<String, String>> jwtToken(String grantType, String username, String password, boolean withRefreshToken, String refreshToken) throws Exception {
        Map<String, String> idToken =  authService.jwtToken(grantType, username, password, withRefreshToken, refreshToken);
        return new ResponseEntity<>(idToken, HttpStatus.OK);
    }

}
