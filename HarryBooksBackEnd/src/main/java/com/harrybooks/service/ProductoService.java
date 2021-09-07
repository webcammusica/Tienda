package com.harrybooks.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.stereotype.Service;

import com.harrybooks.exception.ResourceNotFoundException;
import com.harrybooks.model.Producto;

@Service
public class ProductoService{
	
	private Producto prod1 = new Producto(100, "Harry Potter y la piedra filosofal", 23, BigDecimal.valueOf(50000), 0);
	private Producto prod2 = new Producto(101, "Harry Potter y la cámara secreta", 29, BigDecimal.valueOf(40000), 0);
	private Producto prod3 = new Producto(102, "Harry Potter y las reliquias de la Muerte", 29, BigDecimal.valueOf(40000), 0);
	private Producto prod4 = new Producto(103, "Harry Potter y el cáliz de fuego", 29, BigDecimal.valueOf(40000), 0);	
	private Producto prod5 = new Producto(104, "Harry Potter y la Orden del Fénix", 29, BigDecimal.valueOf(40000), 0);	
	private Producto prod6 = new Producto(105, "Harry Potter y el misterio del príncipe", 29, BigDecimal.valueOf(40000), 0);	
	private Producto prod7 = new Producto(106, "Harry Potter y las reliquias de la Muerte", 29, BigDecimal.valueOf(40000), 0);		
	private Producto prod8 = new Producto(107, "Harry Potter y el legado maldito", 29, BigDecimal.valueOf(40000), 0);	
	private List<Producto> listaItems = new ArrayList<Producto>();
	private List<Producto> listaProductos = new ArrayList<Producto>();


	public List<Producto> getAllProductos() throws ResourceNotFoundException{
		if (listaProductos.isEmpty()) {
			this.listaProductos.add(prod1);
			this.listaProductos.add(prod2);
			this.listaProductos.add(prod3);
			this.listaProductos.add(prod4);
			this.listaProductos.add(prod5);
			this.listaProductos.add(prod6);
			this.listaProductos.add(prod7);
			this.listaProductos.add(prod8);
			return this.listaProductos;
		} else {
			System.out.println("entra al else");
			System.out.println("Lista"+listaProductos.toString());
					
			for (int i=0;i<listaProductos.size();i++) {
					      
				System.out.println(listaProductos.get(i).getNombreProducto());
			}
			return this.listaProductos;
		} 
	}
	
	public List<Producto> getAllItems() throws ResourceNotFoundException{
		if (this.listaItems.isEmpty()){
		return this.listaItems;
		}else
		return this.listaItems;
	}
	
	public Producto createProducto(Producto nuevoProducto) throws ResourceNotFoundException{
		boolean enCarrito = false;
		if (nuevoProducto.getNombreProducto().isBlank()) {
			System.out.println("entra a nombre vacío");
			throw new ResourceNotFoundException("El nombre no puede estar vacío");
		} else {
			for(int i=0; i <= this.listaItems.size()-1; i++) {
				
				if(listaItems.get(i).getNombreProducto().equals(nuevoProducto.getNombreProducto())) {
					enCarrito = true;
				}
			}
			if(!enCarrito) {
			this.listaItems.add(nuevoProducto);
			return nuevoProducto;
			}else {
				System.out.println("El item ya está en el carrito");
				throw new ResourceNotFoundException("Solo se puede añadir un item por libro");
			}
		}
				
		
	}
	
	public List<Producto> descontarCompras() throws ResourceNotFoundException{
		for (int i=0;i<this.listaProductos.size();i++) {
			for (int j=0;j<this.listaItems.size();j++) {
				if (this.listaProductos.get(i).getNombreProducto().equals(this.listaItems.get(j).getNombreProducto())) {
					this.listaProductos.get(i).setDescripcionProducto(this.listaProductos.get(i).getDescripcionProducto() - this.listaItems.get(j).getTipoProducto());
				    this.listaItems.remove(j);
				}	
			}
		}
		
		return this.listaProductos;
		
	}
	 
	
	public Producto updateProducto(Integer id, Producto productoModificado) throws ResourceNotFoundException{		
		if(positionById(id) != -1) {
			productoModificado.setIdProducto(id);
			this.listaItems.set(positionById(id), productoModificado);
			return productoModificado;
		} else {
			throw new ResourceNotFoundException("El ID no existe");
		}
		
				
		
	}
	
	public void deleteProducto(Integer id) throws ResourceNotFoundException{	
		System.out.println("entra a delete");
		
		if(positionById(id) != -1) {
			this.listaItems.remove(positionById(id).intValue());
		} else {
			throw new ResourceNotFoundException("El ID no existe");
		}
		
	}
	
	public Integer positionById(Integer id) {
			
		for(int i=0; i <= this.listaItems.size()-1; i++) {
			
			if(this.listaItems.get(i).getIdProducto() == id) {
				System.out.println("id:" + id + " encontrado en la posición: " + i);
				return i;
			}
		}
		System.out.println("id NO encontrado");
		
		return -1;
		
	}

}
