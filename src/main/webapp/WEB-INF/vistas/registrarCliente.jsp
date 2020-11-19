<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>
<h1 class="text-center h1 display-3 bebas mb-4">Registrarse</h1>

<section class="mx-auto col-lg-6">
	<article>
		<form:form action="guardarRegistro" method="POST"
			modelAttribute="formularioRegistro">
			<div class="form-group">
				<label for="nombre">Nombre:</label>
				<form:input path="clienteBuscado.nombre" type="text" id="nombre"
					class="form-control" />
			</div>

			<div class="form-group">
				<label for="nombre">Apellido:</label>
				<form:input path="clienteBuscado.apellido" type="text" id="apellido"
					class="form-control" />
			</div>
			<div class="form-group">
				<label for="nombre">DNI:</label>
				<form:input path="clienteBuscado.dni" type="text" id="dni"
					class="form-control" />
			</div>

			<div class="form-group">
				<label for="telefono">Teléfono:</label>
				<form:input path="clienteBuscado.telefono" type="text" id="nombre"
					class="form-control" />
			</div>
			<div class="form-group">
				<div class="form-group col-md-6">
					<label for="email">Email:</label>
					<form:input path="datoBuscado.email" type="email" id="email"
						class="form-control" />
					<label for="contraseña">Contraseña:</label>
					<form:input path="datoBuscado.password" type="password"
						id="password" class="form-control" />
					<br> <input type="submit" class="float-right btn btn-dark"
						value="Registrarse" /> <br> <br> <a class="nav-link"
						href="/proyecto-limpio-spring-master/login">Iniciar Sesión</a>
				</div>

			</div>
		</form:form>
	</article>
</section>

<%@ include file="footer.jsp"%>