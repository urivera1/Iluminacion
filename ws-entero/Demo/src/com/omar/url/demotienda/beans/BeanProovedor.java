package com.omar.url.demotienda.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.omar.url.demotienda.DTO.MercanciaProovedor;
import com.omar.url.demotienda.DTO.Proovedor;
import com.omar.url.demotienda.ctrl.CtrlProovedor;
import com.omar.url.demotienda.utileria.Mensajeria;

@ManagedBean
@ViewScoped
public class BeanProovedor extends Mensajeria {

	private String txtNombre = null;
	private String txtDireccion = null;
	private String txtTelefono = null;
	private String txtRfc = null;
	private String txtMercancia = null;
	private String txtprecio = null;
	private String cboEstatus = null;
	private List listaProd = new ArrayList();
	private Proovedor nuevo = new Proovedor();
	private MercanciaProovedor proNuevo = new MercanciaProovedor();
    String action = "";

	CtrlProovedor ctrl = new CtrlProovedor();

	public BeanProovedor() {
		try {
			consultaDatosIniciales();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e);
			alerta("", "Hubo un error con la cagra de parametros");
		}
	}

	private void consultaDatosIniciales() throws Exception {
		ctrl.buscaProovedores();
	}

	public String nuevoProovedor() {
		String action = "pages/nuevoproovedor.xhtml";
		return action;
	}

	public void buscaDetalleprov(String idpro) {
		try {
			ctrl.buscaDetalle(idpro);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e);
		}
	}

	public void agregaproductos() {
		MercanciaProovedor merca = new MercanciaProovedor();
		try {
			if (txtMercancia == null && txtprecio == null) {
				alerta("",
						"Es necesario especificar el nombre del producto y el precio que el proovedor le ha dado");
				return;
			} else {
				merca.setDesc(txtMercancia);
				merca.setPrecio(txtprecio);
				listaProd.add(merca);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	public String guardarDatos() {

		try {
			nuevo.setNombre(txtNombre);
			nuevo.setDireccion(txtDireccion);
			nuevo.setTelefono(txtTelefono);
			nuevo.setRfc(txtRfc);
			nuevo.setEstatus(cboEstatus);
			ctrl.guardaNuevoProovedor(listaProd, nuevo);
			limpia();
			action = "pages/proovedores.xhtml";
		} catch (Exception e) {
			e.printStackTrace();
			error("Error",
					"Ocurrio un error durante el guardado de datos, revise si tiene buena señal de wifi");
			action = "pages/inicio.xhtml";
		}
		return action;
	}

	public void limpia() {
		txtDireccion = null;
		txtMercancia = null;
		txtNombre = null;
		txtprecio = null;
		txtRfc = null;
		txtTelefono = null;
		cboEstatus = null;
	}

	public List<MercanciaProovedor> listaproductos() {
		return listaProd;
	}

	public List<Proovedor> proovedores() {
		return ctrl.getProList();
	}

	public List<MercanciaProovedor> mercanciaPro() {
		return ctrl.getMercancia();
	}

	public String getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(String txtNombre) {
		this.txtNombre = txtNombre;
	}

	public String getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(String txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	public String getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(String txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public String getTxtRfc() {
		return txtRfc;
	}

	public void setTxtRfc(String txtRfc) {
		this.txtRfc = txtRfc;
	}

	public String getCboEstatus() {
		return cboEstatus;
	}

	public void setCboEstatus(String cboEstatus) {
		this.cboEstatus = cboEstatus;
	}

	public String getTxtMercancia() {
		return txtMercancia;
	}

	public void setTxtMercancia(String txtMercancia) {
		this.txtMercancia = txtMercancia;
	}

	public String getTxtprecio() {
		return txtprecio;
	}

	public void setTxtprecio(String txtprecio) {
		this.txtprecio = txtprecio;
	}

}
