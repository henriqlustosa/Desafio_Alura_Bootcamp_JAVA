<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulário do Paciente</title>
</head>
<body>
 <div style="text-align:center">
        <h1>Gerenciamento do Paciente</h1>
        <h2>
            <a href="/novo">Adicionar novo Paciente</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/listar">Listar todos os Pacientes</a>
             
        </h2>
    </div>
    <form method="post" action="<c:url value="/pacientes"/>">
			<div class="form-group">
				<label>NOME</label>
				<input name="nome" class="form-control">
			</div>
			
			
			<div class="form-group">
				<label>NOMEMAE</label>
				<input name="mae" class="form-control">
			</div>
			
			<div class="form-group">
				<label>CPF</label>
				<input name="cpf" class="form-control">
			</div>
			
			<div class="form-group">
				<label>DATA DE NASCIMENTO(dd/mm/yyyy)</label>
				<input name="dt_nascimento" class="form-control">
			</div>
			
			<div class="form-group">
				<label>TIPO(MUNICIPIE OU FUNCIONARIO)</label>
				<input name="tipo" class="form-control">
			</div>
			
			<input type="submit" value="Salvar" class="btn btn-primary mt-1">
		</form>
</body>
</html>