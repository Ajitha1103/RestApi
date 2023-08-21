package com.example.day4.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="kitchenorg")
public class kitchenOrg {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="NoOfitems")
	private int noOfItems;
	@Column(name="itemsname")
	private String itemsName;
	private String foods;
	public int getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}
	public String getItemsName() {
		return itemsName;
	}
	public void setItemsName(String itemsName) {
		this.itemsName = itemsName;
	}
	public String getFoods() {
		return foods;
	}
	public void setFoods(String foods) {
		this.foods = foods;
	}

}
