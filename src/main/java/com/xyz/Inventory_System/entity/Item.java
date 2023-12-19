package com.xyz.Inventory_System.entity;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int quantity;
    private int  price;
    
    public Item(Long id, String name, int quantity, int price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public static Item build(String name, int price, int quantity) {
		
		 Item item = new Item();
		    item.setName(name);
		    item.setPrice(price);
		    item.setQuantity(quantity);
		    return item;
	}

	
}

