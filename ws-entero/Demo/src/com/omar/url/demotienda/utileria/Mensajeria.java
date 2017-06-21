package com.omar.url.demotienda.utileria;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Mensajeria {

	 public void notificacion(String encabezado,String mensaje) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, encabezado, mensaje));
	    }
	     
	    public void alerta(String encabezado,String mensaje) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, encabezado, mensaje));
	    }
	     
	    public void error(String encabezado,String mensaje) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, encabezado, mensaje));
	    }
	     
	    public void excepcion(String encabezado,String mensaje) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, encabezado, mensaje));
	    }
}
