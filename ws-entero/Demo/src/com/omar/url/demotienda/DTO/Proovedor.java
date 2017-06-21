package com.omar.url.demotienda.DTO;

import java.io.Serializable;

public class Proovedor implements Serializable{
	

	private static final long serialVersionUID = -8841167505408487620L;
	private String idProovedor;
	private String nombre;
	private String direccion;
	private String rfc;
	private String telefono;
	private String estatus;	
	private static String ACTIVO = "1";
	private static String INACTIVO = "0";
	
	public String getIdProovedor() {
		return idProovedor;
	}
	public void setIdProovedor(String idProovedor) {
		this.idProovedor = idProovedor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public static String getACTIVO() {
		return ACTIVO;
	}
	public static void setACTIVO(String aCTIVO) {
		ACTIVO = "1";
	}
	public static String getINACTIVO() {
		return INACTIVO;
	}
	public static void setINACTIVO(String iNACTIVO) {
		INACTIVO = "0";
	}
	
	
}
