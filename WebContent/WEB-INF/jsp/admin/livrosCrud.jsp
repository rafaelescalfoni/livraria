<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="<c:url value="/livros"/>" method="post">
		<fieldset>
			<legend>Cadastro de Livros</legend>
			<label for="livro.autor">Autor</label>
			<input type="text" name="livro.autor" />
			
			<label for="livro.isbn">ISBN</label>
			<input type="text" name="livro.isbn" />
			
			<label for="livro.titulo">Título</label>
			<input type="text" name="livro.titulo" />
			
			<label for="livro.titulo">Título</label>
			<textarea name="livro.resumo" ></textarea>
			
			<label for="livro.preco">Preço</label>
			<input type="text" name="livro.preco" />
			
			<label for="livro.genero.id">Gênero</label>
			<select name="livro.genero.id">
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
			
			<input type="submit" value="Adicionar"/>
		</fieldset>
		
	</form>
	<table>
		<tr>
			<th>ISBN</th>
			<th>Título</th>
			<th>Gênero</th>
			<th>Editora</th>
			<th>Preço</th>
			<th colspan="2"></th>
		</tr>
		<c:forEach items="${livroList}" var="livro">
		<tr>
			<td>${livro.isbn}</td>
			<td>${livro.titulo}</td>
			<td>${livro.genero.nome}</td>
			<td>${livro.editora.nome}</td>
			<td>${livro.preco}</td>
			<td><a href="<c:url value="/admin/livros/${livro.id}/update"/>" >Editar</a>
			<td><a href="<c:url value="/admin/livros/${livro.id}/delete"/>" >Excluir</a>
		</tr>
		</c:forEach>
	</table>
	
	<form action="<c:url value="/generos"/>" method="post">
		<fieldset>
			<legend>Cadastro de Gêneros</legend>
			<label>Nome</label><input type="text" name="genero.nome" />
			<input type="submit" value="Adicionar"/>
		</fieldset>
	</form>
	
	<table>
		<tr>
			<th>Nome</th>
			<th colspan="2"></th>
		</tr>
		<c:forEach items="${generoList}" var="genero">
		<tr>
			<td>${genero.nome}</td>
			<td><a href="<c:url value="/admin/generos/${genero.id}/update"/>" >Editar</a>
			<td><a href="<c:url value="/admin/generos/${genero.id}/delete"/>" >Excluir</a>
		</tr>
		</c:forEach>
	</table>
	
	<form action="<c:url value="/editoras"/>" method="post">
		<fieldset>
			<legend>Cadastro de Editoras</legend>
			<label>Nome</label><input type="text" name="editora.nome" /> <br/>
			<label>Endereço</label><input type="text" name="editora.endereco" /><br/>
			<label>Cidade</label><input type="text" name="editora.cidade" /><br/>
			<input type="submit" value="Adicionar" />
		</fieldset>
	</form>
	
	<table>
		<tr>
			<th>Nome</th>
			<th>Endereço</th>
			<th>Cidade</th>
			<th colspan="2"></th>
		</tr>
		<c:forEach items="${editoraList}" var="editora">
		<tr>
			<td>${editora.nome}</td>
			<td>${editora.endereco}</td>
			<td>${editora.cidade}</td>
			<td><a href="<c:url value="/admin/editoras/${editora.id}/update"/>" >Editar</a>
			<td><a href="<c:url value="/admin/editoras/${editora.id}/delete"/>" >Excluir</a>
		</tr>
		</c:forEach>
	</table>
</body>
</html>