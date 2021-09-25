package br.com.jvschulz.gamestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jvschulz.gamestore.model.Product;
import br.com.jvschulz.gamestore.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	private List<Product> showProducts() {
		return productRepository.findAll();
	}

	@GetMapping(path = "/sortByName")
	private List<Product> sortProductByName() {
		return productRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}

	@GetMapping(path = "/sortByPrice")
	private List<Product> sortProductByPrice() {
		return productRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
	}

	@GetMapping(path = "/sortByScore")
	private List<Product> sortProductByScore() {
		return productRepository.findAll(Sort.by(Sort.Direction.ASC, "score"));
	}

	@PostMapping(path = "/add")
	public Product addProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
}
