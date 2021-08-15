package com.onlinestore.products.repository;

import java.util.HashMap;
import java.util.Map;

import com.onlinestore.products.datamodel.Product;

public class ProductRepository {

	private Map<String, Product> items = new HashMap<String, Product>();

	public Product findByName(String name){
		
		return items.get(name);
		
	}

	public void deleteById(long itemId) {
		// TODO Auto-generated method stub
		
	}
}
