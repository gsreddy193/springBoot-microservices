package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Payment;
import com.project.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository repo;
	
	public Payment addPayment(Payment payment) {
		return repo.save(payment);
	}
	
	public List<Payment> fetchPayments(){
		return repo.findAll();
	}
	
	public Payment fetchPaymentById(int bank_id) {
		return repo.findById(bank_id).orElse(null);
	}

}
