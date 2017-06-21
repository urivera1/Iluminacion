package com.omar.url.demotienda.entidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.omar.url.demotienda.DTO.Almacen;

public class AlmacenDAO {

	public List<Almacen> consultaDatos(Connection con)throws Exception {
		List<Almacen> lista = new ArrayList<Almacen>();
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ALMACEN";
		stm = con.createStatement();
		rs = stm.executeQuery(sql);
		while(rs.next()){
			Almacen al = new Almacen();
			al.setId(rs.getString("ID_PRODUCTO"));
			al.setProducto(rs.getString("DESCRIPCION"));
			al.setPrecioTot(rs.getString("PRECIO_TOTAL"));
			al.setPrecioFin(rs.getString("PRECIO_FINAL"));
			lista.add(al);
		}
		return lista;
	}

}
