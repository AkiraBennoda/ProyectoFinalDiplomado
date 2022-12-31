<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url value="/formatos/pdf" var="pdfLink" />
<spring:url value="/formatos/xls" var="xlsLink" />

<!DOCTYPE html>
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
		<div class="col-md-offset-1 col-md-10">
			<h3 class="text-center">
				<spring:message code="label.titulo.aplicacion" />
			</h3>
			<hr />

			<input type="button"
				value='<spring:message code="label.persona.agregar" />'
				onclick="window.location.href='personaForm'; return false;"
				class="btn btn-primary" /> <br /> <br />
			<div class="panel panel-danger">
				<div class="panel-heading">
					<div class="panel-title">
						<spring:message code="label.titulo.personas" />
					</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th><spring:message code="label.persona.nombre" /></th>
							<th><spring:message code="label.persona.edad" /></th>
							<th><spring:message code="label.persona.correoElectronico" /></th>
							<th><spring:message code="label.persona.rfc" /></th>
							<th><spring:message code="label.persona.idGenero" /></th>
							<th><spring:message code="label.persona.idNacionalidad" /></th>
							<th><spring:message code="label.persona.idDireccion" /></th>
							<th><spring:message code="label.persona.accion" /></th>
						</tr>

						<c:forEach var="persona" items="${personas}">

							<c:url var="updateLink"
								value="/personas/actualizar/${persona.idPersona}" />

							<c:url var="deleteLink" value="/personas/eliminar">
								<c:param name="idPersona" value="${persona.idPersona}" />
							</c:url>

							<tr>
								<td>${persona.nombre}</td>
								<td>${persona.edad}</td>
								<td>${persona.correoElectronico}</td>
								<td>${persona.rfc}</td>
								<td>${persona.idGenero.nombre}</td>
								<td>${persona.idNacionalidad.nombre}</td>
								<td>${persona.idDireccion.codigoPostal}</td>
								<td><a href="${updateLink}" class="btn btn-primary"
									role="button"><spring:message code="label.persona.editar" />
								</a>&nbsp; <a href="${deleteLink}" class="btn btn-danger"
									role="button"
									onclick="if (!(confirm('<spring:message code="label.persona.eliminar.pregunta" />'))) return false">
										<spring:message code="label.persona.eliminar" />
								</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="text-center">
					<a class="btn btn-info" href="${pdfLink}" role="button"
						target="_blank"> <spring:message code="label.reportes.pdf" />
					</a> &nbsp; <a class="btn btn-info" href="${xlsLink}" role="button"
						target="_blank"> <spring:message code="label.reportes.xls" />
					</a>
				</div>
				<br />
			</div>
		</div>
	</div>
	<div class="footer"></div>
</body>

</html>