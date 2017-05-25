package br.com.palavraFiel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");// essa linha pode resolver o problema
			return DriverManager.getConnection("jdbc:mysql://localhost/palavra_fiel", "root", "020590");
		}catch(SQLException | ClassNotFoundException e){
			throw new RuntimeException(e);
		}
		
	}
}
