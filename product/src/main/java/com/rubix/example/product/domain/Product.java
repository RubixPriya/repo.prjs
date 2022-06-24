package com.rubix.example.product.domain;

import java.util.Objects;

public class Product {
	
	private long pid;
	
	private String productName;
	private double price;
	
	public Product(String pName, double price) {
		this.productName = pName;
		this.price = price;
	}
	
	Product(long pid) {
		this.pid = pid;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(pid, productName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return pid == other.pid && Objects.equals(productName, other.productName);
	}


}
