package com.main;

public class Products {

	int pid;
	String description;
	int price;
	String categories;
	int quantity;
	
	public Products(int pid, String description, int price, String categories, int quantity) {
		super();
		this.pid = pid;
		this.description = description;
		this.price = price;
		this.categories = categories;
		this.quantity = quantity;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String name) {
		this.categories = categories;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		
		return "\n"+"\tpid=" + pid + ", \t description=" + description + ",\t\t price=" + price + ", \t categories=" + categories
				+ ", \tquantity=" + quantity ;
	}
	
	
	
	
}
