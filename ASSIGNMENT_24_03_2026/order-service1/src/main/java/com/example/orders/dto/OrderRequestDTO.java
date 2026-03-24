package com.example.orders.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {
	@Email
	private String email;
	@NotNull
	@NotBlank
	private String productName;
	@Min(1)
	private int quantity;
	@NotNull
	@Min(1)
	private Double pricePerUnit;
	@Size(min=3)
	private String customerName;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public OrderRequestDTO(String email, String productName, int quantity, Double pricePerUnit, String customerName) {
		super();
		this.email = email;
		this.productName = productName;
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
		this.customerName = customerName;
	}
	public OrderRequestDTO() {
		// TODO Auto-generated constructor stub
	}

}
