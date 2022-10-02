package com.main;

public class Users {

	String userName;
	String password;
	String firstName;
	String lastName;
	String city;
	String phoneNo;
	public Users(String userName, String password, String firstName, String lastName, String city, String phoneNo) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.phoneNo = phoneNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		return "\n"+"Users [userName=" + userName + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", city=" + city + ", phoneNo=" + phoneNo + "]";
	}
	
	
	
}
