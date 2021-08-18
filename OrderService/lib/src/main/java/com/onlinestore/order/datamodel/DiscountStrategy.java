package com.onlinestore.order.datamodel;

import java.util.List;

public abstract class DiscountStrategy {
	
	public double getDiscount(List<CartItem> item){
		
		List<CartItem> flattenedItems
		for (CartItem purchase : item) {
			total += purchase.getPrice();
		}
	}

	public abstract double applyDiscount(List<CartItem> item);

}
