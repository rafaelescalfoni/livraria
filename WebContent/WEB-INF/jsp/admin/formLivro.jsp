<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value="/livros/${livro.id}"/>" method="post">
		<fieldset>
			<legend>Edição de Livros</legend>
			<label for="livro.autor">Autor</label>
			<input type="text" name="livro.autor" 
					value="${livro.autor}"/>
			
			<label for="livro.isbn">ISBN</label>
			<input type="text" name="livro.isbn"
					value="${livro.isbn}" />
			
			<label for="livro.titulo">Título</label>
			<input type="text" name="livro.titulo"
					value="${livro.titulo}" />
			
			<label for="livro.titulo">Resumo</label>
			<textarea name="livro.resumo" >${livro.resumo}</textarea>
			
			<label for="livro.preco">Preço</label>
			<input type="text" name="livro.preco" 
					value="${livro.preco}" />
			
			<label for="livro.genero.id">Gênero</label>
			<select name="livro.genero.id" value="${livro.genero.id}">
				<c:forEach items="${generoList}" var="genero">
				<option value="${genero.id}">${genero.nome}</option>
				</c:forEach>
			</select>
			
			<label for="livro.editora.id">Editora</label>
			<select name="livro.editora.id">
				<c:forEach items="${editoraList}" var="editora">
				<option value="${editora.id}">${editora.nome}</option>
				</c:forEach>
			</select>
			<input type="hidden" name="_method" value="PUT" />
			<input type="submit" value="Editar"/>
		</fieldset>
		
	</form>
</body>
</html>