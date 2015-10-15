package br.ucb.dao;

import javax.persistence.EntityManager;

import br.ucb.model.Genero;

public class GeneroDAO extends DAOGenerico<Genero> {

	public GeneroDAO(EntityManager em, Class<Genero> classe) {
		super(em, classe);
	}

}
