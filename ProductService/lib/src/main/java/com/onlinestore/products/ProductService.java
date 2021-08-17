package com.onlinestore.products;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.onlinestore.products.datamodel.Product;
import com.onlinestore.products.repository.ProductRepository;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class ProductService extends AbstractVerticle{
	private int port;
	private ProductRepository repo;
	public ProductService(int port){
		this.port = port;
	}
	@Override
	public void start(Promise<Void> startPromise) throws Exception {
		   repo = new ProductRepository();
			Router router = Router.router(vertx);
			router.route(HttpMethod.GET ,"/productservice/products").handler((requestctx)->{
				getAllProducts(requestctx);
			});
			router.route(HttpMethod.POST ,"/productservice/products").handler(requestctx->{
					addProduct(requestctx);
			});
			router.delete("/productservice/products/:id").handler(requestctx->{
				deleteProduct(requestctx);
			});
			router.route("/productservice/products/:id").handler(requestctx->{
						getProduct(requestctx);
				});
			
			 vertx.createHttpServer().requestHandler(router).listen(port, handler->{
				 if (handler.succeeded()){
					 startPromise.complete();
					 System.out.println("HTTP Server Started");
				 }else{
					 startPromise.fail("Unable to create HTTP Server at port " + port);
				 }
				 
			 });
	}
	private void getProduct(RoutingContext requestctx) {
	
		 String id = requestctx.request().getParam("id");
		 try {
			 long productid = Integer.parseInt(id);
			 Product product = repo.getProduct(productid);
			 if (product != null){
				 requestctx.response()
			      .putHeader("content-type", 
			         "application/json; charset=utf-8")
			      .end(Json.encodePrettily(product.toJSon()));
			 }else{
				 requestctx.response()
			      .putHeader("content-type", 
			         "application/json; charset=utf-8")
			      .end("Product with id  " + id + " is not available");
			 }

		 }catch (NumberFormatException e){
			 requestctx.response().setStatusCode(400).end();
		 }

	}
	private void deleteProduct(RoutingContext requestctx) {
		 String id = requestctx.request().getParam("id");
		 try {
			 long productid = Integer.parseInt(id);
			 repo.deleteProduct(productid);
		 }catch (NumberFormatException e){
			 requestctx.response().setStatusCode(400).end();
		 }
		
		
		 
	}
	private void getAllProducts(RoutingContext rc) {
		  List<JsonObject> produces = repo.all().stream().map(pro->pro.toJSon()).collect(Collectors.toList());
		  rc.response()
		      .putHeader("content-type", 
		         "application/json; charset=utf-8")
		      .end(Json.encodePrettily(produces));
	}
	
	

	private void addProduct(RoutingContext rc) {
	    Product product = rc.getBodyAsJson().mapTo(Product.class);
	    repo.save(product);
	    rc.response()
	        .setStatusCode(201)
	        .putHeader("content-type", 
	          "application/json; charset=utf-8")
	        .end(Json.encodePrettily(product));
	}
	
	
	@Override
	public void stop(Promise<Void> stopPromise) throws Exception {
			super.stop(stopPromise);
	}

	
}
