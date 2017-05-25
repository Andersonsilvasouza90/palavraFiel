package br.com.palavraFiel.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Driver;

import br.com.palavraFiel.dao.ConnectionFactory;



@WebServlet("/pegarNoticia")
public class getNoticias extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public getNoticias(){
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("servidor funcionando.");
		
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "nocache");
		response.setCharacterEncoding("utf-8");
		
		try {
			
			//Connection conexao = new ConnectionFactory().getConnection();
			
			/*String sql = "select * from pessoas";	
			PreparedStatement stmt = (PreparedStatement) this.conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();*/
			
			JSONArray jsonArray = new JSONArray();		
			
			JSONObject jsonObject = new JSONObject();		
			jsonObject.put("nome", "Anderson");		
			jsonObject.put("cidade", "Guarulhos");
			jsonArray.put(jsonObject);
			
			jsonObject = new JSONObject();
			jsonObject.put("nome", "Carina");
			jsonObject.put("cidade", "Arujá");
			jsonArray.put(jsonObject);
			
			jsonObject = new JSONObject();
			jsonObject.put("nome", "Dandy");
			jsonObject.put("cidade", "São Paulo");
			jsonArray.put(jsonObject);
			
			jsonObject = new JSONObject();
			jsonObject.put("nome", "José");
			jsonObject.put("cidade", "Teste");
			jsonArray.put(jsonObject);
			
			response.getWriter().write(jsonArray.toString());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
