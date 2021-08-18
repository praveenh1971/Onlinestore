package com.onlinestore.products.datamodel;

import java.util.List;
import java.util.Map;

public abstract class DiscountStrategy {

	public abstract double applyDiscount(List<CartItem> item);
	public abstract void setParameters(Map<String, Object> params);

}
