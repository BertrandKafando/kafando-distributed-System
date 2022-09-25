package ma.enset.digitalbankapi;

import ma.enset.digitalbankapi.entities.BankAccount;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DigitalBankApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalBankApiApplication.class, args);
	}
  @Bean
	CommandLineRunner start(){
		return args -> {
			BankAccount bankAccount = new BankAccount();
			bankAccount.setId("1");
		};
	}
}
