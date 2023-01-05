<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<spring:url value="/inscripciones/inscripcionFormActualiza" var="btnInscripcionesForm" />
<spring:url value="/inscripciones/listar" var="btnInscripciones" />
<spring:url value="/" var="backHome" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="label.titulo.inscripciones" /></title>
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
							class="btn btn-outline-secondary mx-3" href="${btnIncripciones}"
							role="button"> <spring:message code="label.button.personas" />
						</a></li>
						<li class="breadcrumb-item active" aria-current="page"><a
							class="btn btn-outline-secondary mx-3" href="${btnInscripcionesForm}"
							role="button"> <spring:message
									code="label.inscripcion.agregar" />
						</a></li>
					</ol>
				</nav>
			</div>

			<div class="col-md-12">
				<spring:url value="/inscripciones/guardaInscripcion" var="urlGuardar" />
				<spring:url value="/inscripciones/listar" var="urlRegresar" />
				<form:form action="${urlGuardar}" cssClass="form-horizontal" method="post"
					modelAttribute="inscripcion">

					<form:hidden path="idInscripcion" />

					<div class="form-group row">
						<form:label path="fechaInscripcion" class="col-md-1 col-form-label">
							<spring:message code="label.inscripcion.fechaInscripcion" />
						</form:label>
						<div class="col-md-7">
							<form:input path="fechaInscripcion" cssClass="form-control" />
						</div>
						<div class="col-md-12">
							<form:errors path="fechaInscripcion" />
						</div>
					</div>
					<div class="form-group row">
						<label for="edad" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.inscripcion.reinscripcion" />
						</label>
						<div class="col-md-7">
							<form:input path="reinscripcion" cssClass="form-control" />
						</div>
						<div class="col-md-12">
							<form:errors path="reinscripcion" />
						</div>
					</div>
					<div class="form-group row">
						<label for="pagado" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.inscripcion.pagado" />
						</label>
						<div class="col-md-7">
							<form:input path="pagado" cssClass="form-control" />
						</div>
						<div class="col-md-12">
							<form:errors path="pagado" />
						</div>
					</div>
					
			
					<div class="form-group row">
						<label for="idTipoPago" class="col-md-1 control-label">
							<spring:message code="label.inscripcion.idTipoPago" />
						</label>
						<div class="col-md-7">
							<form:select path="idTipoPago" cssClass="form-control">
									<form:option value="">--SELECT--</form:option>
									<form:options items="${applicationScope.tipoPagoList}"></form:options>
							</form:select>
						</div>
						<div class="col-md-6">
							<form:errors path="idTipoPago" />
						</div>
					</div>			
					
					<div class="form-group row">
						<label for="idFactura" class="col-md-1 control-label">
							<spring:message code="label.inscripcion.Factura" />
						</label>
						<div class="col-md-7">
							<form:select path="idFactura" cssClass="form-control">
									<form:option value="">--SELECT--</form:option>
									<form:options items="${applicationScope.facturaList}"></form:options>
							</form:select>
						</div>
						<div class="col-md-6">
							<form:errors path="idFactura" />
						</div>
					</div>
					
					<div class="form-group row">
						<label for="idAlumno" class="col-md-1 control-label">
							<spring:message code="label.inscripcion.idAlumno" />
						</label>
						<div class="col-md-7">
							<form:select path="idAlumno" cssClass="form-control">
									<form:option value="">--SELECT--</form:option>
									<form:options items="${applicationScope.alumnoList}"></form:options>
							</form:select>
						</div>
						<div class="col-md-6">
							<form:errors path="idAlumno" />
						</div>
					</div>
					<div class="form-group row">
						<label for="idCurso" class="col-md-1 control-label">
							<spring:message code="label.inscripcion.idCurso" />
						</label>
						<div class="col-md-7">
							<form:select path="idCurso" cssClass="form-control">
									<form:option value="">--SELECT--</form:option>
									<form:options items="${applicationScope.cursoList}"></form:options>
							</form:select>
						</div>
						<div class="col-md-6">
							<form:errors path="idCurso" />
						</div>
					</div>


					<div class="form-group">
						<!-- Button -->
						<div class="col-md-12">
							<input class="btn btn-primary" type="submit"
								value='<spring:message code="label.persona.guardar" />' />
						    
						     <a href="/sgioRG/personas/listar" class="btn btn-primary"
								role="button"> <spring:message code="label.persona.cancelar" />
							</a>
						</div>
					</div>
				</form:form>


			</div>


	</div>
</body>
</html>