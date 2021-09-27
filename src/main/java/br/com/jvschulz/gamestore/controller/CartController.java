package br.com.jvschulz.gamestore.controller;


import java.util.Optional;

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

	@GetMapping(path = "/add")
	private void addCart() {
		Cart cart = new Cart();
		cartRepository.saveAndFlush(cart);
	}
	
	@GetMapping
	private Cart showCart() {
		Optional<Cart> cart = cartRepository.findById(1L);
		cart.get().setOrderList(itemOrderRespository.findAll());
		cart.get().shipping(cart.get().getOrderList());
		cart.get().subTotal(cart.get().getOrderList());
		cart.get().totalValue();
		return cartRepository.saveAndFlush(cart.get());
	}
}
