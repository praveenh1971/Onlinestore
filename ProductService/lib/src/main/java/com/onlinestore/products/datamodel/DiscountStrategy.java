package com.onlinestore.products.datamodel;

import java.util.List;

public abstract class DiscountStrategy {

	public abstract double applyDiscount(List<CartItem> item);

}
