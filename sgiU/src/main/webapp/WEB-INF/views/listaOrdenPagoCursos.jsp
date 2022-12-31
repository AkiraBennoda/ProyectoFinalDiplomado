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

					<div class="text-center">
					
					<nav aria-label="breadcrumb">
					  <ol class="breadcrumb">
					    <li class="breadcrumb-item active" aria-current="page">
					    	<spring:message code="label.titulo.ordenPagoCursos" />
					    </li>
					  </ol>
					</nav>
					
					<input type="button"
							value='<spring:message code="label.orden.agregar" />'
							onclick="window.location.href='ordenPagoCursosForm'; return false;"
							class="btn btn-primary my-3"/>
					
					
			

					<div class=" table-responsive">
						<table class="table table-striped table-bordered">
							<tr>
								<th><spring:message code="label.orden.folioPago" /></th>
								<th><spring:message code="label.orden.descripcion" /></th>
								<th><spring:message code="label.orden.fechaPago" /></th>
								<th><spring:message code="label.orden.idTipoPago" /></th>
						

								<th><spring:message code="label.orden.accion" /></th>
							</tr>

							<c:forEach var="ordenPagoCursos" items="${ordenPagoCursos}">

								<c:url var="updateLink"
									value="/pagoCursos/actualizar/${ordenPagoCursos.idOrdenPagoCursos}" />

								<c:url var="deleteLink" value="/pagoCursos/eliminar">
									<c:param name="idOrdenPagoCursos" value="${ordenPagoCursos.idOrdenPagoCursos}" />
								</c:url>

								<tr>
									<td>${ordenPagoCursos.folioPago}</td>
									<td>${ordenPagoCursos.descripcion}</td>
									<td>${ordenPagoCursos.fechaPago}</td>
									<td>${ordenPagoCursos.idTipoPago.nombre}</td>
									
									
								
									
									<td><a href="${updateLink}" class="btn btn-primary"
										role="button"><spring:message code="label.orden.editar" />
									</a>&nbsp; <a href="${deleteLink}" class="btn btn-danger"
										role="button"
										onclick="if (!(confirm('<spring:message code="label.orden.eliminar.pregunta" />'))) return false">
											<spring:message code="label.orden.eliminar" />
									</a></td>
								</tr>
							</c:forEach>
						</table>
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