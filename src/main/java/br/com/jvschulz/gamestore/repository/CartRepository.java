package br.com.jvschulz.gamestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.jvschulz.gamestore.model.Cart;

public interface CartRepository extends JpaRepository<Cart, String> {

}
