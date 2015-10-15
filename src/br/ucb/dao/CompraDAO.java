package br.ucb.dao;

import javax.persistence.EntityManager;

import br.ucb.model.Compra;

public class CompraDAO extends DAOGenerico<Compra> {

	public CompraDAO(EntityManager em, Class<Compra> classe) {
		super(em, classe);
	}

}
