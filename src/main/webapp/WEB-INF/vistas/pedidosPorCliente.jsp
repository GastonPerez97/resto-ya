<%@ include file="header.jsp"%>

<div class="main-container">
	<h1 class="text-center h1 display-3 bebas mb-4">Histórico de pedidos</h1>
		
	<div style="width: 80%" class="mx-auto mb-3">
		<a class="btn btn-outline-primary" href="/proyecto-limpio-spring-master/historicoPedidos">Volver a Clientes</a>
	</div>
	
	<section class="comidas mx-auto">
		<c:forEach items="${pedidoModel}" var="pedido">
			<article class="card comida shadow">
	
				<div class="card-body">
					<p class="card-title"><b>Número de pedido: </b>${pedido.idPedido}</p>
					<p class="card-title"><b>Restaurante: </b>${pedido.restaurante.nombre}</p>
					<p class="card-title"><b>Fecha: </b>${pedido.fechaPedido}</p>
					<p class="card-title"><b>Dirección: </b>${pedido.restaurante.direccion}</p>
					<div class="d-flex justify-content-between mt-3">
						<form action="detalle-pedido" class="form-inline" method="post">
							<input type="hidden" value="${pedido.idPedido}"
								name="idPedido" id="id-restaurante-input" />
							<div class="form-group">
								<input type="submit" id="reserva-submit"
									value="Ver detalle" class="float-right btn btn-dark" />
							</div>
						</form>
						<form action="generarReclamo" class="form-inline" method="post">
							<input type="hidden" value="${pedido.idPedido}"
								name="idPedido" id="idPedido" />
							<div class="form-group">
								<input type="submit" id="reclamo-submit"
									value="Hacer un reclamo" class="float-right btn btn-dark" />
							</div>
						</form>
					</div>
				</div>
			</article>
		</c:forEach>
	</section>
</div>

<%@ include file="footer.jsp"%>


