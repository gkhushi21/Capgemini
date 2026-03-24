package com.example.orders.dto;


public class OrderResponseDTO {
private Long orderId;
private String customerName;
private String email;
private String productName;
private int quantity;
private Double pricePerUnit;
private Double totalAmount;
public Long getOrderId() {
	return orderId;
}
public void setOrderId(Long orderId) {
	this.orderId = orderId;
}
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
public Double getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(Double totalAmount) {
	this.totalAmount = totalAmount;
}
public OrderResponseDTO(Long orderId, String customerName, String email, String productName, int quantity,
		Double pricePerUnit, Double totalAmount) {
	super();
	this.orderId = orderId;
	this.customerName = customerName;
	this.email = email;
	this.productName = productName;
	this.quantity = quantity;
	this.pricePerUnit = pricePerUnit;
	this.totalAmount = totalAmount;
}
   


}
