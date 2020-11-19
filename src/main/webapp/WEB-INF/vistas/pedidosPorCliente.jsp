<%@ include file="header.jsp"%>

<h1 class="text-center h1 display-3 bebas mb-4">Histórico de
	pedidos</h1>

<section class="comidas mx-auto">
	<c:forEach items="${pedidoModel}" var="pedido">
		<article class="card comida shadow">

			<div class="card-body">
				<h3 class="card-title bebas">${pedido.idPedido}</h3>
				<h3 class="card-title bebas">${pedido.restaurante.direccion}</h3>
				<h3 class="card-title bebas">${pedido.restaurante.horario}</h3>
			</div>
		</article>
	</c:forEach>
	<a class="nav-link"
		href="/proyecto-limpio-spring-master/historicoPedidos">Volver a
		buscar</a>
</section>

<%@ include file="footer.jsp"%>


