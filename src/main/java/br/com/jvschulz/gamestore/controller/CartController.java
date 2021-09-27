package br.com.jvschulz.gamestore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jvschulz.gamestore.model.Cart;
import br.com.jvschulz.gamestore.repository.CartRepository;
import br.com.jvschulz.gamestore.repository.ItemOrderRepository;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ItemOrderRepository itemOrderRespository;

	@GetMapping
	private Cart showCart() {
		Cart cart = new Cart();
		cart.setOrderList(itemOrderRespository.findAll());
		cart.shipping(cart.getOrderList());
		cart.subTotal(cart.getOrderList());
		cart.totalValue();
		return cartRepository.saveAndFlush(cart);
	}
}
