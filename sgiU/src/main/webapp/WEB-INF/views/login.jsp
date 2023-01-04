<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/login" var="loginLink" />


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<%@ page isELIgnored="false"%>
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container-fluid" style="background:#002147;">
		<div class="row">
			<div class="col-md-12" style="padding: 20px 3px;">
				<img alt=""  width="238px" src="<c:url value="/resources/img/logo-blanco.png"/>">
			</div>

	    </div>
		
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
			
				<h1 class="text-center py-5">
					<spring:message code="label.titulo.aplicacion" />
				</h1>
				<form method="get" action="${loginLink}">
				  <div class="form-group">
				    <label for="usuario">Usuario</label>
				    <input name="usuario" type="text" class="form-control" id="usuario">
				 
				  </div>
				  <div class="form-group">
				    <label for="password">Password</label>
				    <input name="password" type="password" class="form-control" id="password">
				  </div>
				 
				  <button type="submit" class="btn btn-primary">Entrar</button>
				</form>
				
			</div>
			
		
		</div>
	</div>
	
	

</body>
</html>
