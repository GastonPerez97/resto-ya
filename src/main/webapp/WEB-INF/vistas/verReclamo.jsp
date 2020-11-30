<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>

<h1 class="text-center h1 display-3 bebas mb-4">Pedido "${idPedido}"</h1>


<section class="mx-auto col-lg-6">

	<article>
		<form:form action="reclamoGenerado" method="POST" modelAttribute="reclamo">

			<div class="form-group">
					<div class="mb-3">
						<label for="detalle">Reclamo:</label>
				<form:textarea path="detalle" id="detalle" class="form-control"
					required="true" readonly="true" />
					</div>
			</div>

				<a href="./restaurantes"><button type="button"
						class="btn btn-secondary">Volver</button></a>
			</div>
		</form:form>
	</article>
</section>

<%@ include file="footer.jsp"%>