<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>

<c:choose>
<c:when test="${empty reclamo.detalle}">

<h1 class="text-center h1 display-3 bebas mb-4">Realizar Reclamo</h1>

<section class="mx-auto col-lg-6">

	<article>
		<form:form action="reclamoGenerado" method="POST" modelAttribute="formularioGeneracionReclamo">

			<div class="form-group">
				<label for="idPedido">ID Pedido:</label>
				<form:input path="pedido.IdPedido" id="idPedido" class="form-control"
					required="true" readonly="true" />
			</div>

			<div class="form-group">
					<div class="mb-3">
						<label for="detalle">Reclamo:</label>
				<form:textarea path="reclamo.detalle" id="detalle" class="form-control"
					required="true" readonly="false" />
					</div>
			</div>

			<div class="form-group mt-5 text-center">
				<button type="submit" class="btn btn-primary mx-auto">Generar
					Reclamo</button>

				<a href="./home"><button type="button"
						class="btn btn-secondary">Volver</button></a>
			</div>
		</form:form>
	</article>
</section>
</c:when>

<c:when test="${not empty reclamo.detalle}">

<section class="comidas mx-auto">
	<h3 class="text-center h1 display-3 bebas mb-4">Ya se encuentra un reclamo generado, en breve nos estaremos comunicando contigo. </h3>
	<a class="nav-link" href="/proyecto-limpio-spring-master/restaurantes">Volver</a>
</section>


</c:when>
</c:choose>



<%@ include file="footer.jsp"%>