package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Customer;
import com.project.service.CustomerService;

@CrossOrigin("*")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping
	public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
		return service.createCustomer(customer);
	}
	
	@GetMapping
	public ResponseEntity<?> fetchCustomers(){
		return service.fetchCustomers();
	}
	
	@GetMapping("/{customer_id}")
	public ResponseEntity<?> fetchCustomerById(@PathVariable int customer_id){
		return service.fetchCustomerById(customer_id);
	}

}
