package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.entity.Customer;
import com.project.repository.CustomerRepository;
import com.project.service.dto.CustomerResponse;
import com.project.service.dto.Payment;
import com.project.service.dto.Product;

@Service
public class CustomerService {
	

	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ResponseEntity<Customer> createCustomer(Customer customer) {
		try {
			return new ResponseEntity<Customer>(repo.save(customer), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	public ResponseEntity<?> fetchCustomerById(int customer_id){
		Optional<Customer> customer = repo.findById(customer_id);
		if (customer.isPresent()) {
			Payment payment = restTemplate.getForObject("http://localhost:8000/payment/" + customer.get().getBank_id(), Payment.class);
			Product product = restTemplate.getForObject("http://localhost:8001/product/" + customer.get().getCompany_id, Product.class);
			CustomerResponse customerResponse = new CustomerResponse(
													customer.get().getCustomer_id(),
													customer.get().getCustomer_name(),
													customer.get().getEmail(),
													customer.get().getMobile_number(),
													customer.get().getAddress(),
													payment, product);
			return new ResponseEntity<>(customerResponse, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("No Customer Found",HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<?> fetchCustomers(){
		List<Customer> customers = repo.findAll();
		if (customers.size() > 0) {
			return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("No Customers",HttpStatus.NOT_FOUND);
		}
	}

}
