<%@ include file="header.jsp"%>

<h1 class="text-center h1 display-3 bebas mb-4">Pedidos de "${nombreRestaurante}" </h1>
<div class="mx-auto" style="width: 73%;">
	<a class="btn btn-dark mb-4" href="/proyecto-limpio-spring-master/restaurantes">Volver</a>
</div>
	
<section class="pedidos-container mx-auto">
	<c:forEach items="${pedidoModel}" var="pedido">
		<article class="card pedido-card shadow">
			<div class="card-body">
				<h5 class="card-title"><b>Numero de pedido:</b> ${pedido.idPedido}</h5>
				<h5 class="card-title"><b>Fecha:</b>  ${pedido.fechaPedido}</h5>
				<h5 class="card-title"><b>Estado:</b>  ${pedido.estadoPedidoModel.nombreEstado}</h5>
				<c:if test="${not empty pedido.fechaFinalizacionPedido}">
					<h5 class="card-title"><b>Fecha de Finalizacion:</b>  ${pedido.fechaFinalizacionPedido}</h5>
				</c:if>
				
				<div class="d-flex justify-content-around mt-4">
					<form action="detalle-pedido" method="post">
						<input type="hidden" value="${pedido.idPedido}"	name="idPedido" id="id-restaurante-input" />
						<input type="submit" id="reserva-submit" value="Ver detalle" class="btn btn-dark" />
					</form>

					<a href="verReclamo?id=${pedido.idPedido}" class="btn btn-dark">Ver Reclamo</a>
					
					<c:if test="${pedido.estadoPedidoModel.idEstadoPedido != 3}">
						<c:if test="${pedido.estadoPedidoModel.idEstadoPedido != 4}">
							<form action="finalizar-pedido" method="post">
								<input type="hidden" value="${pedido.idPedido}"	name="idPedido" id="id-restaurante-input" />
								<input type="submit" value="Finalizar Pedido" class="btn btn-dark" />
							</form>
							
							<form action="cancelar-pedido" method="post">
								<input type="hidden" value="${pedido.idPedido}"	name="idPedido" id="id-restaurante-input" />
								<input type="submit" value="Cancelar Pedido" class="btn btn-dark" />
							</form>
						</c:if>
                    </c:if>
				</div>
			</div>
		</article>
	</c:forEach>
</section>

<%@ include file="footer.jsp"%>