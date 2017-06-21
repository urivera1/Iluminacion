package com.omar.url.demotienda.ctrl;

import java.sql.Connection;
import java.util.List;

import com.omar.url.demotienda.DTO.MercanciaProovedor;
import com.omar.url.demotienda.DTO.Proovedor;
import com.omar.url.demotienda.entidades.ProovedorDAO;
import com.omar.url.demotienda.utileria.ConexionBD;

public class CtrlProovedor {

	Connection con = null;
	ProovedorDAO pro = new ProovedorDAO();
	
	List<Proovedor> proList = null;
	List<MercanciaProovedor> mercancia = null;
	
	public void buscaProovedores()throws Exception {
		con = ConexionBD.conectaBD();
		proList = pro.consulta(con);
	}
	public List<Proovedor> getProList() {
		return proList;
	}
	public void setProList(List<Proovedor> proList) {
		this.proList = proList;
	}
	public void buscaDetalle(String idpro)throws Exception {
		con = ConexionBD.conectaBD();
		mercancia = pro.buscaMercaciaProv(idpro,con);
	}
	public List<MercanciaProovedor> getMercancia() {
		return mercancia;
	}
	public void setMercancia(List<MercanciaProovedor> mercancia) {
		this.mercancia = mercancia;
	}
	public void guardaNuevoProovedor(List<MercanciaProovedor> listaProd, Proovedor nuevo)throws Exception {
		con = ConexionBD.conectaBD();
		pro.guardaProovedor(listaProd,nuevo,con);
	}
	
}
