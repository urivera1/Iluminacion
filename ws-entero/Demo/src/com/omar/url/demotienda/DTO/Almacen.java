package com.omar.url.demotienda.DTO;

public class Almacen {
	
	private String id;
	private String producto;
	private String precioTot;
	private String precioFin;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getPrecioTot() {
		return precioTot;
	}
	public void setPrecioTot(String precioTot) {
		this.precioTot = precioTot;
	}
	public String getPrecioFin() {
		return precioFin;
	}
	public void setPrecioFin(String precioFin) {
		this.precioFin = precioFin;
	}

}
