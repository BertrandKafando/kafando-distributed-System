package ma.enset.inventoryservice;

import ma.enset.inventoryservice.dtos.ProductDto;
import ma.enset.inventoryservice.services.InventoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(InventoryService inventoryService){
		return args -> {
			inventoryService.saveProduct(new ProductDto(1L,"Laptop",1000));
			inventoryService.saveProduct(new ProductDto(2L,"Smartphone",1000));
			inventoryService.saveProduct(new ProductDto(3L,"Tablet",1000));
			inventoryService.getAllProducts(1,10).forEach(System.out::println);
		};
	}

}
