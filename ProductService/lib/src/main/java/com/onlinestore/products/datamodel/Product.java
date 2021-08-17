package com.onlinestore.products.datamodel;

import io.vertx.core.json.JsonObject;

/**
 * 
 * @author sanjiv
 *
 */
public class Product {
	public Product(long id, String name, String description, double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	/*
	 * auto-generated id.
	 */
	private long id;
	
	private String name;
	private String description;
	private double price;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	public JsonObject toJSon() {
		JsonObject ob =  new JsonObject();
		ob.put("id", getId());
		ob.put("name", getName());
		ob.put("price", getPrice());
		ob.put("description", getDescription());
		return ob;
	}
}
