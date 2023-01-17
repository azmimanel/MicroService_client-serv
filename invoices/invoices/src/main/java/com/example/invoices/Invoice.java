package com.example.invoices;

import java.util.Collection;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Invoice {
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id; private Date InvoiceDate;
	
	@Transient @OneToMany(mappedBy = "invoice")
	private Collection<ProductItem> productItems;
	
	@Transient 
	private Customer customer;
	private Long customerID;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getInvoiceDate() {
		return InvoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		InvoiceDate = invoiceDate;
	}
	public Collection<ProductItem> getProductItems() {
		return productItems;
	}
	public void setProductItems(Collection<ProductItem> productItems) {
		this.productItems = productItems;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}
	public Invoice(Long id, Date invoiceDate, Collection<ProductItem> productItems, Customer customer,
			Long customerID) {
		super();
		this.id = id;
		InvoiceDate = invoiceDate;
		this.productItems = productItems;
		this.customer = customer;
		this.customerID = customerID;
	}
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
