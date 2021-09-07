package com.harrybooks.model;

public class TipoProducto {
	private Integer  idTipoProducto;
	private String 	 nombreTipoProducto;
	
	
	public TipoProducto(Integer idTipoProducto, String nombreTipoProducto) {
		this.idTipoProducto = idTipoProducto;
		this.nombreTipoProducto = nombreTipoProducto;
	}
	
	/**
	 * @return the idTipoProducto
	 */
	public Integer getIdTipoProducto() {
		return idTipoProducto;
	}
	/**
	 * @param idTipoProducto the idTipoProducto to set
	 */
	public void setIdTipoProducto(Integer idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}
	/**
	 * @return the nombreTipoProducto
	 */
	public String getNombreTipoProducto() {
		return nombreTipoProducto;
	}
	/**
	 * @param nombreTipoProducto the nombreTipoProducto to set
	 */
	public void setNombreTipoProducto(String nombreTipoProducto) {
		this.nombreTipoProducto = nombreTipoProducto;
	}

	
}
