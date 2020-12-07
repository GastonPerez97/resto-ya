<%@ include file="header.jsp"%>

<h1 class="text-center h1 display-3 bebas mb-4">Pedidos de "${nombreRestaurante}"" </h1>

<section class="comidas mx-auto">
	<c:forEach items="${pedidoModel}" var="pedido">
		<article class="card comida shadow">

			<div class="card-body">
				<h3 class="card-title bebas">Número de pedido: ${pedido.idPedido}</h3>
				<h3 class="card-title bebas">Fecha: ${pedido.fechaPedido}</h3>
				<h3 class="card-title bebas">Estado: ${pedido.estadoPedidoModel.nombreEstado}</h3>
				<h3 class="card-title bebas">							
				<form action="detalle-pedido" class="form-inline" method="post">
					<input type="hidden" value="${pedido.idPedido}"
						name="idPedido" id="id-restaurante-input" />
					<div class="form-group">
						<input type="submit" id="reserva-submit"
							value="Ver detalle" class="float-right btn btn-dark" />
					</div>
				</form></h3>
				<h3 class="card-title bebas">
				<a href="verReclamo?id=${pedido.idPedido}"
									class="float-left btn btn-dark">Ver Reclamo</a>
				</h3>
			</div>
		</article>
	</c:forEach>
	<a class="nav-link"
		href="/proyecto-limpio-spring-master/restaurantes">Volver</a>
</section>

<%@ include file="footer.jsp"%>