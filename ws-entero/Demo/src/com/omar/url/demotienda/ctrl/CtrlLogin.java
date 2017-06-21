package com.omar.url.demotienda.ctrl;

import java.sql.Connection;

import com.omar.url.demotienda.DTO.Usuario;
import com.omar.url.demotienda.entidades.UsuarioDAO;
import com.omar.url.demotienda.utileria.ConexionBD;

public class CtrlLogin {
	
	Connection con = null;
	private Usuario usuario = null;
	private UsuarioDAO us = new UsuarioDAO();
	public CtrlLogin() {
		// TODO Auto-generated constructor stub
	}

	public Usuario verificaUsuario(String txtClave, String txtNip)throws Exception {
		con = ConexionBD.conectaBD();
		this.usuario = us.consultaUser(txtClave,txtNip,con);
		return usuario;
	}

}
