<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<spring:url value="/cursos/cursoForm" var="btnCursosForm" />
<spring:url value="/cursos/listar" var="btnCursos" />
<spring:url value="/" var="backHome" />


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="label.titulo.cursos" /></title>
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
							class="btn btn-outline-secondary mx-3" href="${btnCursos}"
							role="button"> <spring:message code="label.button.cursos" />
						</a></li>
						<li class="breadcrumb-item active" aria-current="page"><a
							class="btn btn-outline-secondary mx-3" href="${btnCursosForm}"
							role="button"> <spring:message
									code="label.button.cursos.agregar" />
						</a></li>
					</ol>
				</nav>
			</div>

			<div class="col-md-12">
				<spring:url value="/cursos/guardaCurso" var="urlGuardar" />
				<spring:url value="/cursos/listar" var="urlRegresar" />
				<form:form action="${urlGuardar}" cssClass="form-horizontal" method="post"
					modelAttribute="curso">

					<form:hidden path="idCurso" />

					<div class="form-group row">
						<form:label path="codigoCurso" class="col-md-1 col-form-label">
							<spring:message code="label.cursos.codigoCurso" />
						</form:label>
						<div class="col-md-7">
							<form:input path="codigoCurso" cssClass="form-control" />
						</div>
						<div class="col-md-12">
							<form:errors path="codigoCurso" />
						</div>
					</div>
				
				
					<div class="form-group row">
						<label for="idIdioma" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.cursos.idIdioma" />
						</label>
						<div class="col-md-7">
							<form:select path="idIdioma" cssClass="form-control">
									<form:option value="">--SELECT--</form:option>
									<form:options items="${applicationScope.idiomaList}"></form:options>
							</form:select>
						</div>
						<div class="col-md-6">
							<form:errors path="idIdioma" />
						</div>
					</div>
					
					<div class="form-group row">
						<label for="idTipoCurso" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.cursos.idTipoCurso" />
						</label>
						<div class="col-md-7">
							<form:select path="idTipoCurso" cssClass="form-control">
									<form:option value="">--SELECT--</form:option>
									<form:options items="${applicationScope.tipoCursoList}"></form:options>
							</form:select>
						</div>
						<div class="col-md-6">
							<form:errors path="idTipoCurso" />
						</div>
					</div>		
					
					<div class="form-group row">
						<label for="idModalidad" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.cursos.idModalidad" />
						</label>
						<div class="col-md-7">
							<form:select path="idModalidad" cssClass="form-control">
									<form:option value="">--SELECT--</form:option>
									<form:options items="${applicationScope.modalidadList}"></form:options>
							</form:select>
						</div>
						<div class="col-md-6">
							<form:errors path="idModalidad" />
						</div>
					</div>			
					
					<div class="form-group row">
						<label for="idNivel" class="col-md-1 col-form-label"> 
						<spring:message
								code="label.cursos.idNivel" />
						</label>
						<div class="col-md-7">
							<form:select path="idNivel" cssClass="form-control">
									<form:option value="">--SELECT--</form:option>
									<form:options items="${applicationScope.nivelList}"></form:options>
							</form:select>
						</div>
						<div class="col-md-6">
							<form:errors path="idNivel" />
						</div>
					</div>	


					<div class="form-group">
						<!-- Button -->
						<div class="col-md-12">
							<input class="btn btn-primary" type="submit"
								value='<spring:message code="label.cursos.guardar" />' />
						    
						     <a href="/sgioRG/cursos/listar" class="btn btn-primary"
								role="button"> <spring:message code="label.cursos.cancelar" />
							</a>
						</div>
					</div>
				</form:form>


			</div>




		</div>



	</div>
</body>
</html>