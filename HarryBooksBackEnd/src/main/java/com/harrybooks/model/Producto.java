package com.harrybooks.model;

import java.math.BigDecimal;



public class Producto {
	
	private Integer  		idProducto;
	private String 			nombreProducto;
	private Integer			descripcionProducto;
	private BigDecimal 		valorProducto;
	private Integer 		tipoProducto;
	
	private static int		autoIncrement = 1;
	
	public Producto(Integer idProducto, String nombreProducto, Integer descripcionProducto, BigDecimal valorProducto, Integer tipoProducto) {
		setIdProducto(autoIncrement++);
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.valorProducto = valorProducto;
		this.tipoProducto = tipoProducto;
	}


	

	/**
	 * @return the idProducto
	 */
	public Integer getIdProducto() {
		return idProducto;
	}

	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	/**
	 * @return the nombreProducto
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}

	/**
	 * @param nombreProducto the nombreProducto to set
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	/**
	 * @return the descripcionProducto
	 */
	public Integer getDescripcionProducto() {
		return descripcionProducto;
	}

	/**
	 * @param descripcionProducto the descripcionProducto to set
	 */
	public void setDescripcionProducto(Integer descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	/**
	 * @return the valorProducto
	 */
	public BigDecimal getValorProducto() {
		return valorProducto;
	}

	/**
	 * @param valorProducto the valorProducto to set
	 */
	public void setValorProducto(BigDecimal valorProducto) {
		this.valorProducto = valorProducto;
	}

	/**
	 * @return the tipoProducto
	 */
	public Integer getTipoProducto() {
		return tipoProducto;
	}

	/**
	 * @param tipoProducto the tipoProducto to set
	 */
	public void setTipoProducto(Integer tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	

}
