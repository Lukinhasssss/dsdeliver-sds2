// repositories --> É onde ficam armazenadas as operações de acesso a dados relacionadas a uma entidade. É o objeto que faz o acesso ao banco de dados
package com.lucasmonteiro.dsdeliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasmonteiro.dsdeliver.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	// Ordenando os produtos por nome
	List<Product> findAllByOrderByNameAsc();

}