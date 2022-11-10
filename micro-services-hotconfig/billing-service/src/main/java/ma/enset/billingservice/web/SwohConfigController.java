package ma.enset.billingservice.web;

import lombok.RequiredArgsConstructor;
import ma.enset.billingservice.config.ConsulConfig;
import ma.enset.billingservice.config.MyVaultConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class SwohConfigController {

    private final ConsulConfig consulConfig;
    private final MyVaultConfig myVaultConfig;

    @GetMapping("/myConfig")
    public Map<String,Object> myConfig(){
        return Map.of("consulConfig",consulConfig, "vaultConfig",myVaultConfig);
    }

}
