/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.onlinestore.order;

import io.vertx.core.Vertx;

public class OrderServiceApplication {
	
	public static void main(String[] args) {
			
		Vertx vrts = Vertx.vertx();
		vrts.deployVerticle(new OrderService(3000));
		while(true);
	}
	
}
