<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>

<div class="main-container">
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
</div>

<%@ include file="footer.jsp"%>