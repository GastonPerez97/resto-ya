<%@ include file="header.jsp"%>

<h1 class="text-center h1 display-3 bebas mb-4">Calificaciones del Restaurante</h1>

<section class="comidas mx-auto">
	<c:forEach items="${restaurante}" var="restaurante">
		<article class="card comida shadow">

			<div class="card-body">
				<h3 class="card-title bebas">Rsestaurante: ${restaurante.idRestaurante}</h3>
				<h3 class="card-title bebas">Nombre: ${restaurante.nombre}</h3>
				<h3 class="card-title bebas">Calificacion: ${restaurante.calificacion}</h3>
				<h3 class="card-title bebas">							
				<%-- <form action="detalle-pedido" class="form-inline" method="post">
					<input type="hidden" value="${pedido.idPedido}"
						name="idPedido" id="id-restaurante-input" />
					<div class="form-group">
						<input type="submit" id="reserva-submit"
							value="Ver detalle" class="float-right btn btn-dark" />
					</div>
				</form></h3>
				<form action="generarReclamo" class="form-inline" method="post">
					<input type="hidden" value="${pedido.idPedido}"
						name="idPedido" id="idPedido" />
					<div class="form-group">
						<input type="submit" id="reclamo-submit"
							value="Hacer un reclamo" class="float-right btn btn-dark" />
					</div>
				</form></h3> --%>
			</div>
		</article>
	</c:forEach>
	<a class="nav-link"
		href="/proyecto-limpio-spring-master/restaurantes">Volver</a>
</section>

<%@ include file="footer.jsp"%>


