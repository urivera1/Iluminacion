package com.omar.url.demotienda.utileria;

import java.sql.Connection;
import java.util.List;

public interface TransaccionesSQL {

	public List consulta(Connection con)throws Exception;
	
	public Object actualiza(String param1,Connection con)throws Exception;
	
	public void elimina(String param,Connection con)throws Exception;
	
	public void agrega(Object obj,Connection con)throws Exception;
}
