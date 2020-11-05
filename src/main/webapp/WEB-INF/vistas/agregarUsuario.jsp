<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>

<h1 class="text-center h1 display-3 bebas mb-4">Agregar Usuario</h1>


<section class="mx-auto col-lg-6">

	<c:if test="${not empty errorValidacion}">
		<h4>
			<span>${errorValidacion}</span>
		</h4>
		<br>
	</c:if>

	<article>
		<form:form action="validarUsuario" method="POST"
			modelAttribute="usuario">

			<div class="form-group">
				<label for="nombreDeUsuario">Nombre:*</label>
				<form:input path="nombreDeUsuario" id="nombreDeUsuario"
					class="form-control" required="true" />
			</div>

			<div class="form-group">
				<label for="email">Email:*</label>
				<form:input path="email" type="text" id="email" class="form-control"
					required="true" />
			</div>
			<div class="form-group">
				<label for="clave">Clave:*</label>
				<form:input path="clave" type="password" id="clave"
					class="form-control" required="true" />
			</div>


			<div class="form-group mt-5 text-center">
				<button type="submit" class="btn btn-primary mx-auto">Agregar</button>

				<a href="./usuarios"><button type="button"
						class="btn btn-secondary">Volver</button></a>
			</div>
		</form:form>
	</article>
</section>

<%@ include file="footer.jsp"%>