package com.example.orders.entity;

import com.example.orders.dto.OrderRequestDTO;
import com.example.orders.dto.OrderResponseDTO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String email;
    private String productName;
    private Integer quantity;
    private Double pricePerUnit;
    private Double totalAmount;
//    private OrderRequestDTO orderRequestDTO;
//    private OrderResponseDTO orderResponseDTO;
//    
//    public OrderRequestDTO getOrderRequestDTO() {
//		return orderRequestDTO;
//	}
//	public void setOrderRequestDTO(OrderRequestDTO orderRequestDTO) {
//		this.orderRequestDTO = orderRequestDTO;
//	}
//	public OrderResponseDTO getOrderResponseDTO() {
//		return orderResponseDTO;
//	}
//	public void setOrderResponseDTO(OrderResponseDTO orderResponseDTO) {
//		this.orderResponseDTO = orderResponseDTO;
//	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
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
	public OrderEntity(String customerName, String email, String productName, Integer quantity, Double pricePerUnit,
			Double totalAmount) {
		super();
		this.customerName = customerName;
		this.email = email;
		this.productName = productName;
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
		this.totalAmount = totalAmount;		
	}
	
	
	
	public OrderEntity(String customerName, Double totalAmount) {
		
		
		this.customerName = customerName;
		this.totalAmount = totalAmount;
	}
	public OrderEntity() {
	}
    
    
}

