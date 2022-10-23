package ma.enset.bankAccountService;

import ma.enset.bankAccountService.entities.BankAccount;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class bankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(bankAccountServiceApplication.class, args);
	}
  @Bean
	CommandLineRunner start(){
		return args -> {
			BankAccount bankAccount = new BankAccount();
			bankAccount.setId("1");
		};
	}
}
