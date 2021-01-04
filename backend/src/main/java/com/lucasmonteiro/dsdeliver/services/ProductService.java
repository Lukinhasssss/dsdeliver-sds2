// services --> É a camada que faz o meio de campo entre o controlador (que recebe a requisição) e a camada de acesso a dados que é o repository
package com.lucasmonteiro.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucasmonteiro.dsdeliver.dto.ProductDTO;
import com.lucasmonteiro.dsdeliver.entities.Product;
import com.lucasmonteiro.dsdeliver.repositories.ProductRepository;

@Service // Esse Product service será um componente que será possível injetar lá no controlador então teremos que registrar ele no sistema de dependências do Spring Boot. O @Service registra o componente
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	// Criando método que retorna uma lista de produtos
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {
		List<Product> list = repository.findAllByOrderByNameAsc();
		
		// Transformando a lista de Product para uma lista de ProductDTO
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}

}

/*
 * 	Obs: O Service não vai retornar um Product, ele vai retornar um DTO (Data Transfer Objects)
 * 
 * 		map
 * 		  - Aplica uma função a todos os elementos da lista transformando assim em uma nova lista
 */