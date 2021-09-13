<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulário do Paciente</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		$("input[id*='dt_nascimento']").mask('99/99/9999');
		$("input[id*='cpf']").mask("999.999.999-99");

	});

	function TestarCPF(cpf, el) {
		var $me = $(el);
		cpf = cpf.replace(/[^\d]+/g, '');
		if (cpf == '')
			return false;
		// Elimina CPFs invalidos conhecidos    
		if (cpf.length != 11 || cpf == "00000000000" || cpf == "11111111111"
				|| cpf == "22222222222" || cpf == "33333333333"
				|| cpf == "44444444444" || cpf == "55555555555"
				|| cpf == "66666666666" || cpf == "77777777777"
				|| cpf == "88888888888" || cpf == "99999999999") {
			alert("CPF Inválido!");
			$me.val("");
			$me.focus();
			return false;
		}
		// Valida 1o digito 
		add = 0;
		for (i = 0; i < 9; i++)
			add += parseInt(cpf.charAt(i)) * (10 - i);
		rev = 11 - (add % 11);
		if (rev == 10 || rev == 11)
			rev = 0;
		if (rev != parseInt(cpf.charAt(9))) {
			alert("CPF Inválido!");

			$me.val("");
			$me.focus();
			return false;
		}
		// Valida 2o digito 
		add = 0;
		for (i = 0; i < 10; i++)
			add += parseInt(cpf.charAt(i)) * (11 - i);
		rev = 11 - (add % 11);
		if (rev == 10 || rev == 11)
			rev = 0;
		if (rev != parseInt(cpf.charAt(10))) {
			alert("CPF Inválido!");
			$me.val("");
			$me.focus();
			return false;
		}
		return true;
	}
</script>
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
					<label>CPF: </label> <input type="text" id="cpf"
						value="<c:out value='${paciente.cpf}' />" class="form-control"
						onblur="TestarCPF(this.value,this)" name="cpf">
				</fieldset>
				<fieldset class="form-group">
					<label>Data de Nascimento: </label>


					<fmt:parseDate value="${paciente.dt_nascimento}"
						pattern="yyyy-MM-dd" var="formatada" type="date" />

					<fmt:formatDate value="${formatada}" pattern="dd/MM/yyyy"
						type="date" var="formattedDate" />
					<input id="dt_nascimento" name="dt_nascimento"
						data-format="dd/MM/yyyy" type="text" class="form-control"
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
