// repositories --> É onde ficam armazenadas as operações de acesso a dados relacionadas a uma entidade. É o objeto que faz o acesso ao banco de dados
package com.lucasmonteiro.dsdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasmonteiro.dsdeliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}