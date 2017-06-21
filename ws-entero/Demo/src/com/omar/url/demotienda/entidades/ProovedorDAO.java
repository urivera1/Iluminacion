package com.omar.url.demotienda.entidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.omar.url.demotienda.DTO.Proovedor;
import com.omar.url.demotienda.DTO.MercanciaProovedor;
import com.omar.url.demotienda.utileria.Constantes;
import com.omar.url.demotienda.utileria.TransaccionesSQL;

public class ProovedorDAO implements TransaccionesSQL {

	@Override
	public List consulta(Connection con) throws Exception {
		List prolist = new ArrayList();
		Proovedor pro = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PROOVEDOR";
		stm = con.createStatement();
		rs = stm.executeQuery(sql);
		while (rs.next()) {
			pro = new Proovedor();
			pro.setIdProovedor(rs.getString("ID_PROOVEDOR"));
			pro.setNombre(rs.getString("NOMBRE"));
			pro.setDireccion(rs.getString("DIRECCION"));
			pro.setRfc(rs.getString("RFC"));
			pro.setTelefono(rs.getString("TELEFONO"));
			pro.setEstatus(rs.getString("ESTATUS"));
			prolist.add(pro);
		}
		return prolist;
	}

	@Override
	public void elimina(String param, Connection con) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void agrega(Object obj, Connection con) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Object actualiza(String param1, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List buscaMercaciaProv(String idpro, Connection con)
			throws Exception {
		List listaMerca = new ArrayList();
		MercanciaProovedor merc = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MERCANCIA_PROOVEDOR WHERE PROOVEDOR_ID ="
				+ idpro;
		stm = con.createStatement();
		rs = stm.executeQuery(sql);
		while (rs.next()) {
			merc = new MercanciaProovedor();
			merc.setIdMerc(rs.getString("ID_MERCANCIA"));
			merc.setDesc(rs.getString("DESCRIPCION"));
			merc.setPrecio(rs.getString("PRECIO"));
			merc.setProovedor(rs.getString("PROOVEDOR_ID"));
			listaMerca.add(merc);
		}
		return listaMerca;
	}

	public void guardaProovedor(List<MercanciaProovedor> listaProd,
			Proovedor nuevo, Connection con) throws Exception {
		Statement stm = null;
		String sql = "insert into proovedor (nombre,direccion,telefono,rfc,estatus) values('"
				+ nuevo.getNombre()
				+ "','"
				+ nuevo.getDireccion()
				+ "','"
				+ nuevo.getTelefono()
				+ "','"
				+ nuevo.getRfc()
				+ "',"
				+ Integer.parseInt(nuevo.getEstatus()) + ")";
		String sql1 = "select id_proovedor from proovedor where nombre ='"+nuevo.getNombre()+"'"; 
		stm = con.createStatement();
		stm.execute(sql);
		ResultSet rs = stm.executeQuery(sql1);
		while(rs.next()){
			Proovedor prop = new Proovedor();
			prop.setIdProovedor(rs.getString("ID_PROOVEDOR"));
			retornaString(listaProd, prop.getIdProovedor(),con);
		}
	}

	private void retornaString(List<MercanciaProovedor> listaProd,
			String id,Connection con) throws Exception {
		String cadena = "";
		Statement stm = null;
		for (MercanciaProovedor mer : listaProd) {
			stm = con.createStatement();
			cadena += "insert into mercancia_proovedor (descripcion,precio,proovedor_id) values('"
					+ mer.getDesc()
					+ "','$"
					+ mer.getPrecio()
					+ "',"
					+ Integer.parseInt(id) + ")";
			stm.execute(cadena);
			cadena = "";
		}
	}

}
