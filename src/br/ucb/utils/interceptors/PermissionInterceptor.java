package br.ucb.utils.interceptors;

import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.view.Results;
import br.ucb.utils.anotacoes.Admin;
import br.ucb.utils.anotacoes.Public;
import br.ucb.utils.componentes.UserSession;

/**
 * Esse interceptor entra em acao logo apos o LoginInterceptor
 * (after=LoginInterceptor.class)
 * 
 * Ele ira verificar se o usuario logado tem permissao para acessar o metodo
 * 
 * @author rafaelescalfoni
 *
 */
//@Intercepts(after = LoginInterceptor.class)
public class PermissionInterceptor{// implements Interceptor {

	private final Result result;
	private final UserSession userSession;

	public PermissionInterceptor(Result result, UserSession userSession) {
		this.result = result;
		this.userSession = userSession;
	}

	public boolean accepts(ResourceMethod method) {
		return method.getMethod().isAnnotationPresent(Public.class);

	}

	public void intercept(InterceptorStack stack, 
							ResourceMethod method,
							Object controller) {
		if (podeAcessar(method)) {
			stack.next(method, controller);
		} else {
			result.use(Results.http()).sendError(401, "Acesso negado!");
		}
	}

	private boolean podeAcessar(ResourceMethod method) {
		if(method.containsAnnotation(Public.class)){  // 1o caso - metodo @Public
			System.out.println("\nPermission Interceptor:\t1 caso");
			return true; 
		}
		if ((userSession.isLogged() && !method.containsAnnotation(Admin.class))) {  // 2o caso - usuario logado e metodo nao @Admin
			System.out.println("\nPermission Interceptor:\t2 caso");
			return true;
		}
		if (userSession.getUsuario().isAdmin() && method.containsAnnotation(Admin.class)){ // 3o caso - metodo admin e usuario admin
			System.out.println("\nPermission Interceptor:\t3 caso");
			return true;
		}
		
		return false;
	}

}
