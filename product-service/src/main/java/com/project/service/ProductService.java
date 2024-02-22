package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.entity.Product;
import com.project.repository.productRepository;

@Service
public class ProductService {
	
	@Autowired
	private productRepository repo;
	
	public Product addProduct(Product product) {
		return repo.save(product);
	}
	
	public List<Product> fetchProducts(){
		return repo.findAll();
	}
	
	public Product fetchProductById(int product_id) {
		return repo.findById(product_id).orElse(null);
	}

}
