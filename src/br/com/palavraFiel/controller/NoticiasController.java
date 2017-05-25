package br.com.palavraFiel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import br.com.palavraFiel.dao.DaoImplementacao;
import br.com.palavraFiel.dao.DaoInterface;
import br.com.palavraFiel.model.Noticia;

@Controller
@RequestMapping(value="/noticias")
public class NoticiasController extends DaoImplementacao<Noticia> implements DaoInterface<Noticia> {
	
	public NoticiasController(Class<Noticia> persistenceClass) {
		super(persistenceClass);
	}
	
	@RequestMapping(value="listar", method=RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public String listar(){
		List<Noticia> noticias = new ArrayList<Noticia>();
		
		Noticia noticia = new Noticia();
		noticia.setId(10L);
		noticia.setId_usuario(1L);
		noticia.setTitulo("Títulooooo");
		noticia.setNoticia("desc noticia");
		
		noticia = new Noticia();
		noticia.setId(11L);
		noticia.setId_usuario(1L);
		noticia.setTitulo("Títulooooo");
		noticia.setNoticia("desc noticia");
		
		
		noticias.add(noticia);
		
		return new Gson().toJson(noticias);
		
	}
	
	

}
