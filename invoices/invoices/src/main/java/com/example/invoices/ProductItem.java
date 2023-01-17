package com.example.invoices;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class ProductItem {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Transient
	private Product product;
	private Long productID;
	private double price;
	private double quantity;
	
	@ManyToOne 
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	private Invoice invoice;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public ProductItem(Long id, Product product, Long productID, double price, double quantity, Invoice invoice) {
		super();
		Id = id;
		this.product = product;
		this.productID = productID;
		this.price = price;
		this.quantity = quantity;
		this.invoice = invoice;
	}
	

	public ProductItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
