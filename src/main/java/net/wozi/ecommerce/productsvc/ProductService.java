package net.wozi.ecommerce.productsvc;

import net.wozi.ecommerce.productsvc.services.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductService {

	public static void main(String[] args) {
		SpringApplication.run(ProductService.class, args);
	}

	@Bean
	public MessageService messageService(){
		return new MessageService();
	}
}
