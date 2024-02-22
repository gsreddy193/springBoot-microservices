package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Payment;
import com.project.service.PaymentService;

@CrossOrigin("*")
@RequestMapping(value = "/payment")
@RestController
public class PaymentController {
	
	@Autowired
	public PaymentService service;
	
	@PostMapping("/save")
	public Payment addPayment(@RequestBody Payment payment) {
		return service.addPayment(payment);
	}
	
	@GetMapping("/fetch")
	public List<Payment> fetchPayments(){
		return service.fetchPayments();
	}
	
	@GetMapping("/{bank_id}")
	public Payment fetchPaymentById(@PathVariable int bank_id) {
		return service.fetchPaymentById(bank_id);
	}

}
