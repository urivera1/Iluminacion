package com.omar.url.demotienda.entidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.omar.url.demotienda.DTO.Tipo_Usuario;
import com.omar.url.demotienda.DTO.Usuario;
import com.omar.url.demotienda.utileria.Constantes;
import com.omar.url.demotienda.utileria.TransaccionesSQL;

public class UsuarioDAO implements TransaccionesSQL {

	public Usuario consultaUser(String txtClave, String txtNip, Connection con)
			throws Exception {
		Usuario us = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT u.*,t.id_tipo FROM USUARIO u"
				+ " INNER JOIN TIPO_USUARIO t on t.id_tipo = u.tipo_usuario"
				+ " WHERE CLAVE ='" + txtClave + "' AND NIP = '" + txtNip
				+ "' AND TIPO_USUARIO = " + Constantes.ADMINISTRADOR;
		stm = con.createStatement();
		rs = stm.executeQuery(sql);
		while (rs.next()) {
			us = new Usuario();
			us.setNombre(rs.getString("NOMBRE"));
			us.setEstatus(rs.getBoolean("ESTATUS"));
			us.setTipo(rs.getString("TIPO_USUARIO"));
			us.setClave(rs.getString("CLAVE"));
			us.setNip(rs.getString("NIP"));
		}
		return us;
	}

	@Override
	public List<Usuario> consulta(Connection con) throws Exception {
		List listaUs = new ArrayList();
		Usuario us = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM USUARIO";
		stm = con.createStatement();
		rs = stm.executeQuery(sql);
		while (rs.next()) {
		    us = new Usuario();
			us.setNombre(rs.getString("NOMBRE"));
			us.setClave(rs.getString("CLAVE"));
			us.setNip(rs.getString("NIP"));
			us.setTipo(rs.getString("TIPO_USUARIO"));
			us.setEstatus(rs.getBoolean("ESTATUS"));
			us.setTipoUsuario(buscaTipos(us.getTipo(), con));
			listaUs.add(us);
		}
		return listaUs;
	}

	private Tipo_Usuario buscaTipos(String tipo, Connection con)
			throws Exception {
		Tipo_Usuario tipous = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TIPO_USUARIO WHERE ID_TIPO =" + tipo;
		stm = con.createStatement();
		rs = stm.executeQuery(sql);
		while (rs.next()) {
			tipous = new Tipo_Usuario();
			tipous.setIdTipo(rs.getInt("ID_TIPO"));
			tipous.setDescripcion(rs.getString("DESCRIPCION"));
		}
		return tipous;
	}

	@Override
	public void elimina(String param, Connection con) throws Exception {
		// TODO Auto-generated method stub

	}

	public void agrega(Usuario obj, Connection con) throws Exception {
		Statement stm = null;
		ResultSet rs = null;
		stm = con.createStatement();
		String sql = "Insert into usuario (NOMBRE,ESTATUS,CLAVE,NIP,TIPO_USUARIO) VALUES"
				+ "('"
				+ obj.getNombre()
				+ "',"
				+ obj.getEstatusInsert()
				+ ",'"
				+ obj.getClave()
				+ "','"
				+ obj.getNip()
				+ "',"
				+ obj.getTipo()
				+ ");";
		stm.execute(sql);
	}

	@Override
	public Object actualiza(String param1, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Tipo_Usuario> tipoUs(Connection con) throws Exception {
		List<Tipo_Usuario> lista = new ArrayList<Tipo_Usuario>();
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TIPO_USUARIO";
		stm = con.createStatement();
		rs = stm.executeQuery(sql);
		while (rs.next()) {
			Tipo_Usuario tipous = new Tipo_Usuario();
			tipous.setIdTipo(rs.getInt("ID_TIPO"));
			tipous.setDescripcion(rs.getString("DESCRIPCION"));
			lista.add(tipous);
		}
		return lista;
	}

	@Override
	public void agrega(Object obj, Connection con) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
