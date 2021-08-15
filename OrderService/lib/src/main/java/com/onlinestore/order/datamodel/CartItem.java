package com.onlinestore.order.datamodel;

public class CartItem {

	long productId;
	int price;
	int quantity;

	public double getPrice() {
		return product.getPrice() * quantity;
	}

}
