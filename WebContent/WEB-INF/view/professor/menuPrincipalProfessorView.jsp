<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<title>SCA - Menu Principal</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/vendor/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	
</head>
<body class="menu-principal">
	<div class="container">
		<div class="row">
			<h1 class="text-center">Menu principal</h1>
	
			<c:if test="${requestScope.error != null}">
				<span class="label label-danger">${requestScope.error}</span>
			</c:if>
		
			<c:if test="${requestScope.info != null}">
				<span class="label label-default">${requestScope.info}</span>
			</c:if>
		</div>
		<hr/>
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<ul class="nav nav-pills nav-stacked text-center">
					<li><a class="btn-default"
						href="${pageContext.request.contextPath}/professor/homeInclusao">
							Inclusão de Disciplina </a></li>
					<li class="active"><a
						href="${pageContext.request.contextPath}/logout">Sair do
							sistema</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
