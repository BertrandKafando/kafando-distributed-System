package ma.enset.customerservice;

import ma.enset.customerservice.dtos.CustomerDto;
import ma.enset.customerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerService customerService){
		return args -> {
			customerService.save(new CustomerDto("1","Mohamed","moh@gmail","123456"));
			customerService.save(new CustomerDto("2","Ahmed","ahmed@gmail","123456"));
			customerService.save(new CustomerDto("3","Ali","ali@gmail","123456"));
			customerService.getCustomers().forEach(System.out::println);
		};
	}
}
