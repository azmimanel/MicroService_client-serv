package com.example.invoices;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class InvoicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoicesApplication.class, args);
		
	}
	@Bean
	CommandLineRunner start(InvoiceRepository invoiceRepository, ProductItemRepository productItemRepository, InventoryServiceClient inventoryServiceClient, 
			CustomerServiceClient customerServiceClient) {
		return args ->{
			Invoice invoice= new Invoice();
			invoice.setInvoiceDate(new Date());
			Customer customer=customerServiceClient.findCustomerById(1L);
			invoice.setCustomerID(customer.getId());
			invoiceRepository.save(invoice);
			inventoryServiceClient.findAll().getContent().forEach(p -> {
				productItemRepository.save(new ProductItem(null, p, p.getId(), p.getPrice(), (int)(1+Math.random()*1000), invoice));
			});
		};
	}
	
}
