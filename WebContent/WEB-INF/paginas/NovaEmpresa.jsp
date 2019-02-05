
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Nova Empresa</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<script src="../recursos/bootstrap-4.1.2-dist/js/popper.min.js"></script>

<script src="../recursos/bootstrap-4.1.2-dist/js/jquery.min.js"></script>

<link rel="stylesheet"
	href="../recursos/bootstrap-4.1.2-dist/css/bootstrap.min.css">

</head>
<body>
	<nav class="navbar navbar-expand-sm bg-success navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/">Produtos</a></li>
			<li class="nav-item"><a class="nav-link" href="Empresas">Empresas</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/Vendedor/Vendedores">Vendedores</a></li>
		</ul>
	</nav>


	<div class="container">
		<h3>Nova Empresa</h3>


		<form:form action="CadastrarEmpresa"  modelAttribute = "empresa"  method = "POST">
		
			<div class = "form-grouo">
				<form:input class="form-control" path="id" readonly="true" id="id" type="hidden"/>
			
			</div>
		
		
			<div class="form-group">
				<label for="nome">Nome da empresa:</label> 
				<form:input type="text" class="form-control" id="nome"  path = "nome"/>
			</div>
			<div class="form-group">
				<label for="preco">Endereço</label> 
				<form:input type="text" class="form-control" id="endereco" path = "endereco"/>
			</div>
			
			<div class="form-group">
				<label for="preco">Cnpj</label> 
				<form:input type="text" class="form-control" id="cnpj" path = "cnpj"/>
			</div>			
			
			<button type=submit class="btn btn-primary">Ok</button>
		</form:form>

	</div>





</body>
</html>
