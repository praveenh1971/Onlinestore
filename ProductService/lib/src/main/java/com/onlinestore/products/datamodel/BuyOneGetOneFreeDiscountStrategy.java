package com.onlinestore.products.datamodel;

import java.util.List;

public class BuyOneGetOneFreeDiscountStrategy extends DiscountStrategy {

	long productId;

	long freeProductId;

	public BuyOneGetOneFreeDiscountStrategy(long productId, long freeProductId) {
		super();
		this.productId = productId;
		this.freeProductId = freeProductId;
	}

	@Override
	public double applyDiscount(List<CartItem> items) {

		if (items.size() < 2) {
			return 0;
		}

		CartItem productItem = null;
		CartItem freeProductItem = null;

		for (CartItem item : items) {
			if (item.getProductId() == productId) {
				productItem = item;
			} else if (item.getProductId() == freeProductId) {
				freeProductItem = item;
			}
		}

		if (productItem != null && freeProductItem != null) {

			int productQuantity = productItem.getQuantity();
			int freeProductQuantity = freeProductItem.getQuantity();

			return Math.min(productQuantity, freeProductQuantity) * freeProductItem.getPrice();

		}

		return 0;
	}

}
