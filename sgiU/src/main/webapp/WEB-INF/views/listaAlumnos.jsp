<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url value="/formatos/pdf" var="pdfLink" />
<spring:url value="/formatos/xls" var="xlsLink" />
<spring:url value="/" var="backHome" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.titulo.alumnos" /></title>
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

					<div class="text-center">
					
					<nav aria-label="breadcrumb">
					  <ol class="breadcrumb">
					    <li class="breadcrumb-item active" aria-current="page">
					    	<spring:message code="label.titulo.alumnos" />
					    </li>
					  </ol>
					</nav>
					
					<input type="button"
							value='<spring:message code="label.alumno.agregar" />'
							onclick="window.location.href='alumnoForm'; return false;"
							class="btn btn-primary my-3"/>
					
					
			

					<div class=" table-responsive">
						<table class="table table-striped table-bordered">
							<tr>
							
							
							   <!-- Persona -->
								<th><spring:message code="label.persona.nombre" /></th>
								<th><spring:message code="label.persona.edad" /></th>
								<th><spring:message code="label.persona.correoElectronico" /></th>
								<th><spring:message code="label.persona.rfc" /></th>
								<th><spring:message code="label.persona.idGenero" /></th>
								<th><spring:message code="label.persona.idNacionalidad" /></th>
								<th><spring:message code="label.persona.pais" /></th>
								<th><spring:message code="label.persona.idDireccion.estado" /></th>
								<th><spring:message code="label.persona.idDireccion.localidad" /></th>
								<th><spring:message code="label.persona.idDireccion.calle" /></th>
								<th><spring:message code="label.persona.idDireccion.codigoPostal" /></th>
								<th><spring:message code="label.persona.idDireccion.numExt" /></th>
								<th><spring:message code="label.persona.idDireccion.numInt" /></th>


								<!-- Alumno -->
								<th><spring:message code="label.alumno.matrciula" /></th>
								<th><spring:message code="label.alumno.calificacion" /></th>
								
							

								<th><spring:message code="label.alumno.accion" /></th>
							</tr>

							<c:forEach var="alumno" items="${alumnos}">

								<c:url var="updateLink"
									value="/alumnos/actualizar/${alumno.idAlumno}" />

								<c:url var="deleteLink" value="/alumnos/eliminar">
									<c:param name="idAlumno" value="${alumno.idAlumno}" />
								</c:url>

								<tr>
									<td>${alumno.nombre}</td>
									<td>${alumno.edad}</td>
									<td>${alumno.correoElectronico}</td>
									<td>${alumno.rfc}</td>
									<td>${alumno.idGenero.nombre}</td>
									<td>${alumno.idNacionalidad.nombre}</td>
									<td>${alumno.pais}</td>
									<td>${alumno.estado}</td>
									<td>${alumno.localidad}</td>
									<td>${alumno.calle}</td>
									<td>${alumno.codigoPostal}</td>
									<td>${alumno.numExt}</td>
									<td>${alumno.numInt}</td>
									
									<td>${alumno.matricula}</td>
									<td>${alumno.calificacion}</td>
									
									
								
									
									<td><a href="${updateLink}" class="btn btn-primary"
										role="button"><spring:message code="label.alumno.editar" />
									</a>&nbsp; <a href="${deleteLink}" class="btn btn-danger"
										role="button"
										onclick="if (!(confirm('<spring:message code="label.alumno.pregunta" />'))) return false">
											<spring:message code="label.alumno.eliminar" />
									</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="text-center">
						<a class="btn btn-info mx-3" href="${pdfLink}" role="button"> 
							<spring:message code="label.reportes.pdf" />
						</a>
						
						<a class="btn btn-info" href="${xlsLink}" role="button"> 
							<spring:message code="label.reportes.xls" />
						</a>
					</div>
					<div class="col-md-12 text-center mt-5">
						<a class="btn btn-success" href="${backHome}" role="button"> 
							<spring:message code="label.button.home" />
						</a>
					</div>
					<br />
				</div>
			</div>


		</div>

	</div>
	<div class="footer"></div>
</body>

</html>