package br.ucb.controller;

import java.util.HashMap;
import java.util.Map;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.ucb.dao.DAOFactory;
import br.ucb.model.Usuario;
import br.ucb.utils.anotacoes.Public;
import br.ucb.utils.componentes.PerfilEnum;
import br.ucb.utils.componentes.UserSession;

@Resource
public class HomeController {
	private final Result result;
	private final DAOFactory daoFactory;
	private final UserSession userSession;
	
	public HomeController(Result result, DAOFactory daoFactory, UserSession userSession) {
		this.result = result;
		this.daoFactory = daoFactory;
		this.userSession = userSession;
	}
	
	//requisicoes recebidas pelo controller
	@Public
	@Get("/")
	public void login(){
	}
	
	@Public
	public void login(String msg){
		result.include("msg", msg);
	}
	
	@Get @Path("/index")
	public void index() {
		result.include("livroList", daoFactory.getLivroDAO().list());
	}
	
	//processamento de requisicoes
	@Post @Path("/autenticar")
	public void autenticar(Usuario usuario){
		String strQuery = "SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", usuario.getEmail());
		params.put("senha", usuario.getSenha());
		
		usuario = daoFactory.getUsuarioDAO().get(strQuery, params);
		
		if(usuario != null) {
			userSession.setUsuario(usuario);
			result.redirectTo(this).index();
		} else {
			result.redirectTo(this).login("Usuário inválido");
		}
	}
	
}
