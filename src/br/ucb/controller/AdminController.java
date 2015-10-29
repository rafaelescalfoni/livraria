package br.ucb.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ucb.dao.DAOFactory;
import br.ucb.model.Editora;
import br.ucb.model.Genero;
import br.ucb.model.Livro;
import br.ucb.utils.anotacoes.Admin;
import br.ucb.utils.componentes.UserSession;

@Resource
public class AdminController {
	private final Result result;
	private final DAOFactory daoFactory;
	private final UserSession userSession;
	
	public AdminController(Result result, DAOFactory daoFactory, UserSession userSession) {
		this.result = result;
		this.daoFactory = daoFactory;
		this.userSession = userSession;
	}

	//metodos de chamadas de página
	@Admin	@Get @Path("/admin/livros")
	public void livrosCrud(){
		result.include("livroList", daoFactory.getLivroDAO().list());
		result.include("generoList", daoFactory.getGeneroDAO().list());
		result.include("editoraList", daoFactory.getEditoraDAO().list());
	}
	
	@Admin	@Get @Path("/admin/livros/{livroId}/update")
	public void formLivro(Long livroId){
		result.include("livro", daoFactory.getLivroDAO().get(livroId));
		result.include("generoList", daoFactory.getGeneroDAO().list());
		result.include("editoraList", daoFactory.getEditoraDAO().list());
	}
	
	@Admin	@Get @Path("/admin/generos/{generoId}/update")
	public void formGenero(Long generoId){
		result.include("genero", daoFactory.getGeneroDAO().get(generoId));
	}
	
	@Get @Path("/admin/editoras/{editoraId}/update")
	public void formEditora(Long editoraId){
		result.include("editora", daoFactory.getEditoraDAO().get(editoraId));
	}
	
	@Get @Path("/admin/livros/{livroId}/delete")
	public void livrosCrud(Long livroId){
		
	}
	
	//metodos CRUD
	@Post @Path("/livros")
	public void add(Livro livro) {
		daoFactory.getLivroDAO().add(livro);
		result.redirectTo(this).livrosCrud();
	}
	
	@Put @Path("/livros/{livro.id}")
	public void update(Livro livro) {
		daoFactory.getLivroDAO().update(livro);
		result.redirectTo(this).livrosCrud();
	}
	
	@Post @Path("/generos")
	public void add(Genero genero) {
		daoFactory.getGeneroDAO().add(genero);
		result.redirectTo(this).livrosCrud();
	}
	
	@Put @Path("/generos/{genero.id}")
	public void update(Genero genero) {
		daoFactory.getGeneroDAO().update(genero);
		result.redirectTo(this).livrosCrud();
	}
	
	@Post @Path("/editoras")
	public void add(Editora editora) {
		daoFactory.getEditoraDAO().add(editora);
		result.redirectTo(this).livrosCrud();
	}
	
	@Put @Path("/editoras/{editora.id}")
	public void update(Editora editora) {
		daoFactory.getEditoraDAO().update(editora);
		result.redirectTo(this).livrosCrud();
	}
}
