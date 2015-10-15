package br.ucb.dao;

import javax.persistence.EntityManager;

import br.ucb.model.Editora;

public class EditoraDAO extends DAOGenerico<Editora> {

	public EditoraDAO(EntityManager em, Class<Editora> classe) {
		super(em, classe);
	}

}
