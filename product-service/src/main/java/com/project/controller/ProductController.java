package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Product;
import com.project.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping
    public Product addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }
	
    @GetMapping
    public List<Product> fetchProducts() {
        return service.fetchProducts();
    }
    
    @GetMapping("/{product_id}")
    public Product fetchProductById(@PathVariable int product_id){
        return service.fetchProductById(product_id);
    }

}
