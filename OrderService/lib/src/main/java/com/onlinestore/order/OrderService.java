package com.onlinestore.order;

import com.onlinestore.products.repository.OrderRepository;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class OrderService extends AbstractVerticle {

	int port;
	private OrderRepository repo;

	public OrderService(int port) {
		this.port = port;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.vertx.core.AbstractVerticle#start(io.vertx.core.Promise)
	 */
	@Override
	public void start(Promise<Void> startPromise) throws Exception {
				
		repo = new OrderRepository();
		
		Router router = Router.router(vertx);
		
		router.route("/orders/all").handler( requestCtx -> {
			getAllOrders(requestCtx);
			
		});
		
		router.route("/orders/:id").handler( requestCtx -> {
			getAllOrders(requestCtx);
			
		});
		
		router.post("/orders/all").handler( requestCtx -> {
			getAllOrders(requestCtx);
			
		});
		
		router.delete("/orders/all").handler( requestCtx -> {
			getAllOrders(requestCtx);
			
		});
		
		vertx.createHttpServer().requestHandler(router).listen(port, handler ->{
			
			if(handler.succeeded()){
				startPromise.complete();
				System.out.println("HTTP Server Started");
			}else{
				startPromise.fail("Unable to create HTTP Server at port " + port);
			}
			
		});
	}

	private void getAllOrders(RoutingContext requestCtx) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.vertx.core.AbstractVerticle#stop(io.vertx.core.Promise)
	 */
	@Override
	public void stop(Promise<Void> stopPromise) throws Exception {
		// TODO Auto-generated method stub
		super.stop(stopPromise);
	}

}
