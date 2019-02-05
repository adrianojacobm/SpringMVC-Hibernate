
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Novo Vendedor</title>
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
			<li class="nav-item"><a class="nav-link" href="#">Empresas</a></li>
			<li class="nav-item"><a class="nav-link" href="Vendedores">Vendedores</a></li>

		</ul>
	</nav>


	<div class="container">
		<h3>Novo Vendedor</h3>


		<form:form action="CadastrarVendedor"  modelAttribute = "vendedor"  method = "POST">
		
			<div class = "form-grouo">
				<form:input class="form-control" path="id" readonly="true" id="id" type="hidden"/>
			
			</div>
		
		
			<div class="form-group">
				<label for="nome">Nome do vendedor:</label> 
				<form:input type="text" class="form-control" id="nome"  path = "nome"/>
			</div>
			
			
			
			<div class="form-group">
			
			  <label for="idempresa">Empresa</label>
			  <select class="form-control" id="idempresa" name = "idempresa">

			  <c:forEach var="empresa" items="${empresas}">
			  
			  	<c:choose>
			  				  	
			  		<c:when test="${vendedor.empresa == null && empresa.id == 0}">
				       <option value="0" selected>Nenhuma Empresa</option>
				    </c:when>
				    
			  	    <c:when test="${empresa.id == vendedor.empresa.id}">
				        <option value="${empresa.id}"selected> ${empresa.nome} </option>
				    </c:when>
			  
			  	    <c:when test="${empresa.id != vendedor.empresa.id}">
				       <option value="${empresa.id == 0 ? '0': empresa.id}" > ${empresa.id == 0 ? 'Nenhuma empresa': empresa.nome} </option>
				    </c:when>
				    				    
			  	</c:choose>   
			  </c:forEach>
			  </select>
			  
			</div>
			
			<button type=submit class="btn btn-primary">Ok</button>
		</form:form>

	</div>





</body>
</html>
