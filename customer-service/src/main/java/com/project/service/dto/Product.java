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
public class Product {
	
	private int company_id;
	private int product_id;
	private String product_name;
	private double price;
	private int quantity;
	private double discount_amount;
	private double total;

}
