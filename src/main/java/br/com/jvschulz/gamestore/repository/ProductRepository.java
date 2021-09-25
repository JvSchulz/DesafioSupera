package br.com.jvschulz.gamestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jvschulz.gamestore.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
