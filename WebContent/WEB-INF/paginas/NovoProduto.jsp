
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Novo Produto</title>
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
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/Empresa/Empresas">Empresas</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/Vendedor/Vendedores">Vendedores</a></li>
		</ul>
	</nav>


	<div class="container">
		<h3>Novo Produto</h3>


		<form:form action="CadastrarProduto"  modelAttribute = "produto"  method = "POST">
		
			<div class = "form-grouo">
				<form:input class="form-control" path="id" readonly="true" id="id" type="hidden"/>
			
			</div>
		
		
			<div class="form-group">
				<label for="nome">Nome do produto:</label> 
				<form:input type="text" class="form-control" id="nome"  path = "nome"/>
			</div>
			<div class="form-group">
				<label for="preco">Preço</label> 
				<form:input type="text" class="form-control" id="preco" path = "preco"/>
			</div>
			
			<div class="form-group">
				<button type=submit class="btn btn-primary">Ok</button>
			</div>
			
			<div class = "form-group">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Empresa Id</th>
							<th>Nome</th>
							<th>Cnpj</th>
							<th>Endereço</th>
							<th></th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="empresa" items="${empresas}">
							<tr>
								<td>${empresa.id}</td>
								<td>${empresa.nome}</td>
								<td>${empresa.cnpj}</td>
								<td>${empresa.endereco}</td>
								<td style="text-align: center;">
									<c:choose>
										<c:when test="${produto.VerificaEmpresa(empresa.id)}">
											<input type="checkbox" name="empresasid" id="empresaid${empresa.id}"  value="${empresa.id}" checked  disabled="disabled">
										</c:when>    
									    <c:otherwise>
											<input type="checkbox" name="empresasid" id="empresaid${empresa.id}"  value="${empresa.id}">
									    </c:otherwise>
									</c:choose>
								</td>							
							</tr>
						</c:forEach>
					</tbody>
				</table>			
			</div>
			
		</form:form>

	</div>
	
	





</body>
</html>
