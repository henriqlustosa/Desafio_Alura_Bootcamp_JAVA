<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulário do Paciente</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
</head>
<body>
	<div style="text-align: center">
		<h1>Gerenciamento do Paciente</h1>
		<h2>
			<a href="./novo">Adicionar novo Paciente</a> &nbsp;&nbsp;&nbsp; <a
				href="./pacientes">Listar todos os Pacientes</a>

		</h2>
	</div>

	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${paciente != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${paciente == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${paciente != null}">
                                    Editar Paciente
                                </c:if>
						<c:if test="${paciente == null}">
                                    Adicionar um novo Paciente
                                </c:if>
					</h2>
				</caption>

				<c:if test="${paciente != null}">
					<input type="hidden" name="id"
						value="<c:out value='${paciente.id}' />" />
				</c:if>
				<!--
                                <fieldset class="form-group">
                            <label>ID</label> <input type="text" value="<c:out value='${paciente.id}' />" class="form-control" name="id" required="required">
                        </fieldset>-->

				<fieldset class="form-group">
					<label>Nome: </label> <input type="text"
						value="<c:out value='${paciente.nome}' />" class="form-control"
						name="nome" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label> Nome da Mãe:</label> <input type="text"
						value="<c:out value='${paciente.mae}' />" class="form-control"
						name="mae">
				</fieldset>

				<fieldset class="form-group">
					<label>CPF: </label> <input type="text"
						value="<c:out value='${paciente.cpf}' />" class="form-control"
						name="cpf">
				</fieldset>
				<fieldset class="form-group">
					<label>Data de Nascimento: </label>


					<fmt:parseDate value="${paciente.dt_nascimento}"
						pattern="yyyy-MM-dd" var="formatada" type="date" />

					<fmt:formatDate value="${formatada}" pattern="dd/MM/yyyy"
						type="date" var="formattedDate" />
					<input name="dt_nascimento" data-format="dd/MM/yyyy" type="text"
						value="${formattedDate}" />


				</fieldset>
				<fieldset class="form-group">
					<label>Tipo: </label> <input type="text"
						value="<c:out value='${paciente.tipo}' />" class="form-control"
						name="tipo">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				

			</div>
		</div>
	</div>
</body>
</html>
