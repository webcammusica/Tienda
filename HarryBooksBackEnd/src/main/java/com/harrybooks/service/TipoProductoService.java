package com.harrybooks.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.harrybooks.exception.ResourceNotFoundException;
import com.harrybooks.model.TipoProducto;

@Service
public class TipoProductoService {
	
	List<TipoProducto> listaTiposProducto = new ArrayList<TipoProducto>();
	
	public List<TipoProducto> getAllTiposProducto() throws ResourceNotFoundException{
		
		if (listaTiposProducto.isEmpty()) {
			
			listaTiposProducto.add(new TipoProducto(1,"Camiseta"));
			listaTiposProducto.add(new TipoProducto(2,"Vaso"));
			listaTiposProducto.add(new TipoProducto(3,"Comic"));
			listaTiposProducto.add(new TipoProducto(4,"Juguete"));
			listaTiposProducto.add(new TipoProducto(5,"Accesorio"));
			
			throw new ResourceNotFoundException("No existen tipos de producto creados"); 
		} else {
			System.out.println("La lista de tipoos de producto contiene elementos");
			return listaTiposProducto;
		} 
	}


}
