// services --> É a camada que faz o meio de campo entre o controlador (que recebe a requisição) e a camada de acesso a dados que é o repository
package com.lucasmonteiro.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucasmonteiro.dsdeliver.dto.OrderDTO;
import com.lucasmonteiro.dsdeliver.entities.Order;
import com.lucasmonteiro.dsdeliver.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findOrderWithProducts();
		
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}

}