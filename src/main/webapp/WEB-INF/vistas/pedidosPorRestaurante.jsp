<%@ include file="header.jsp"%>

<h1 class="text-center h1 display-3 bebas mb-4">Pedidos de "${nombreRestaurante}" </h1>

<section class="comidas mx-auto">
	<c:forEach items="${pedidoModel}" var="pedido">
		<article class="card comida shadow">

			<div class="card-body">
				<h5 class="card-title">Numero de pedido: ${pedido.idPedido}</h5>
				<h5 class="card-title">Fecha: ${pedido.fechaPedido}</h5>
				<h5 class="card-title">Estado: ${pedido.estadoPedidoModel.nombreEstado}</h5>
				<div class="d-flex justify-content-around mt-3">
					<form action="detalle-pedido" method="post">
						<input type="hidden" value="${pedido.idPedido}"	name="idPedido" id="id-restaurante-input" />
						<input type="submit" id="reserva-submit" value="Ver detalle" class="btn btn-dark" />
					</form>
					
					<c:if test="${pedido.estadoPedidoModel.idEstadoPedido != 3}">
						<c:if test="${pedido.estadoPedidoModel.idEstadoPedido != 4}">
							<form action="finalizar-pedido" method="post">
								<input type="hidden" value="${pedido.idPedido}"	name="idPedido" id="id-restaurante-input" />
								<input type="submit" value="Finalizar Pedido" class="btn btn-dark" />
							</form>
						</c:if>
                    </c:if>
					
					<a href="verReclamo?id=${pedido.idPedido}" class="btn btn-dark">Ver Reclamo</a>
				</div>

				
				
			</div>
		</article>
	</c:forEach>
	<a class="nav-link"
		href="/proyecto-limpio-spring-master/restaurantes">Volver</a>
</section>

<%@ include file="footer.jsp"%>