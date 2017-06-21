package com.omar.url.demotienda.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.omar.url.demotienda.DTO.Usuario;
import com.omar.url.demotienda.ctrl.CtrlLogin;
import com.omar.url.demotienda.utileria.Mensajeria;

@ViewScoped
@ManagedBean
public class BeanLogin extends Mensajeria{

	private String txtClave = null;
	private String txtNip = null;
	private Usuario us = null;
	CtrlLogin ctrl = new CtrlLogin();
	
	public String validaUsuario()
	{
		String action = "";
		try{
		us = ctrl.verificaUsuario(txtClave,txtNip);
		if(us != null)
		   action = "pages/inicio.xhtml";
		else
			alerta("", "Clave o Nip Erroneos");
		return action;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			excepcion("Falla en señal", "Ocurrio un error durante la firma del usuario");
		}
		return action;
	}

	public Usuario getUs() {
		return us;
	}

	public void setUs(Usuario us) {
		this.us = us;
	}

	public String getTxtClave() {
		return txtClave;
	}

	public void setTxtClave(String txtClave) {
		this.txtClave = txtClave;
	}

	public String getTxtNip() {
		return txtNip;
	}

	public void setTxtNip(String txtNip) {
		this.txtNip = txtNip;
	}
	
}
