package com.miranda.app.item.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.miranda.app.item.clients.IProductoClienteRest;
import com.miranda.app.item.models.Item;

import lombok.RequiredArgsConstructor;

@Primary
@Service
@RequiredArgsConstructor
public class ItemServiceFeign implements ItemService {
	
	private final IProductoClienteRest clientFeign;
	
	@Override
	public List<Item> findAll() {
		return clientFeign.listar().stream().map(p->new Item(p,1)).toList();
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item (clientFeign.detalle(id), cantidad);
	}

}
