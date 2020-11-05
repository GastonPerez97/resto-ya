<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>
<h1 class="text-center h1 display-3 bebas mb-4">Iniciar Sesión</h1>

<section class="mx-auto col-lg-6">
	<article>
		<form:form action="validarLogin" method="POST" 	modelAttribute="usuario">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="email">Email:</label>
					<form:input path="email" id="text"
						class="form-control" />
					<label for="contraseña">Contraseña:</label>
					<form:input path="password" type="password" id="password"
						class="form-control" />
					<br> <input type="submit" class="float-right btn btn-dark"
						value="Ingresar" />
				</div>

			</div>
		</form:form>
	</article>
</section>

<%@ include file="footer.jsp"%>