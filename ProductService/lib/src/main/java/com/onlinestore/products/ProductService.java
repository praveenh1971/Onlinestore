package com.onlinestore.products;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.products.datamodel.Product;
import com.onlinestore.products.repository.Item;
import com.onlinestore.products.repository.ProductRepository;

@Transactional
@Service
public class ProductService {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProductRepository productRepository;

	public List<Product> all() {
		return productRepository.findAll().stream().map(item -> modelMapper.map(item, Product.class))
				.collect(Collectors.toList());
	}

	public Product save(Product product) {
		Item customer = productRepository.save(modelMapper.map(product, Item.class));
		return modelMapper.map(customer, Product.class);
	}

	public Product get(String itemName) {
		return modelMapper.map(productRepository.findByName(itemName), Product.class);
	}

	public void delete(long itemId) {
		productRepository.deleteById(itemId);
	}
}
