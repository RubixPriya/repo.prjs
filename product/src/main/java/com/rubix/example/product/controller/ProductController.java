package com.rubix.example.product.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubix.example.product.domain.Product;
import com.rubix.example.product.service.ProductService;


@RestController
@RequestMapping("/rubixProducts")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value="/products")
	public Collection<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@PostMapping(value="/products")
	public Product insertProduct(@RequestBody Product product) {
		 return productService.addProduct(product);
		
	}
	
	@PutMapping(value="products/{id}")
	public String updateproduct(@PathVariable long id, @RequestBody Product product) {
		System.out.println("This is going to update" + id);
		Product p = productService.getProductById(id);
		System.out.println(p.getPid());
		if (p != null) {
			 String msg = productService.updateProduct(product);
			 return msg;
		} else {
			return "cannot Update";
		}
	}
	
	@DeleteMapping(value="products/{pid}")
	public String deleteProduct(@PathVariable long pid) {

		Product p = productService.getProductById(pid);
		
		if (p != null) {
			String msg = productService.deleteProduct(pid);
			return msg;
		} else return "Cannot update non-existent product";
			}
}
