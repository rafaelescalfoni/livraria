package br.ucb.dao;

import javax.persistence.EntityManager;

import br.ucb.model.Usuario;

public class UsuarioDAO extends DAOGenerico<Usuario> {

	public UsuarioDAO(EntityManager em, Class<Usuario> classe) {
		super(em, classe);
	}

}
