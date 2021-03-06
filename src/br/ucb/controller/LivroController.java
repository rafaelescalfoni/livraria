package br.ucb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.ucb.dao.DAOFactory;
import br.ucb.model.Livro;
import br.ucb.utils.componentes.UserSession;
import static br.com.caelum.vraptor.view.Results.xml;
import static br.com.caelum.vraptor.view.Results.json;

@Resource
public class LivroController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;
	
	public LivroController(Result result, UserSession userSession, DAOFactory dao){
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = dao;
	}
	
	@Get @Path("/livros")
	public void lista() {
		List<Livro> livroList =  daoFactory.getLivroDAO().list();
		String data = "[";
		int contador = 1;
		for(Livro l:livroList) {
			data += "['" + l.getTitulo() + "', '" + l.getGenero().getNome() +"','"+ l.getAutor()  + "']";
			if (contador != livroList.size()) {
				data += ", ";
			}
		}
		data +="]";
		result.include("data", data);
	}

	
	@Get @Path("/livros/{inicio}/{fim}")
	public void list(int inicio, int fim) {
		String strQuery = "FROM Livro l";
		Map<String, Object> params = new HashMap<String, Object>();
		List<Livro> lista = daoFactory.getLivroDAO().list(strQuery, params, inicio, fim);
		result.use(Results.xml()).from(lista, "livros").serialize();
	}
	
	@Get("/livro/{livroId}")
	public void formulario(Long livroId) {
		Livro livro = daoFactory.getLivroDAO().get(livroId); //pesquisar o livro no bd
		result.include("livro", livro); //botar o livro a disposiçào da jsp
	}
	
	
	@Get("/livro/{livroTitulo}")
	public void pesquisaLivro(String livroTitulo) {
		String strQuery = "FROM Livro l WHERE l.titulo like :titulo";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("titulo", livroTitulo + "%");
		System.out.println("\n titulo digitado = " + livroTitulo);
		Livro livroEncontrado = daoFactory.getLivroDAO().get(strQuery, params);
		if (livroEncontrado != null) {
			result.use(json()).from(livroEncontrado, "livro").serialize();
		}
	}
	
	@Get("/livros/{livroTitulo}")
	public void pesquisaLivros(String livroTitulo) {
		String strQuery = "FROM Livro l WHERE l.titulo like :titulo";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("titulo", "%"+ livroTitulo + "%");
		System.out.println("\n titulo digitado = " + livroTitulo);
		List<Livro> livrosEncontrados = daoFactory.getLivroDAO().list(strQuery, params);
		if (livrosEncontrados != null) {
			result.use(json()).from(livrosEncontrados, "livros").serialize();
		}
	}
	
}
