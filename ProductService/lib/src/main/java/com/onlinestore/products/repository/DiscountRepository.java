package com.onlinestore.products.repository;

import java.util.HashMap;
import java.util.Map;

import com.onlinestore.products.datamodel.Discount;
import com.onlinestore.products.datamodel.DiscountRequest;
import com.onlinestore.products.datamodel.DiscountStrategy;

public class DiscountRepository {

	private Map<Long, DiscountStrategy> items = new HashMap<Long, DiscountStrategy>();

	public void save(DiscountRequest request) {

		if (request != null) {

			long productId = request.getProductId();

			try {

				Class cls = Class.forName(request.getStrategyName());
				try {
						if (cls.isAssignableFrom(DiscountStrategy.class)){
						    DiscountStrategy stragedy =(DiscountStrategy)	cls.newInstance();
							stragedy.setParameters(request.getStrategyParams());
						
							items.put(productId, stragedy);
						}
						
					
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {

			}

		}

	}
	public DiscountStrategy getStrategy(long product){
		return items.get(product);
	}

}
