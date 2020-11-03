<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>
<h1 class="text-center h1 display-3 bebas mb-4">Registrarse</h1>

<section class="mx-auto col-lg-6">
	<article>
		<form:form action="guardarRegistro" method="POST"
			modelAttribute="usuario" enctype="multipart/form-data">
			<div class="form-group">
				<label for="nombre">Nombre:</label>
				<form:input path="nombre" type="text" id="nombre"
					class="form-control" />
			</div>

			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="precio">Email:</label>
					<form:input path="email" type="email" id="email"
						class="form-control" />
					<label for="precio">Contraseña:</label>
					<form:input path="password" type="password" id="password"
						class="form-control" />
						<p>
					<input type="submit" class="float-right btn btn-dark"
						value="Registrarse" />
				</div>

			</div>
		</form:form>
	</article>
</section>

<%@ include file="footer.jsp"%>