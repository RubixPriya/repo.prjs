package com.rubix.example.product.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rubix.example.product.domain.Product;

@Repository
public class ProductRepository {
	
	private long pid = 1;
	
	private Map<Long, Product> productsMap = new HashMap<Long, Product>();
	
	ProductRepository() {
		insert(new Product("Medimix", 60));
		insert(new Product("Lux", 120));
		insert(new Product("Pears", 100));
	}
	public Product insert(Product product) {
		
		product.setPid(pid ++);
		productsMap.put(product.getPid(), product);
		return product;
		
	}
	
	public boolean update(Product product) {
		
		if(productsMap.containsKey(product.getPid())) {
			productsMap.put(product.getPid(), product);
			return true;
		}
		 return false;
	}
	
	public boolean delete(long pid) {

		if (productsMap.containsKey(pid)) {
			productsMap.remove(pid);
			return true;
		}
		return false;
	}
	
	public Collection<Product> getAll() {
		return productsMap.values();
	}
	
	public Product getProductInfo(long id) {
		return productsMap.get(id);
	}

}
