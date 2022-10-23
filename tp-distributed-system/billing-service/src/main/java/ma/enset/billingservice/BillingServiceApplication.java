package ma.enset.billingservice;

import ma.enset.billingservice.dtos.InvoiceRequestDTO;
import ma.enset.billingservice.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	 @Bean
	 CommandLineRunner start(InvoiceService invoiceService){
	 	return args -> {
			 invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(10000),"b5b3226e-9bf3-4e6e-a662-053a4d6bf11c"));
			 invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(20000),"b5b3226e-9bf3-4e6e-a662-053a4d6bf11c"));
			 invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(30000),"b5b3226e-9bf3-4e6e-a662-053a4d6bf11c"));
	 		// invoiceService.getInvoices().forEach(System.out::println);
	 	};
	 }
}
