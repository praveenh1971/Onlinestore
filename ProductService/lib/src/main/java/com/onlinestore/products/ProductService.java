package com.onlinestore.products;

import java.util.List;
import java.util.stream.Collectors;

import com.onlinestore.products.datamodel.DiscountRequest;
import com.onlinestore.products.datamodel.Product;
import com.onlinestore.products.repository.DiscountRepository;
import com.onlinestore.products.repository.ProductRepository;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class ProductService extends AbstractVerticle {
	private int port;
	private ProductRepository repo;
	private DiscountRepository discountRepo;

	public ProductService(int port) {
		this.port = port;
	}

	@Override
	public void start(Promise<Void> startPromise) throws Exception {
		repo = new ProductRepository();
		discountRepo = new DiscountRepository();
		Router router = Router.router(vertx);
		router.get( "/productservice/products").handler((requestctx) -> {
			getAllProducts(requestctx);
		});
		router.put("/productservice/products/add").handler(requestctx -> {
			requestctx.request().bodyHandler(h->{
			   JsonObject jsonObject = 	h.toJsonObject();
			   if (jsonObject != null){
				   if (addProduct(jsonObject)){
					   requestctx.response().setStatusCode(200).end();
				   }else{
					   requestctx.response().setStatusCode(400).end();
				   }
			   }else{
				   requestctx.response().setStatusCode(400).end();
			   }
			});
	
		});
		router.delete("/productservice/products/:id").handler(requestctx -> {
			if (deleteProduct(requestctx))
				requestctx.response().setStatusCode(200).end();
			else
				requestctx.response().setStatusMessage("Could not delete the product").setStatusCode(400).end();
		});
		router.route("/productservice/products/:id").handler(requestctx -> {
			getProduct(requestctx);
		});

		vertx.createHttpServer().requestHandler(router).listen(port, handler -> {
			if (handler.succeeded()) {
				startPromise.complete();
			
			} else {
				startPromise.fail("Unable to create HTTP Server at port " + port);
			}

		});
	}

	private void getProduct(RoutingContext requestctx) {

		String id = requestctx.request().getParam("id");
		try {
			long productid = Integer.parseInt(id);
			Product product = repo.getProduct(productid);
			if (product != null) {
				requestctx.response().putHeader("content-type", "application/json; charset=utf-8")
						.end(Json.encodePrettily(product.toJSon()));
			} else {
				requestctx.response().putHeader("content-type", "application/json; charset=utf-8")
						.end("Product with id  " + id + " is not available");
			}

		} catch (NumberFormatException e) {
			requestctx.response().setStatusCode(400).end();
		}

	}

	private boolean deleteProduct(RoutingContext requestctx) {
		String id = requestctx.request().getParam("id");
		try {
			long productid = Integer.parseInt(id);
			return repo.deleteProduct(productid);
		} catch (NumberFormatException e) {
			requestctx.response().setStatusCode(400).end();
		}
		return false;

	}

	private void getAllProducts(RoutingContext rc) {
		List<JsonObject> produces = repo.all().stream().map(pro -> pro.toJSon()).collect(Collectors.toList());
		rc.response().putHeader("content-type", "application/json; charset=utf-8").end(Json.encodePrettily(produces));
	}

	private boolean addProduct(JsonObject ob) {

		if (ob != null) {
			Product product = Product.fromJson(ob);
			if (product != null) {
				repo.save(product);
				return true;
			}
			
		}
		return false;

	}

	private void addDiscount(RoutingContext rc) {

		DiscountRequest product = rc.getBodyAsJson().mapTo(DiscountRequest.class);
		discountRepo.save(product);
		rc.response().setStatusCode(201).putHeader("content-type", "application/json; charset=utf-8")
				.end(Json.encodePrettily(product));
	}

	@Override
	public void stop(Promise<Void> stopPromise) throws Exception {
		super.stop(stopPromise);
	}

}
