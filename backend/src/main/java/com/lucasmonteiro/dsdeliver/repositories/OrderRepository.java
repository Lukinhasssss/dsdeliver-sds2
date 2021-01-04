// repositories --> É onde ficam armazenadas as operações de acesso a dados relacionadas a uma entidade. É o objeto que faz o acesso ao banco de dados
package com.lucasmonteiro.dsdeliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lucasmonteiro.dsdeliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	// Retornando somente os pedidos pendentes e ordenando por instant (Do mais antido para o mais recente
	@Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products WHERE obj.status = 0 ORDER BY obj.moment ASC")
	List<Order> findOrderWithProducts();

}