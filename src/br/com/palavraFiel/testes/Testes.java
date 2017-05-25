package br.com.palavraFiel.testes;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import br.com.palavraFiel.dao.ConnectionFactory;

public class Testes {

	public static void main(String[] args) throws SQLException {

		Connection conexao = new ConnectionFactory().getConnection();
		
		if(!conexao.isClosed()){
			System.out.println("Passo1: Conexão aberta");
		}
		
		String sql = "insert into noticias (id_usuario, titulo, noticia) values (1,'teste titulo','teste noticia')";
		
		PreparedStatement stmt =  (PreparedStatement) conexao.prepareStatement(sql);
		
		stmt.execute();
		
		conexao.close();
		
		if(conexao.isClosed()){
			System.out.println("Passo2: Conexão Fechada");
		}
		
	}

}
