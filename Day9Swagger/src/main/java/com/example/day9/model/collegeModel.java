package com.example.day9.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="collegemodel")
public class collegeModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="collegeid")
	private int collegeId;
	private String collegename;
	private String noofdepts;
	private int collegerating;
	private String address;
	private long contactnum;
	
	//getter and setters
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegename() {
		return collegename;
	}
	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}
	public String getNoofdepts() {
		return noofdepts;
	}
	public void setNoofdepts(String noofdepts) {
		this.noofdepts = noofdepts;
	}
	public int getCollegerating() {
		return collegerating;
	}
	public void setCollegerating(int collegerating) {
		this.collegerating = collegerating;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getContactnum() {
		return contactnum;
	}
	public void setContactnum(long contactnum) {
		this.contactnum = contactnum;
	}
	
	
}
