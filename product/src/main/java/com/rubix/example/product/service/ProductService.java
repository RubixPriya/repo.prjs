package com.rubix.example.product.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubix.example.product.domain.Product;
import com.rubix.example.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public Product addProduct(String name, double price) {
		Product product = new Product(name, price);
		repository.insert(product);
		return product;
	}
	
	public Collection<Product> getAllProducts() {
		return repository.getAll();
	}
	
	public String updateProduct(Product product) {
		boolean updatedRecords = repository.update(product);
		if (updatedRecords) {
			return "Successfully Updated";
		}
		return "Cannot update";
	}
	
	public Product addProduct(Product product) {
		return repository.insert(product);
	}
	
	public Product getProductById(long id) {
		Product p =  repository.getProductInfo(id);
		return p;
	}
	
	public String deleteProduct(long id) {
		boolean success = repository.delete(id);
		if (success) {
			return "product deleted";
		} else {
			return " Sorry cannot delete";
		}
	}
	
}
