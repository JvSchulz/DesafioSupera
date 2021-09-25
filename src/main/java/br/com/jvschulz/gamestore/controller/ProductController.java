package br.com.jvschulz.gamestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	private List<Product> showProducts(){
		return productRepository.findAll();
	}
}
