package com.xyz.Inventory_System.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


public class ItemDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = 0, message = "Quantity should not be negative")
    private int quantity;

    @Min(value = 0, message = "Price should not be negative")
    private int price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

    
}

