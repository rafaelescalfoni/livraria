<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Livro</title>
</head>
<body>
<h1>Livro - detalhes</h1>
<p>
	<a href="<c:url value="/index" />">Voltar</a>
</p>
<p>
	Título: <strong>${livro.titulo}</strong>
</p>
<p>
	ISBN: <strong>${livro.isbn}</strong>
</p>
<p>	
	Descrição: <strong>${livro.resumo}</strong>
</p>
<p>
	Autor: <strong>${livro.autor}</strong>
</p>
<p>
	Gênero: <strong>${livro.genero.nome}</strong>
</p>
<p>	
	Editora: <strong>${livro.editora.nome}</strong>
</p>
</body>
</html>