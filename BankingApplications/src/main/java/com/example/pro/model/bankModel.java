package com.example.pro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bankmodel")
public class bankModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bankid")
	private int bankId;
	@Column(name="bankname")
	private String bankName;
	@Column(name="accholdername")
	private String accHolderName;
	@Column(name="accnum")
	private String accNumber;
	@Column(name="ifscnum")
	private String ifscNum;
	@Column(name="mobnum")
	private String mobNum;
	private String address;
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	public String getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	public String getIfscNum() {
		return ifscNum;
	}
	public void setIfscNum(String ifscNum) {
		this.ifscNum = ifscNum;
	}
	public String getMobNum() {
		return mobNum;
	}
	public void setMobNum(String mobNum) {
		this.mobNum = mobNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
