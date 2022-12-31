<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<spring:url value="/personas/personaFormActualiza" var="btnPersonasForm" />
<spring:url value="/personas/listar" var="btnPersonas" />
<spring:url value="/" var="backHome" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="label.titulo.personas" /></title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
	
	<%@ page isELIgnored="false"%>
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container-fluid" style="background: #002147;">
		<div class="row">
			<div class="col-md-12" style="padding: 20px 3px;">
				<img alt="" width="238px"
					src="<c:url value="/resources/img/logo-blanco.png"/>">
			</div>

		</div>

	</div>

	<div class="container-fluid">
		<div class="row">
			<h3 class="text-center mt-5">
				<spring:message code="label.titulo.aplicacion" />
			</h3>
			<hr />
		</div>

		<div class="col-md-12">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						class="btn btn-outline-secondary mx-3" href="${backHome}"
						role="button"> <spring:message code="label.button.home" />
					</a></li>
					<li class="breadcrumb-item" aria-current="page"><a
						class="btn btn-outline-secondary mx-3" href="${btnPersonas}"
						role="button"> <spring:message code="label.button.personas" />
					</a></li>
					<li class="breadcrumb-item active" aria-current="page"><a
						class="btn btn-outline-secondary mx-3" href="${btnPersonasForm}"
						role="button"> <spring:message code="label.persona.actualizar" />
					</a></li>
				</ol>
			</nav>
		</div>

		<div class="col-md-12">
			<spring:url value="/personas/guardaPersona" var="urlGuardar" />
			<spring:url value="/personas/listar" var="urlRegresar" />
			<form:form action="${urlGuardar}" cssClass="form-horizontal" method="post"
				modelAttribute="persona">

				<form:hidden path="idPersona" />

						<div class="form-group row">
						<form:label path="nombre" class="col-md-1 col-form-label">
							<spring:message code="label.persona.nombre" />
						</form:label>
						<div class="col-md-7">
							<form:input path="nombre" cssClass="form-control" />
						</div>
						<div class="col-md-12">
							<form:errors path="nombre" />
						</div>
					</div>
					<div class="form-group row">
						<label for="edad" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.persona.edad" />
						</label>
						<div class="col-md-7">
							<form:input path="edad" cssClass="form-control" />
						</div>
						<div class="col-md-12">
							<form:errors path="edad" />
						</div>
					</div>
					<div class="form-group row">
						<label for="edad" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.persona.correoElectronico" />
						</label>
						<div class="col-md-7">
							<form:input path="correoElectronico" cssClass="form-control" />
						</div>
						<div class="col-md-12">
							<form:errors path="correoElectronico" />
						</div>
					</div>
					<div class="form-group row">
						<label for="edad" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.persona.rfc" />
						</label>
						<div class="col-md-7">
							<form:input path="rfc" cssClass="form-control" />
						</div>
						<div class="col-md-12">
							<form:errors path="rfc" />
						</div>
					</div>
					<div class="form-group row">
						<label for="idGenero" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.persona.idGenero" />
						</label>
						<div class="col-md-7">
							<form:select path="idGenero" cssClass="form-control">
									<form:option value="">--SELECT--</form:option>
									<form:options items="${applicationScope.generoList}"></form:options>
							</form:select>
						</div>
						<div class="col-md-6">
							<form:errors path="idGenero" />
						</div>
					</div>
					<div class="form-group row">
						<label for="idNacionalidad" class="col-md-1 control-label">
							<spring:message code="label.persona.idNacionalidad" />
						</label>
						<div class="col-md-7">
							<form:select path="idNacionalidad" cssClass="form-control">
									<form:option value="">--SELECT--</form:option>
									<form:options items="${applicationScope.nacionalidadList}"></form:options>
							</form:select>
						</div>
						<div class="col-md-6">
							<form:errors path="idNacionalidad" />
						</div>
					</div>
				<div class="form-group row">
						<label for="pais" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.persona.pais" />
						</label>
						<div class="col-md-7">
							<form:input path="pais" cssClass="form-control" />
						</div>
						<div class="col-md-12">
							<form:errors path="pais" />
						</div>
					</div>					
					<div class="form-group row">
						<label for="estado" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.persona.idDireccion.estado" />
						</label>
						<div class="col-md-7">
							<form:input path="estado" cssClass="form-control" />
						</div>
						<div class="col-md-12">
							<form:errors path="estado" />
						</div>
					</div>
					
					<div class="form-group row">
						<label for="localidad" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.persona.idDireccion.localidad" />
						</label>
						<div class="col-md-7">
							<form:input path="localidad" cssClass="form-control" />
						</div>
						<div class="col-md-12">
							<form:errors path="localidad" />
						</div>
					</div>			
					
					<div class="form-group row">
						<label for="calle" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.persona.idDireccion.calle" />
						</label>
						<div class="col-md-7">
							<form:input path="calle" cssClass="form-control" />
						</div>
						<div class="col-md-12">
							<form:errors path="calle" />
						</div>
					</div>		
					<div class="form-group row">
						<label for="codigoPostal" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.persona.idDireccion.codigoPostal" />
						</label>
						<div class="col-md-7">
							<form:input path="codigoPostal" cssClass="form-control" />
						</div>
						<div class="col-md-12">
							<form:errors path="codigoPostal" />
						</div>
					</div>		
					<div class="form-group row">
						<label for="numExt" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.persona.idDireccion.numExt" />
						</label>
						<div class="col-md-7">
							<form:input path="numExt" cssClass="form-control" />
						</div>
						<div class="col-md-12">
							<form:errors path="numExt" />
						</div>
					</div>		
					<div class="form-group row">
						<label for="numInt" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.persona.idDireccion.numInt" />
						</label>
						<div class="col-md-7">
							<form:input path="numInt" cssClass="form-control" />
						</div>
						<div class="col-md-12">
							<form:errors path="numInt" />
						</div>
					</div>					
									
				
					
								


			<div class="form-group">
						<!-- Button -->
						<div class="col-md-offset-3 col-md-9">
							<input class="btn btn-primary" type="submit"
								value='<spring:message code="label.persona.guardar" />' />
						    
						     <a href="${urlRegresar}" class="btn btn-primary"
								role="button"> <spring:message code="label.persona.cancelar" />
							</a>
						</div>
					</div>
			</form:form>

			<spring:url value="/personas/guardaPersona" var="urlGuardar" />
			<spring:url value="/personas/listar" var="urlRegresar" />

		</div>

	</div>
</body>
</html>