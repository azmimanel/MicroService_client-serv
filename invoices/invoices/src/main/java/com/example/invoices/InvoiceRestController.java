package com.example.invoices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceRestController {
	@Autowired private InvoiceRepository invoiceRepository;
	@Autowired private ProductItemRepository productItemRepository;
	@Autowired private CustomerServiceClient customerServiceClient;
	@Autowired private InventoryServiceClient inventoryServiceClient;
	@GetMapping("/invoices/full/{id}")
	Invoice getInvoice(@PathVariable(name="id") Long id) {
		Invoice invoice=invoiceRepository.findById(id).get();
		invoice.setCustomer(customerServiceClient.findCustomerById(invoice.getCustomerID()));
		invoice.setProductItems(productItemRepository.findByInvoiceId(id));
		invoice.getProductItems().forEach(pi ->{
			pi.setProduct(inventoryServiceClient.findProductById(pi.getProductID()));
		});
		return invoice;
	}

}
