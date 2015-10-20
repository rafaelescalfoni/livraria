package br.ucb.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ucb.dao.DAOFactory;
import br.ucb.model.Livro;
import br.ucb.utils.componentes.UserSession;

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
	
	@Get("/livro/{livroId}")
	public void formulario(Long livroId) {
		Livro livro = daoFactory.getLivroDAO().get(livroId); //pesquisar o livro no bd
		result.include("livro", livro); //botar o livro a disposiçào da jsp
	}
}
