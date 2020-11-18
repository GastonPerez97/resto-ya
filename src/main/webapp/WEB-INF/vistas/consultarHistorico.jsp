<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>
<h1 class="text-center h1 display-3 bebas mb-4">Mis pedidos</h1>

<section class="mx-auto col-lg-6">
	<article>
		<form:form action="consultarPedidos" method="POST"
			modelAttribute="clienteModel">
			<div class="form-group">
				<label for="nombre">Nombre del cliente:</label>
				<form:input path="nombre" type="text" id="nombre"
					class="form-control" />
			</div>
			<div class="form-group">
				<label for="telefono">Teléfono:</label>
				<form:input path="telefono" type="text" id="telefono"
					class="form-control" />
			</div>
			<br>
			<input type="submit" class="float-right btn btn-dark"
				value="Consultar" />
			<br>
		</form:form>
	</article>
</section>

<%@ include file="footer.jsp"%>