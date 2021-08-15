package com.onlinestore.order.datamodel;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	List<CartItem> item = new ArrayList<CartItem>();
	Discount offer;

	public double getTotal() {
		double total = 0;
		for (CartItem purchase : item) {
			total += purchase.getPrice();
		}

		double finalPrice = 0;// offer.getPrice(total,....;
		return finalPrice;
	}

}
