<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/personas/listar" var="personasLink" />
<spring:url value="/pagoCursos/listar" var="ordenPagoCursosLink" />
<spring:url value="/cursos/listar" var="cursosLink" />
<spring:url value="/facturas/listar" var="facturasLink" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.titulo.personas" /></title>
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
				
				<p>Somos una empresa mexicana dedicada a la enseñanza de idiomas 
				   de manera profesional basados en altos estándares pedagógicos y 
				   asimismo, apegados a los lineamientos internacionales tales como 
				   el Marco Común Europeo de Referencia, el Instituto Cervantes, 
				   l’Academie Française (la Academia Francesa), el Instituto Camões, entre otros.
				   
				   <br/>
				   El objetivo de este sistema es tener un control del mismo sistema y 
				   se pueda tener un mejor alcance del mismo.
				   </p>

			</div>
			
			<div class="col-md-12 pt-5">
					<a class="btn btn-outline-info my-3" href="${personasLink}" role="button">
						<spring:message code="label.titulo.personas" />
					</a>
					<br/>
							
					<a class="btn btn-outline-info my-3" href="${personasLink}" role="button">
						<spring:message code="label.titulo.maestros" />
					</a>
					<br/>
					<a class="btn btn-outline-info my-3" href="${personasLink}" role="button">
						<spring:message code="label.titulo.alumnos" />
					</a>
					<br/>
					
					<a class="btn btn-outline-info my-3" href="${facturasLink}" role="button">
						<spring:message code="label.titulo.facturas" />
					</a>
					<br/>
					
					<a class="btn btn-outline-info my-3" href="${cursosLink}" role="button">
						<spring:message code="label.titulo.cursos" />
					</a>
					<br/>
					
					<a class="btn btn-outline-info my-3" href="${ordenPagoCursosLink}" role="button">
						<spring:message code="label.titulo.ordenPagoCursos" />
					</a>

			</div>
		</div>
	</div>
	
	

</body>
</html>
