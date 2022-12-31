<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="label.titulo.personas" /></title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
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
		<div class="col-md-offset-2 col-md-7">
			<h3 class="text-center">
				<spring:message code="label.titulo.aplicacion" />
			</h3>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">
						<spring:message code="label.persona.agregar" />
					</div>
				</div>
				<div class="panel-body">

					<spring:url value="/persona/guardaPersona" var="urlGuardar" />
					<spring:url value="/persona/listar" var="urlRegresar" />
					<form:form action="" cssClass="form-horizontal"
						method="post" modelAttribute="persona">
						
						<form:hidden path="idPersona" />

						<div class="form-group">
							<form:label path="nombre" class="col-md-3 control-label">
								<spring:message code="label.persona.nombre" />
							</form:label>
							<div class="col-md-9">
								<form:input path="nombre" cssClass="form-control" />
							</div>
							<div class="col-md-9">
								<form:errors path="nombre" />
							</div>
						</div>
						<div class="form-group">
							<label for="edad" class="col-md-3 control-label"> <spring:message
									code="label.persona.edad" />
							</label>
							<div class="col-md-3">
								<form:input path="edad" cssClass="form-control" />
							</div>
							<div class="col-md-3">
								<form:errors path="edad" />
							</div>
						</div>
						<div class="form-group">
							<label for="edad" class="col-md-3 control-label"> <spring:message
									code="label.persona.correoElectronico" />
							</label>
							<div class="col-md-3">
								<form:input path="correoElectronico" cssClass="form-control" />
							</div>
							<div class="col-md-3">
								<form:errors path="correoElectronico" />
							</div>
						</div>
						<div class="form-group">
							<label for="edad" class="col-md-3 control-label"> <spring:message
									code="label.persona.rfc" />
							</label>
							<div class="col-md-3">
								<form:input path="rfc" cssClass="form-control" />
							</div>
							<div class="col-md-3">
								<form:errors path="rfc" />
							</div>
						</div>		
						<div class="form-group">
							<label for="idGenero" class="col-md-3 control-label">
								<spring:message code="label.persona.idGenero" />
							</label>
							<div class="col-md-6">
								<form:select path="idGenero" cssClass="form-control">
									<form:option value="">--SELECT--</form:option>
									   <form:option value="1" label="Femenino"/>  
        							   <form:option value="2" label="Masculino"/>  
								</form:select>
							</div>
							<div class="col-md-6">
								<form:errors path="idGenero" />
							</div>
						</div>
						<div class="form-group">
							<label for="idNacionalidad" class="col-md-3 control-label">
								<spring:message code="label.persona.idNacionalidad" />
							</label>
							<div class="col-md-6">
								<form:select path="idNacionalidad" cssClass="form-control">
									<form:option value="">--SELECT--</form:option>
									   <form:option value="1" label="Mexicano"/>  
        							   <form:option value="2" label="Extranjero"/> 
								</form:select>
							</div>
							<div class="col-md-6">
								<form:errors path="idNacionalidad" />
							</div>
						</div>					

						<div class="form-group">
							<label for="idDireccion" class="col-md-3 control-label"> <spring:message
									code="label.persona.idDireccion" />
							</label>
							<div class="col-md-6">
								<form:select path="idNacionalidad" cssClass="form-control">
									<form:option value="">--SELECT--</form:option>
									   <form:option value="1" label="Mexico"/>  
        							   <form:option value="2" label="Extranjero"/> 
								</form:select>
							</div>
							<div class="col-md-9">
								<form:errors path="idDireccion" />
							</div>
						</div>
						 

	    			


						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<input class="btn btn-primary" type="submit"
									value='<spring:message code="label.persona.enviar" />' />
									
									
								&nbsp; <a href="/sgi/personas/listar" class="btn btn-primary"
									role="button"> <spring:message
										code="label.persona.cancelar" />
								</a>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>