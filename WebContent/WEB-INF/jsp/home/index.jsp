<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Livraria | Início</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<c:url value="/bootstrap/css/bootstrap.css"/> " />
<link rel="stylesheet"
	href="<c:url value="/bootstrap/css/bootstrap-responsive.css"/> " />
<script src="<c:url value="/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>

</head>
<body>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Livraria</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<c:if test="${userSession.usuario.perfil eq 'Administrador' }">
						<li><a href="<c:url value="/admin/livros"/>">Administração</a></li>
					</c:if>
				</ul>
			</div>

			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-haspopup="true" aria-expanded="false">${userSession.usuario.nome}
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="#">Perfil</a></li>
						<li><a href="#">Histórico de Compras</a></li>
						<li><a href="#">Carrinho de Compras</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Sair</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<table>
				<c:forEach items="${livroList}" var="livro">
					<tr>
						<td><a href="<c:url value="/livros/${livro.id}"/>">${livro.titulo}</a>
						</td>
						<td><a href="<c:url value="#" />">Comprar</a></td>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>