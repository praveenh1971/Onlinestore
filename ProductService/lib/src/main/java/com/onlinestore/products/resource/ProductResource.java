package com.onlinestore.products.resource;

import java.util.List;

import com.onlinestore.products.ProductService;
import com.onlinestore.products.datamodel.Product;

public class ProductResource {

	private ProductService productService;

	/*
	 * @ResponseStatus(HttpStatus.OK)
	 * 
	 * @GetMapping("/")
	 */
	public List<Product> all() {
		return productService.all();
	}

	/*
	 * @ResponseStatus(HttpStatus.OK)
	 * 
	 * @GetMapping("/{itemName}")
	 */
	public Product get(String itemName) {
		return productService.get(itemName);
	}

	/*
	 * @ResponseStatus(HttpStatus.OK)
	 * 
	 * @PutMapping("/{itemName}")
	 */
	public Product put(String itemName, Product product) {
		product.setName(itemName);
		return productService.save(product);
	}

	/*
	 * @ResponseStatus(HttpStatus.NO_CONTENT)
	 * 
	 * @DeleteMapping("/{id}")
	 */
	public void delete(long id) {
		productService.delete(id);
	}

	/*
	 * @PostMapping("/")
	 * 
	 * @ResponseStatus(HttpStatus.CREATED)
	 */
	public Product add(Product product) {
		return productService.save(product);
	}

	/*
	 * @ExceptionHandler(Exception.class) public ResponseEntity<?>
	 * handleException(Throwable ex) { // Add conditional logic to show differnt
	 * status on different exceptions return new
	 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); }
	 */

}
