<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<spring:url value="/pagoCursos/ordenPagoCursosForm" var="btnOrdenPagoCursosForm" />
<spring:url value="/pagoCursos/listar" var="btnOrdenPagoCursos" />
<spring:url value="/" var="backHome" />


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.titulo.ordenPagoCursos" /></title>
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
			<div class="col-md-12">
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
							class="btn btn-outline-secondary mx-3" href="${btnOrdenPagoCursos}"
							role="button"> <spring:message code="label.button.ordenPagoCursos" />
						</a></li>
						<li class="breadcrumb-item active" aria-current="page"><a
							class="btn btn-outline-secondary mx-3" href="${btnOrdenPagoCursosForm}"
							role="button"> <spring:message
									code="label.button.orden.agregar" />
						</a></li>
					</ol>
				</nav>
			</div>

			<div class="col-md-12">
				<spring:url value="/pagoCursos/guardaOrdenPagoCursos" var="urlGuardar" />
				<spring:url value="/pagoCursos/listar" var="urlRegresar" />
				<form:form action="${urlGuardar}" cssClass="form-horizontal" method="post"
					modelAttribute="ordenPagoCursos">

					<form:hidden path="idOrdenPagoCursos" />

					<div class="form-group row">
						<form:label path="folioPago" class="col-md-1 col-form-label">
							<spring:message code="label.orden.folioPago" />
						</form:label>
						<div class="col-md-7">
							<form:input path="folioPago" cssClass="form-control" />
						</div>
						<div class="col-md-12">
							<form:errors path="folioPago" />
						</div>
					</div>
					<div class="form-group row">
						<label for="descripcion" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.orden.descripcion" />
						</label>
						<div class="col-md-7">
							<form:input path="descripcion" cssClass="form-control" />
						</div>
						<div class="col-md-12">
							<form:errors path="descripcion" />
						</div>
					</div>
					<div class="form-group row">
						<label for="fechaPago" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.orden.fechaPago" />
						</label>
						<div class="col-md-7">
							<form:input path="fechaPago" cssClass="form-control" />
						</div>
						<div class="col-md-12">
							<form:errors path="fechaPago" />
						</div>
					</div>
					
					<div class="form-group row">
						<label for="idTipoPago" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.orden.idTipoPago" />
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

					<div class="form-group">
						<!-- Button -->
						<div class="col-md-12">
							<input class="btn btn-primary" type="submit"
								value='<spring:message code="label.orden.guardar" />' />
						    
						     <a href="/sgioRG/pagoCursos/listar" class="btn btn-primary"
								role="button"> <spring:message code="label.orden.cancelar" />
							</a>
						</div>
					</div>
				</form:form>


			</div>




		</div>



	</div>
</body>
</html>