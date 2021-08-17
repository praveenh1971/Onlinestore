package com.onlinestore.products.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.onlinestore.products.datamodel.Product;

public class ProductRepository {
	private static long keyCounter = 1;
	private Map<Long, Product> items = new HashMap<Long, Product>();
	public ProductRepository(){
		items.put((long)1, new Product(1, "TV", "LG TV 54 inch", 1700));
		items.put((long)2, new Product(2, "Laptop", "Lenova", 1000));
		items.put((long)3, new Product(3, "Mouse", "Dell", 12));
		items.put((long)4, new Product(4, "Camera", "Sony 12mp", 200));
		keyCounter =4;
	}




	public List<Product> all() {
		return new ArrayList<Product>(items.values());
	}

	public void save(Product product) {
		 items.put(keyCounter++, product);
		
	}

	public boolean deleteProduct(long productid) {
		 return items.remove(productid) != null; 
	}
	public Product getProduct(long productid) {
		 return items.get(productid); 
	}
}
