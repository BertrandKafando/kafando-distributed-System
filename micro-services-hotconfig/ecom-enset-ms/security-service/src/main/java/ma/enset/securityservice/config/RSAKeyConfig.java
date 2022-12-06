package ma.enset.securityservice.config;

import java.security.interfaces.RSAPrivateKey;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPublicKey;

@ConfigurationProperties(prefix="rsa")
public record RSAKeyConfig(RSAPublicKey publicKey, RSAPrivateKey privateKey) {

}
