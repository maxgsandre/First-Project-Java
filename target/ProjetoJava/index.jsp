<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Gerenciador de Tarefas</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
	<style>
		.container {
			margin-top: 20px;
		}
		label {
			font-weight: bold;
		}
		input[type=text], select {
			width: 100%;
			padding: 12px 20px;
			margin: 8px 0;
			display: inline-block;
			border: 1px solid #ccc;
			border-radius: 4px;
			box-sizing: border-box;
		}
		input[type=submit] {
			background-color: #4CAF50;
			color: white;
			padding: 14px 20px;
			margin: 8px 0;
			border: none;
			border-radius: 4px;
			cursor: pointer;
		}
		input[type=submit]:hover {
			background-color: #45a049;
		}
	</style>
</head>
<body>
	<div class="container">
		<h1>Cadastro de Tarefas</h1>
		<form action="cadastra-tarefa" method="post">
			<div class="form-group">
				<label for="titulo">Título:</label>
				<input type="text" class="form-control" id="titulo" name="titulo" required>
			</div>
			<div class="form-group">
				<label for="descricao">Descrição:</label>
				<input type="text" class="form-control" id="descricao" name="descricao" required>
			</div>
			<div class="form-group">
				<label for="responsavel">Responsável:</label>
				<input type="text" class="form-control" id="responsavel" name="responsavel" required>
			</div>
			<div class="form-group">
				<label for="prioridade">Prioridade:</label>
				<select class="form-control" id="prioridade" name="prioridade" required>
					<option value="">Selecione</option>
					<option value="baixa">Baixa</option>
					<option value="media">Média</option>
					<option value="alta">Alta</option>
				</select>
			</div>
			<div class="form-group">
				<label for="deadline">Deadline:</label>
				<input type="date" class="form-control" id="deadline" name="deadline" required>
			</div>
			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>
