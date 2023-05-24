<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Tarefa</title>
</head>
<body>
    <h1>Cadastro de Tarefa</h1>
    <form action="cadastra-tarefa" method="post">
        <label for="titulo">Título:</label>
        <input type="text" id="titulo" name="titulo" required><br>
        <label for="descricao">Descrição:</label>
        <textarea id="descricao" name="descricao" rows="5" required></textarea><br>
        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>
