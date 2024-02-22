package com.project.service.dto;

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
public class CustomerResponse {
	
	
	private int customer_id;
	private String customer_name;
	private String email;
	private long mobile_number;
	private String address;

	public CustomerResponse(int customer_id2, String customer_name2, String email2, long mobile_number2,
			String address2, Payment payment, Product product) {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
