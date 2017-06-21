package com.omar.url.demotienda.beans;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.omar.url.demotienda.DTO.Almacen;
import com.omar.url.demotienda.ctrl.CtrlAlmacen;

@ManagedBean
@ViewScoped
public class BeanAlmacen {

	private String txtCantidad = null;
	private String txtProducto = null;
	private String txtPrecioTot = null;
	private String txtPrecioFinal = null;
	
	CtrlAlmacen ctrl = new CtrlAlmacen();
	public BeanAlmacen() {
		try {
			consultaDatosIniciales();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void consultaDatosIniciales()throws Exception {
		ctrl.consultaDatos();
	}

	public void exportaDatos() {
		try {
			String ruta = System.getProperty("user.home") + "/almacen.xls";
			File archivo = new File(ruta);
			archivo.createNewFile();
			if (archivo.exists()) {
				archivo.delete();
				archivo.createNewFile();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Almacen> getValues()
	{
		return ctrl.getListAlmacen();
	}

	public String getTxtCantidad() {
		return txtCantidad;
	}

	public void setTxtCantidad(String txtCantidad) {
		this.txtCantidad = txtCantidad;
	}

	public String getTxtProducto() {
		return txtProducto;
	}

	public void setTxtProducto(String txtProducto) {
		this.txtProducto = txtProducto;
	}

	public String getTxtPrecioTot() {
		return txtPrecioTot;
	}

	public void setTxtPrecioTot(String txtPrecioTot) {
		this.txtPrecioTot = txtPrecioTot;
	}

	public String getTxtPrecioFinal() {
		return txtPrecioFinal;
	}

	public void setTxtPrecioFinal(String txtPrecioFinal) {
		this.txtPrecioFinal = txtPrecioFinal;
	}
}
