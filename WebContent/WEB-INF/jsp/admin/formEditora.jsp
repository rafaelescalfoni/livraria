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
	<form action="<c:url value="/editoras/${editora.id}"/>" method="post">
		<fieldset>
			<legend>Edição de Editoras</legend>
			<label>Nome</label>
			<input type="text" name="editora.nome"
					value="${editora.nome}" /> <br/>
			<label>Endereço</label>
			<input type="text" name="editora.endereco"
					value="${editora.endereco}" /><br/>
			<label>Cidade</label>
			<input type="text" name="editora.cidade" 
					value="${editora.cidade}" /><br/>
			<input type="hidden" name="_method" value="PUT" />
			<input type="submit" value="Adicionar" />
		</fieldset>
	</form>
</body>
</html>