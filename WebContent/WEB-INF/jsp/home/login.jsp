<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Livraria</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<c:url value="/bootstrap/css/bootstrap.css"/> " />
<link rel="stylesheet"
	href="<c:url value="/bootstrap/css/bootstrap-responsive.css"/> " />
<script src="<c:url value="/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
</head>
<body>
	<div class="container-fluid"">
		<div class="col-md-4 col-sm-4 col-xs-4">
			<div class="panel panel-primary">
				<div class="panel-body">
					<div class="panel-heading">
						<h3 class="panel-title">Autenticação</h3>
					</div>
					
					<c:if test="${msg ne null}">
						<div class="alert alert-danger" role="alert">
							<span class="glyphicon glyphicon-exclamation-sign"
								aria-hidden="true"></span> <span class="sr-only">Erro:</span>
							${msg}
						</div>
					</c:if>
					
					<form action="<c:url value="/autenticar"/>" class="form-horizontal"
						method="post">

						<div class="form-group">
							<label for="login">Email</label> <input type="text" id="login"
								name="usuario.email" placeholder="Email" class="form-control" />
						</div>
						<div class="form-group">
							<label for="senha">Senha</label> <input type="password"
								id="senha" name="usuario.senha" placeholder="Senha"
								class="form-control" />
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-primary">Entrar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>