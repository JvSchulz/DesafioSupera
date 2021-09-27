package br.com.jvschulz.gamestore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jvschulz.gamestore.model.ItemOrder;
import br.com.jvschulz.gamestore.model.Product;
import br.com.jvschulz.gamestore.repository.ItemOrderRepository;
import br.com.jvschulz.gamestore.repository.ProductRepository;

@RestController
@RequestMapping("/order")
public class ItemOrderController {

	@Autowired
	private ItemOrderRepository itemOrderRespository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	private List<ItemOrder>showOrders(){
		return itemOrderRespository.findAll();
	}
	
	@PostMapping(path = "/add/{id}")
	public ItemOrder addOrder(@PathVariable(name = "id",required = true )Long idProduct,@RequestBody ItemOrder order) {
		Optional<Product> prod = productRepository.findById(idProduct);
		order.setProduct(prod.get());
		order.unitPrice(prod.get());
		order.totalPrice();
		return itemOrderRespository.saveAndFlush(order);
	}
	
}
