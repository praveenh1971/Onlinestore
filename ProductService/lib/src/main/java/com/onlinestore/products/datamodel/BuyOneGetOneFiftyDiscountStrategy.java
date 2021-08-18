package com.onlinestore.products.datamodel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

//100,50, 20, 10
public class BuyOneGetOneFiftyDiscountStrategy extends DiscountStrategy {

	@Override
	//return discounted price
	public  double applyDiscount(List<CartItem> item) {
		
		if(item.size() < 2){
			return 0;
		}
		
		// sort by lowest price items
		Collections.sort(item,new Comparator<CartItem>() {
			@Override
			public int compare(CartItem o1, CartItem o2) {
				return (int) (o2.getPrice() - o1.getPrice()) ;
			}
		});
		
		
//		for(int i=0;i< int(item.size()/2); i++){
//			
//		}
//		
//		
//		
//		for (CartItem purchase : item) {
//			total += purchase.getPrice();
//		}
		
		return 0;
	}

	@Override
	public void setParameters(Map<String, Object> params) {
		// TODO Auto-generated method stub
		
	}

}
