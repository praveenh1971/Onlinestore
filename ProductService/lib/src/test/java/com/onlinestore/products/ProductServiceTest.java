package com.onlinestore.products;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import com.onlinestore.products.datamodel.Product;

import io.vertx.ext.web.RoutingContext;

@Testable
public class ProductServiceTest{
	
	public ProductServiceTest() {
		
	}
	
	@Test
	public void getProduct(RoutingContext requestctx) {
		
		
	}
	
	@Testable
	public void deleteProduct(RoutingContext requestctx) {
		Assertions.assertEquals(expected, actual, message);
	}
	
	@Test
	public void getAllProducts(RoutingContext rc) {

	}
	
	@Test
	public void addProduct(RoutingContext rc) {
		
		new Product(1, "TV", "LG TV 54 inch", 1700);

	}

}
