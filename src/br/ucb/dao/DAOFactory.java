package br.ucb.dao;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;

import br.ucb.model.Compra;
import br.ucb.model.Editora;
import br.ucb.model.Genero;
import br.ucb.model.Livro;
import br.ucb.model.Usuario;


@Component
public class DAOFactory {

	private EntityManager em;

	public DAOFactory(EntityManager em) {
		this.em = em;
	}

	public CompraDAO getCompraDAO() {
		return new CompraDAO(this.em, Compra.class);
	}
	
	public EditoraDAO getEditoraDAO() {
		return new EditoraDAO(this.em, Editora.class);
	}

	public GeneroDAO getGeneroDAO() {
		return new GeneroDAO(this.em, Genero.class);
	}
	
	public LivroDAO getLivroDAO() {
		return new LivroDAO(this.em, Livro.class);
	}
	
	public UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAO(this.em, Usuario.class);
	}
	
}
