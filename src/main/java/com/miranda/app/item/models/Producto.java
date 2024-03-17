package com.miranda.app.item.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
	
	private Long id;
	
	private String nombre;
	
	private Double precio;
	
	private LocalDate createAt;
	

}
