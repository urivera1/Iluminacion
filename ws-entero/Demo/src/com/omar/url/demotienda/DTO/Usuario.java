package com.omar.url.demotienda.DTO;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 2826669608774167910L;
	private String idUs;
	private String nombre;
	private boolean estatus;
	private String tipo;
	private String clave;
	private String nip;
	private String estatusInsert;
	//Opcional para la tabla de TIPO_USUARIO
	private Tipo_Usuario tipoUsuario;
	
	public Tipo_Usuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(Tipo_Usuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getIdUs() {
		return idUs;
	}
	public void setIdUs(String idUs) {
		this.idUs = idUs;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isEstatus() {
		return estatus;
	}
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNip() {
		return nip;
	}
	public void setNip(String nip) {
		this.nip = nip;
	}
	public String getEstatusInsert() {
		return estatusInsert;
	}
	public void setEstatusInsert(String estatusInsert) {
		this.estatusInsert = estatusInsert;
	}

}
