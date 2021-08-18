package com.onlinestore.products.datamodel;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	List<CartItem> items = new ArrayList<CartItem>();
	DiscountStrategy offer;
	
	

	public void addItem(CartItem item){
		items.add(item);
	}



	/**
	 * @return the offer
	 */
	public DiscountStrategy getOffer() {
		return offer;
	}



	/**
	 * @param offer the offer to set
	 */
	public void setOffer(DiscountStrategy offer) {
		this.offer = offer;
	}



	public double getTotal() {
		double total = 0;
		for (CartItem purchase : items) {
			total += purchase.getPrice();
		}

		double discount = offer.applyDiscount(items);
		return total - discount;
	}

}
