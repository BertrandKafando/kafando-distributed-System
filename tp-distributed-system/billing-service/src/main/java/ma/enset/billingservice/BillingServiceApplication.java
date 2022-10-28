package ma.enset.billingservice;

import ma.enset.billingservice.dtos.InvoiceRequestDTO;
import ma.enset.billingservice.entities.Customer;
import ma.enset.billingservice.openFeign.CustomerRestClient;
import ma.enset.billingservice.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	 @Bean
	 CommandLineRunner start(InvoiceService invoiceService, CustomerRestClient customerRestClient){
	 	return args -> {
			List<Customer> customers = customerRestClient.allCustomers();
			 invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(10000),customers.get(0).getId()));
			 invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(20000),customers.get(0).getId()));
			 invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(30000),customers.get(0).getId()));
	 		 invoiceService.getInvoices().forEach(System.out::println);
	 	};
	 }
}
