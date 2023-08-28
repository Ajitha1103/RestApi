package com.example.day9.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="addressmodel")
public class addressModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addid;
	private String street;
	private String city;
	private String state;
	private String country;
	private int pincode;
	public long getAddid() {
		return addid;
	}
	public void setAddid(long addid) {
		this.addid = addid;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	

}
