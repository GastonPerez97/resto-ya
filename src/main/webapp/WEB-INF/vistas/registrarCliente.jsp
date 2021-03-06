<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>

<div class="main-container">
	<h1 class="text-center h1 display-3 bebas mb-4">Registrarse</h1>
	
	<section class="mx-auto col-lg-4">
		<article>
			<form:form action="guardarRegistro" method="POST"
				modelAttribute="formularioRegistro">
				<div class="form-group">
					<label for="nombre">Nombre:</label>
					<form:input path="clienteModel.nombre" type="text" id="nombre"
						class="form-control" />
				</div>
	
				<div class="form-group">
					<label for="nombre">Apellido:</label>
					<form:input path="clienteModel.apellido" type="text" id="apellido"
						class="form-control" />
				</div>
				<div class="form-group">
					<label for="nombre">DNI:</label>
					<form:input path="clienteModel.dni" type="text" id="dni"
						class="form-control" />
				</div>
	
				<div class="form-group">
					<label for="telefono">Tel?fono:</label>
					<form:input path="clienteModel.telefono" type="text" id="nombre"
						class="form-control" />
				</div>
				<div class="form-group">
						<label for="email">Email:</label>
						<form:input path="usuarioModel.email" type="email" id="email"
							class="form-control" />
				</div>
				<div class="form-group">
						<label for="contrase?a">Contrase?a:</label>
						<form:input path="usuarioModel.clave" type="password"
							id="password" class="form-control" />
				</div>
				<div class="text-center">
					<input type="submit" class="btn btn-dark btn-lg" value="Registrarse" />
				</div>
			</form:form>
		</article>
	</section>
</div>

<%@ include file="footer.jsp"%>