package com.omar.url.demotienda.ctrl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.omar.url.demotienda.DTO.Almacen;
import com.omar.url.demotienda.entidades.AlmacenDAO;
import com.omar.url.demotienda.utileria.ConexionBD;

public class CtrlAlmacen {
	
	Connection con = null;
	List<Almacen> listAlmacen = new ArrayList<Almacen>();
	AlmacenDAO almacen = new AlmacenDAO();

	public void consultaDatos()throws Exception {
		con = ConexionBD.conectaBD();
		listAlmacen = almacen.consultaDatos(con);
	}

	public List<Almacen> getListAlmacen() {
		return listAlmacen;
	}

	public void setListAlmacen(List<Almacen> listAlmacen) {
		this.listAlmacen = listAlmacen;
	}

}
