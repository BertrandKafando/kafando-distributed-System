package ma.enset.billingservice.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class ConsulConfig {
    @Value("${config.params}")
    private long params;
    @Value("${spring.h2.console.enabled}")
    private boolean enabled;
    @Value("${config.test}")
    private long test;
}
