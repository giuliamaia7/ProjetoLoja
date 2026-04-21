<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.loja.classes.Produto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Produto</title>
</head>
<body>
	<h2>Editar Produto</h2>
	<form action="<%= request.getContextPath() %>/EditaProduto" method="post">
		<input type="hidden" name="id" value="${idAtributo}">
		
		<label>Nome do Produto:</label>
		<input type="text" name="nome" value="${produtoAtributo.nome}">
		<br>
		
		<label>Categoria:</label>
		<select name="categoria">
			<option value="1" ${produtoAtributo.categoria == 1 ? 'selected' : ''}>Notebook</option>
			<option value="2" ${produtoAtributo.categoria == 2 ? 'selected' : ''}>Desktop</option>
			<option value="3" ${produtoAtributo.categoria == 3 ? 'selected' : ''}>Periféricos</option>
			<option value="4" ${produtoAtributo.categoria == 4 ? 'selected' : ''}>Componentes</option>
		</select>
		<br>
		
		<label>Preço:</label>
		<input type="text" name="preco" value="${produtoAtributo.preco}">
		<br>
		
		<label>Quantidade:</label>
		<input type="number" name="quantidade" value="${produtoAtributo.quantidade}">
		<br>
		
		<button type="submit">Atualizar</button>
		<a href="listagem.jsp">Cancelar</a>
	</form>
</body>
</html>