package com.omar.url.demotienda.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.omar.url.demotienda.DTO.Tipo_Usuario;
import com.omar.url.demotienda.DTO.Usuario;
import com.omar.url.demotienda.ctrl.CtrlUsuario;
import com.omar.url.demotienda.utileria.Mensajeria;


@ManagedBean
@ViewScoped
public class BeanUsuario extends Mensajeria{
	
	private String txtNombre = null;
	private String txtCve = null;
	private String txtNip = null;
	private String cboEstatus = null;
	private String cboTipoUs = null;
	static String action = "";

	CtrlUsuario ctrl = new CtrlUsuario();
	public BeanUsuario() {
		try{
			busquedaInicial();
		}catch(Exception e){
			e.printStackTrace();
			System.out.print(e);
			return;
		}
	}
	
	public String guardaDatosUsuario(){
		try{
			Usuario us = new Usuario();
			us.setNombre(txtNombre);
			us.setClave(txtCve);
			us.setNip(txtNip);
			us.setEstatusInsert(cboEstatus);
			us.setTipo(cboTipoUs);
			ctrl.guardaNuevoUsuario(us);
			limpaCampos();
			action = "pages/personal.xhtml";
		}catch(Exception e){
			e.printStackTrace();
			error("Error", "Ocurrio un error");
			action = "pages/inicio.xhtml";
		}
		return action;
	}

	private void limpaCampos() {
		txtCve = null;
		txtNip = null;
		txtNombre = null;
		cboEstatus = null;
		cboTipoUs = null;
		
	}

	private void busquedaInicial()throws Exception {
		ctrl.ejecutaBusquedaInicial();
	}

	public List<Usuario> listaUsuarios(){
		return ctrl.getListaUser();
	}
	
	public List<Tipo_Usuario> listaTipo(){
		return ctrl.getListaTipos();
	}

	public String getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(String txtNombre) {
		this.txtNombre = txtNombre;
	}

	public String getTxtCve() {
		return txtCve;
	}

	public void setTxtCve(String txtCve) {
		this.txtCve = txtCve;
	}

	public String getTxtNip() {
		return txtNip;
	}

	public void setTxtNip(String txtNip) {
		this.txtNip = txtNip;
	}

	public String getCboEstatus() {
		return cboEstatus;
	}

	public void setCboEstatus(String cboEstatus) {
		this.cboEstatus = cboEstatus;
	}

	public String getCboTipoUs() {
		return cboTipoUs;
	}

	public void setCboTipoUs(String cboTipoUs) {
		this.cboTipoUs = cboTipoUs;
	}
	
}
