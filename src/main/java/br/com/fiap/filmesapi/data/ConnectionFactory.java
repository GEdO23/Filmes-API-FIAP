package br.com.fiap.filmesapi.data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionFactory {
	public static Connection getConnection() throws SQLException {
	    String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
	    String USER = "rm99632";
	    String PASS = "230605";
	    try {
	    	Class.forName("oracle.jdbc.driver.OracleDriver");
	    	return DriverManager.getConnection(URL, USER, PASS);
	    	
	    } catch(ClassNotFoundException error) {
	    	error.getMessage();
	    	error.printStackTrace();
	    }
		return null;
    }
}