package com.onlinestore.products.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.onlinestore.order.datamodel.Cart;

public class OrderRepository {
	private static long keyCounter = 1;
	private Map<Long, Cart> items = new HashMap<Long, Cart>();

	public OrderRepository() {
		// items.put((long) 1, new Product(1, "TV", "LG TV 54 inch", 1700));
		// items.put((long) 1, new Product(2, "Laptop", "Lenova", 1000));
		// items.put((long) 1, new Product(3, "Mouse", "Dell", 12));
		// items.put((long) 1, new Product(4, "Camera", "Sony 12mp", 200));
		// keyCounter = 4;
	}

	public Collection<Cart> all() {
		return items.values();
	}

	public void save(Cart product) {
		items.put(keyCounter++, product);

	}

	public boolean deleteProduct(long productid) {
		return items.remove(productid) != null;
	}

	public Cart getProduct(long productid) {
		return items.get(productid);
	}
}
