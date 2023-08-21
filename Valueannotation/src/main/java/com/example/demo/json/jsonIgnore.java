package com.example.demo.json;

//import org.springframework.web.bind.annotation.RestController;;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@RestController

public class jsonIgnore {
	
	@JsonIgnoreProperties(value= {"age","empName"})
	public String empName;
	public int empId;
	public int age;
	
	public jsonIgnore() {
		super();
	}
	public jsonIgnore(String empName, int empId, int age) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.age = age;
	}
	
	

}
