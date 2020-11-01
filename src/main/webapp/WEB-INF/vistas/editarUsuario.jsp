<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>

<h1 class="text-center h1 display-3 bebas mb-4">Editar Usuario</h1>


<section class="mx-auto col-lg-6">

	<article>
		<form:form action="validarEditarUsuario" method="POST"
			modelAttribute="usuario">

			<div class="form-group">
				<label for="id">Id:</label>
				<form:input path="id" id="id" class="form-control" required="true" readonly="true" />
			</div>

			<div class="form-group">
				<label for="nombre">Nombre:</label>
				<form:input path="nombre" id="nombre" class="form-control"
					required="true" />
			</div>

			<div class="form-group">
				<label for="email">Email:</label>
				<form:input path="email" type="text" id="email" class="form-control"
					required="true" />
			</div>
			<div class="form-group">
				<label for="clave">Clave:</label>
				<form:input path="clave" type="password" id="clave"
					class="form-control" required="true" />
			</div>


			<div class="form-group mt-5 text-center">
				<button type="submit" class="btn btn-primary mx-auto">Editar</button>

				<a href="./usuarios"><button type="button"
						class="btn btn-secondary">Volver</button></a>
			</div>
		</form:form>
	</article>
</section>

<%@ include file="footer.jsp"%>