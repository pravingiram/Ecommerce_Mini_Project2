package com.adminOperations;

public class Products {
	
	private int Id;
	
	
	private String name;
	
	private String description;
	
	private double price;
	
	private int quantity;

	public Products(int id, String name, String description, double price, int quantity) {
		
		Id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
   public Products(String name, String description, double price, int quantity) {
		
	
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}


	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
		
	
}
