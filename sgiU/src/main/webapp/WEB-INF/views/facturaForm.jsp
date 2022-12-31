<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<spring:url value="/facturas/facturaForm" var="btnFacturasForm" />
<spring:url value="/facturas/listar" var="btnFacturas" />
<spring:url value="/" var="backHome" />


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.titulo.facturas" /></title>
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
							class="btn btn-outline-secondary mx-3" href="${btnFacturas}"
							role="button"> <spring:message code="label.button.facturas" />
						</a></li>
						<li class="breadcrumb-item active" aria-current="page"><a
							class="btn btn-outline-secondary mx-3" href="${btnFacturasForm}"
							role="button"> <spring:message
									code="label.button.facturas.agregar" />
						</a></li>
					</ol>
				</nav>
			</div>

			<div class="col-md-12">
				<spring:url value="/facturas/guardaFactura" var="urlGuardar" />
				<spring:url value="/facturas/listar" var="urlRegresar" />
				<form:form action="${urlGuardar}" cssClass="form-horizontal" method="post"
					modelAttribute="factura">

					<form:hidden path="idFactura" />

					<div class="form-group row">
						<form:label path="folioFactura" class="col-md-1 col-form-label">
							<spring:message code="label.facturas.folioFactura" />
						</form:label>
						<div class="col-md-7">
							<form:input path="folioFactura" cssClass="form-control" />
						</div>
						<div class="col-md-12">
							<form:errors path="folioFactura" />
						</div>
					</div>
					<div class="form-group row">
						<label for="fechaFactura" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.facturas.fechaFactura" />
						</label>
						<div class="col-md-7">
							<form:input path="fechaFactura" cssClass="form-control" />
						</div>
						<div class="col-md-12">
							<form:errors path="fechaFactura" />
						</div>
					</div>
					<div class="form-group row">
						<label for="razonSocial" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.facturas.razonSocial" />
						</label>
						<div class="col-md-7">
							<form:input path="razonSocial" cssClass="form-control" />
						</div>
						<div class="col-md-12">
							<form:errors path="razonSocial" />
						</div>
					</div>
				




					<div class="form-group">
						<!-- Button -->
						<div class="col-md-12">
							<input class="btn btn-primary" type="submit"
								value='<spring:message code="label.facturas.guardar" />' />
						    
						     <a href="/sgioRG/facturas/listar" class="btn btn-primary"
								role="button"> <spring:message code="label.facturas.cancelar" />
							</a>
						</div>
					</div>
				</form:form>


			</div>




		</div>



	</div>
</body>
</html>