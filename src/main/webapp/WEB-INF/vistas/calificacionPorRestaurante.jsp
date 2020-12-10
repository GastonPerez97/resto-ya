<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>

<div class="main-container">
	<h1 class="text-center h1 display-3 bebas mb-4">Calificaciones del restaurante:</h1>
	
	<section class="restaurantes">
		<c:forEach items="${calificacionRestaurante.restauranteModel.valor}" var="cal">
			<div class="d-flex justify-content-center align-items-center">
				<div class="card mb-3 restaurante shadow">
					<div class="row no-gutters">
						<div class="col-md-8">
							<div class="card-body">
								<span class="h4">NUMERO: </span>${cal.idCalificacionRestaurante}</p>
								<p class="card-text">
									<span class="h4">RESTAURANTE: </span>${cal.restauranteModel}
									
									<span class="h4">COMENTARIO: </span>${cal.comentario}</p>
									
							</div>
	
							<div class="card-body">
								<form action="consultarCalificacionRestaurante" class="form-inline" method="POST">
									<input type="hidden" value="${cal.idCalificacionRestaurante}" name="idCalificacionRestaurante"
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
</div>

<%@ include file="footer.jsp"%>