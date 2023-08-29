package com.example.day8.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="studenttable")
public class studentModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rollno;
	private String studname;
	private int age;
	private String grade;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_rollno")
	private addModel address;
	public long getRollno() {
		return rollno;
	}
	public void setRollno(long rollno) {
		this.rollno = rollno;
	}
	public String getStudname() {
		return studname;
	}
	public void setStudname(String studname) {
		this.studname = studname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public addModel getAddress() {
		return address;
	}
	public void setAddress(addModel address) {
		this.address = address;
	}
	
}
