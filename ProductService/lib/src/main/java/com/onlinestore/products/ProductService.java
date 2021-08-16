package com.onlinestore.products;

import com.onlinestore.products.datamodel.Product;
import com.onlinestore.products.repository.ProductRepository;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class ProductService extends AbstractVerticle {
	
	private int port;
	private ProductRepository repo;

	public ProductService(int port) {
		this.port = port;
	}

	@Override
	public void start(Promise<Void> startPromise) throws Exception {
		repo = new ProductRepository();
		Router router = Router.router(vertx);
		router.route("/api/products").handler((requestctx) -> {
			getAllProducts(requestctx);
		});
		router.post("/api/products").handler(requestctx -> {
			addProduct(requestctx);
		});
		router.delete("/api/products/:id").handler(requestctx -> {
			deleteProduct(requestctx);
		});
		router.route("/api/products/:id").handler(requestctx -> {
			getProduct(requestctx);
		});
		vertx.createHttpServer().requestHandler(router).listen(port, handler -> {
			if (handler.succeeded()) {
				startPromise.complete();
				System.out.println("HTTP Server Started");
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
						.end(Json.encodePrettily(product));
			} else {
				requestctx.response().setStatusCode(400).end();
			}

		} catch (NumberFormatException e) {
			requestctx.response().setStatusCode(400).end();
		}

	}

	private void deleteProduct(RoutingContext requestctx) {
		String id = requestctx.request().getParam("id");
		try {
			long productid = Integer.parseInt(id);
			repo.deleteProduct(productid);
		} catch (NumberFormatException e) {
			requestctx.response().setStatusCode(400).end();
		}

	}

	private void getAllProducts(RoutingContext rc) {
		rc.response().putHeader("content-type", "application/json; charset=utf-8").end(Json.encodePrettily(repo.all()));
	}

	private void addProduct(RoutingContext rc) {
		Product product = rc.getBodyAsJson().mapTo(Product.class);
		repo.save(product);
		rc.response().setStatusCode(201).putHeader("content-type", "application/json; charset=utf-8")
				.end(Json.encodePrettily(product));
	}

	@Override
	public void stop(Promise<Void> stopPromise) throws Exception {
		super.stop(stopPromise);
	}

}
