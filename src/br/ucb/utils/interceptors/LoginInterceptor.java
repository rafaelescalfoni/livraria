package br.ucb.utils.interceptors;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.view.Results;
import br.ucb.controller.HomeController;
import br.ucb.utils.anotacoes.Admin;
import br.ucb.utils.anotacoes.Public;
import br.ucb.utils.componentes.UserSession;


@Intercepts // declara classe do tipo interceptor
public class LoginInterceptor implements Interceptor {
	private Result result;
	private UserSession userSession;

	public LoginInterceptor(Result result, UserSession userSession) {
		this.result = result;
		this.userSession = userSession;
	}

	/**
	 * Decide se vai ou nao interceptar a requisicao atual.
	 *  
	 * @param method: representa qual eh o metodo java que sera executado na requisicao, o  
	 *         metodo do seu controller. Com esse objeto voce tem acesso a classe do   
	 *         controller e ao metodo java dele (java.reflect.Method) para poder, por 
	 *         exemplo, ver qual eh o nome do metodo, ou se ele tem alguma anotacao
	 */
	public boolean accepts(ResourceMethod method) {
		/*
		if(userSession.isLogged()) {
			return true;
		} else {
			return false;
		}
		*/
		// se o usuario estiver logado e o metodo nao for anotado com @Public
		
		if (userSession.isLogged() && !(method.getMethod().isAnnotationPresent(Public.class))) {
			return true;
		}
		if (method.getResource().getType().isAnnotationPresent(Public.class)) {
			return true;
		}
		
		return false; 
					
		
	}

	/**
	 * Intercepta a requisi��o. 
	 * @param stack: possibilita continuar a execucao normal da requisicao e, portanto, executar de 
	 *					fato a logica de negocios. 
	 * @param method: representa qual eh o metodo java que sera executado na requisicao
	 * @param resourceInstance: eh o controller instanciado.
	 */
	public void intercept(InterceptorStack pilhaDeExecucao, 
							ResourceMethod metodo, 
							Object classeControladora)  throws InterceptionException {
		System.out.println("\nLoginInterceptor inicio do metodo intercept\n");
		if (userSession == null) { // se objeto userSession não estiver criado, manda para a página de login...
			System.out.println("\n\nLoginInterceptor intercept - nao tem usuario na sessao!!!");
			result.redirectTo(HomeController.class).login();
		} else {
			if (podeAcessar(metodo)) {
				pilhaDeExecucao.next(metodo, classeControladora);
			} else {
				userSession.logout(); //expulsa o engracadinho da sessao sessao
				result.redirectTo(HomeController.class).login(); //joga para a tela de login
			}
		}
	
		
		
	}
	
	private boolean podeAcessar(ResourceMethod method) {
		if(method.containsAnnotation(Public.class)){  // 1o caso - metodo @Public
			System.out.println("\nLoginInterceptor: caso 1 @Public");
			return true; 
		}
		if ((userSession.isLogged() && !method.containsAnnotation(Admin.class))) {  // 2o caso - usuario logado e metodo nao @Admin
			System.out.println("\nLoginInterceptor: caso 2 usuario na sessao e metodo nao @Admin");
			return true;
		}
		if (userSession.getUsuario().isAdmin() && method.containsAnnotation(Admin.class)){ // 3o caso - metodo admin e usuario admin
			System.out.println("\nLoginInterceptor: caso 3 usuario na sessao eh admin e metodo @Admin");
			return true;
		}
		
		return false;
	}


}
