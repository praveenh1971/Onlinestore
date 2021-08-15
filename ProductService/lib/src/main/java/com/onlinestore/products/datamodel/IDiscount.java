package com.onlinestore.products.datamodel;

import java.util.List;


//Discounts are based on current shopping cart and/or purchase history.
//Zero or more discounts may apply. There are no mutually exclusive discounts.
//Proper calculation is not dependent on the order in which discounts are applied.
//Discounts are very different. Different number and kind of parameters to make up each rule.
//Arguments for qualifying discounts change as the shopping cart changes.
//The number of discounts available changes
//The discounts this customer qualifies for changes as his shopping cart changes.
//Shopping history does not change in the context of this purchase
//Total cost changes dynamically as a function of purchase lines and discounts applied.
//After initial application a discount's output may change, as purchase quantity changes for example.

public interface IDiscount {
	
	public void apply(List<Product> products);

}
