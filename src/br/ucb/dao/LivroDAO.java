package br.ucb.dao;

import javax.persistence.EntityManager;

import br.ucb.model.Livro;

public class LivroDAO extends DAOGenerico<Livro> {

	public LivroDAO(EntityManager em, Class<Livro> classe) {
		super(em, classe);
	}

}
