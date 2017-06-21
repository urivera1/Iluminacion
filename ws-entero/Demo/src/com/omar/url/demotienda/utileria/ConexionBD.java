package com.omar.url.demotienda.utileria;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

	// static String server = "//DESKTOP-F1FVQ1L\\SERVER";
	// static String puerto = "1433";
	// static String BD = "BDEntrenamiento";
	// static String user = "bdjava";
	// static String pass = "root";
	static String server = "";
	static String puerto = "";
	static String BD = "";
	static String user = "";
	static String pass = "";

	public static Connection conectaBD() {
		Connection con = null;
		try {
			// String url = "jdbc:sqlserver:" + server + ":" + puerto
			// + ";databaseName=" + BD + ";user=" + user + ";password="
			// + pass + ";";
			// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:postgresql://" + server + "/" + BD;
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e);
		}
		return con;
	}
}
