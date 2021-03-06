<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Produtos</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<script src="recursos/bootstrap-4.1.2-dist/js/popper.min.js"></script>

<script src="recursos/bootstrap-4.1.2-dist/js/jquery.min.js"></script>

<link rel="stylesheet"
	href="recursos/bootstrap-4.1.2-dist/css/bootstrap.min.css">

</head>
<body>
	<nav class="navbar navbar-expand-sm bg-success navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/">Produtos</a></li>
			<li class="nav-item"><a class="nav-link" href="Empresa/Empresas">Empresas</a></li>
			<li class="nav-item"><a class="nav-link" href="Vendedor/Vendedores">Vendedores</a></li>

		</ul>
	</nav>


<div class = "container">
	<h2>Produtos</h2>

	<div class="mt-2 col-md-12" >


	</div>

		<a href="Produto/NovoProduto" class="btn btn-success" role="button">Novo
			Produto</a>


		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Pre�o</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="produto" items="${produtos}">
					<tr>
						<td>${produto.id}</td>
						<td>${produto.nome}</td>
						<td>${produto.preco}</td>
						<td style="text-align: center;"><a
							href="Produto/EditarProduto?id=${produto.id}" class="btn btn-info"
							role="button">Editar</a> 
							<a href="Produto/ApagarProduto?id=${produto.id }" class="btn btn-danger"
							role="buttorn">Apagar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

</div>

	







</body>
</html>
