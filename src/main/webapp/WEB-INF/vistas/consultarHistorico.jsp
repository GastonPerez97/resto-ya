<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>

<div class="main-container">
	<h1 class="text-center h1 display-3 bebas mb-4">Listado de clientes:</h1>
	
	<section class="comidas mx-auto">
		<div class="d-flex justify-content-start flex-wrap">
			<c:forEach items="${clienteModel}" var="cli">
				<article class="card comida shadow d-flex flex-column justify-content-between">
					<div class="card-body">
						<p><span class="h4"><b>Nombre y Apellido: </b></span>${cli.nombre} ${cli.apellido}</p>
						<p><span class="h4"><b>DNI: </b></span>${cli.dni}</p>
						<p><span class="h4"><b>Telefono: </b></span>${cli.telefono}</p>
					</div>

					<div class="card-body">
						<form action="consultarPedidos" class="form-inline" method="post">
							<input type="hidden" value="${cli.idCliente}" name="idCliente"
								id="id-restaurante-input" />
							<div class="form-group">
								<input type="submit" id="ver-pedidos-submit" value="Ver Pedidos"
									class="float-right btn btn-dark">
							</div>
						</form>
					</div>
				</article>
			</c:forEach>
		</div>
	</section>
</div>

<%@ include file="footer.jsp"%>