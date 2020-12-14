<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>

<div class="main-container">
	<c:if test="${not empty reclamo.detalle}">
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
					<div>
						<a href="./restaurantes"><button type="button" class="btn btn-secondary">Volver</button></a>
					</div>
				</form:form>
			</article>
		</section>
	</c:if>
	
	<c:if test="${empty reclamo.detalle}">
		<h2 class="text-center h1 display-3 bebas mb-4">No hay un reclamo en el pedido</h2>
		
		<section class="comidas mx-auto">
			<a href="javascript:history.back()"><button type="button" class="btn btn-dark">Volver</button></a>
		</section>
	</c:if>
</div>

<%@ include file="footer.jsp"%>