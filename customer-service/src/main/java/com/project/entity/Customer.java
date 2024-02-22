package com.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Customer {
	
	@Id
	private int customer_id;
	private String customer_name;
	private String email;
	private long mobile_number;
	private String address;
	public String getCompany_id;
	public String getBank_id() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
