package com.main;

public class Order {

	int oid;
	int pid;
	String userName;
	int quantity;
	int price;
	int totalPrice;
	String city;
	String phoneNo;
	
	public Order(int oid, int pid, String userName, int quantity, int price, int totalPrice, String city,
			String phoneNo) {
		super();
		this.oid = oid;
		this.pid = pid;
		this.userName = userName;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
		this.city = city;
		this.phoneNo = phoneNo;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "\n"+"Order [oid=" + oid + ", pid=" + pid + ", userName=" + userName + ", quantity=" + quantity + ", price="
				+ price + ", totalPrice=" + totalPrice + ", city=" + city + ", phoneNo=" + phoneNo + "]";
	}
	
	
	
	
}
