<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hospital</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

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




<h1 class="text-center">LISTA</h1>
		<table class="table table-hover table-striped table-bordered">
			<thead>
				<tr>
					<th>NOME</th>
					<th>NOMEMAE</th>
					<th>CPF</th>
					<th>DATA</th>
					<th>TIPO</th>
					<th>AÇÂO</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pacientes }" var="paciente">
					<tr>
						<td>${paciente.nome }</td>
						<td>${paciente.mae }</td>
						<td>${paciente.cpf }</td>
						<td>${paciente.dt_nascimento }</td>
						<td>${paciente.tipo }</td>
						<td>
                        <a href="/edit?id=<c:out value='${book.id}' />">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${book.id}' />">Deletar</a>                     
                    </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>