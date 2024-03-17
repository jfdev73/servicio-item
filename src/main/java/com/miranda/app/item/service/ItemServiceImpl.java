package com.miranda.app.item.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.miranda.app.item.models.Item;
import com.miranda.app.item.models.Producto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{
	
	
	private final RestTemplate restTemplate;

	@Override
	public List<Item> findAll() {
		List<Producto> productos = Arrays.asList(restTemplate.getForObject("http://localhost:8001/listar", Producto[].class ));
		return productos.stream().map(p->new Item(p,1)).toList();
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		Producto producto = restTemplate.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariables);
		return new Item(producto, cantidad);
	}

}
