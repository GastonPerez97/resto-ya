<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>

<div class="main-container">
	<h1 class="text-center h1 display-3 bebas mb-4">Editar Usuario</h1>
	
	<section class="mx-auto col-lg-6">
		<article>
			<form:form action="validarEditarUsuario" method="POST"
				modelAttribute="usuario">
	
				<div class="form-group">
					<label for="idUsuarioRol">Id:</label>
					<form:input path="idUsuarioRol.usuarioModel.idUsuario" id="idUsuarioRol" class="form-control" required="true" readonly="true" />
				</div>
	
				<div class="form-group">
					<label for="nombreDeUsuario">Nombre:</label>
					<form:input path="idUsuarioRol" id="idUsuarioRol" class="form-control"
						required="true" />
				</div>
	
				<div class="form-group">
					<label for="idUsuarioRol">Email:</label>
					<form:input path="idUsuarioRol" type="text" id="idUsuarioRol" class="form-control"
						required="true" />
				</div>
				<div class="form-group">
					<label for="idUsuarioRol">Clave:</label>
					<form:input path="idUsuarioRol" type="password" id="idUsuarioRol"
						class="form-control" required="true" />
				</div>
	
	
				<div class="form-group mt-5 text-center">
					<button type="submit" class="btn btn-outline-danger mx-auto">Editar</button>
	
					<a href="./usuarios"><button type="button"
							class="btn btn-outline-secondary">Volver</button></a>
				</div>
			</form:form>
		</article>
	</section>
</div>

<%@ include file="footer.jsp"%>