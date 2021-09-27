package br.com.jvschulz.gamestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.jvschulz.gamestore.model.ItemOrder;


public interface ItemOrderRepository extends JpaRepository<ItemOrder, Long> {

}
