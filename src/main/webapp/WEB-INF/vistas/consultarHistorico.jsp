<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="header.jsp"%>

<h1 class="text-center h1 display-3 bebas mb-4">Listado de
	clientes:</h1>Lu
<section class="restaurantes">
	<c:forEach items="${clienteModel}" var="cli">
		<div class="d-flex justify-content-center align-items-center">
			<div class="card mb-3 restaurante shadow">
				<div class="row no-gutters">
					<div class="col-md-8">
						<div class="card-body">
							<h2 class="card-title bebas">${cli.nombre}</h2>
							<p class="card-text">
								<span class="h4">DNI: </span>${cli.dni}</p>
							<p class="card-text">
								<span class="h4">Telefono: </span>${cli.telefono}</p>
						</div>

						<div class="card-body">
							<form action="consultarPedidos" class="form-inline" method="post">
								<input type="hidden" value="${cli.idCliente}" name="idCliente"
									id="id-restaurante-input" />
								<div class="form-group">
									<input type="submit" id="ver-pedidos-submit" value="verPedidos"
										class="float-right btn btn-dark">
								</div>
							</form>
						</div>


					</div>
				</div>
			</div>
			<div class="d-flex flex-column ml-3"></div>
		</div>
	</c:forEach>
</section>

<%@ include file="footer.jsp"%>