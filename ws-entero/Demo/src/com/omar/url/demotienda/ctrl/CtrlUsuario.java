package com.omar.url.demotienda.ctrl;

import java.sql.Connection;
import java.util.List;

import com.omar.url.demotienda.DTO.Tipo_Usuario;
import com.omar.url.demotienda.DTO.Usuario;
import com.omar.url.demotienda.entidades.UsuarioDAO;
import com.omar.url.demotienda.utileria.ConexionBD;

public class CtrlUsuario {
	
	List<Usuario> listaUser = null;
	List<Tipo_Usuario> listaTipos = null;
	UsuarioDAO us = new UsuarioDAO();
	Connection con = null;

	public void ejecutaBusquedaInicial()throws Exception {
		con = ConexionBD.conectaBD();
		listaUser = us.consulta(con);
		listaTipos = us.tipoUs(con);
	}

	public List<Usuario> getListaUser() {
		return listaUser;
	}

	public void setListaUser(List<Usuario> listaUser) {
		this.listaUser = listaUser;
	}

	public List<Tipo_Usuario> getListaTipos() {
		return listaTipos;
	}

	public void setListaTipos(List<Tipo_Usuario> listaTipos) {
		this.listaTipos = listaTipos;
	}

	public void guardaNuevoUsuario(Usuario us2) throws Exception {
		con = ConexionBD.conectaBD();
		us.agrega(us2, con);
	}

}
