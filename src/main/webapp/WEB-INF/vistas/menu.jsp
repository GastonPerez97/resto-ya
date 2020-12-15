<%@ include file="header.jsp"%>

<h1 class="text-center h1 display-3 bebas mb-4">
	<i class="fas fa-utensils mr-3"></i> Men&uacute de
	"${restaurante.nombre}"
</h1>

<div class="mb-4 volver-btn d-flex justify-content-between">
	<a href="../restaurantes"><button type="button"
			class="btn btn-dark">Volver</button></a> <a
		href="../agregarComida?idRestaurante=${restaurante.idRestaurante}">
		<button type="button" class="btn btn-dark mr-3">
			<i class="far fa-plus-square mr-3"></i>Agregar Comida
		</button>
	</a>
</div>

<section class="comidas mx-auto">
	<c:forEach items="${COMIDAS}" var="COMIDA">
		<article
			class="card comida shadow d-flex flex-column justify-content-between">
			<div
				class="<c:if test="${COMIDA.disponible == false}">no-disponible</c:if>">
				<c:if test="${not empty COMIDA.imageName}">
					<img src="../img/comidas/${COMIDA.imageName}"
						class="card-img-top img-comida">
				</c:if>
				<c:if test="${empty COMIDA.imageName}">
					<img src="../img/comidas/defaultComida.jpg"
						class="card-img-top img-comida">
				</c:if>
				<div class="card-body">
					<h3 class="card-title bebas">${COMIDA.nombre}</h3>
					<h5>${COMIDA.tipo}</h5>
					<p class="card-text">${COMIDA.descripcion}</p>
					
					<p class="card-text">
					<c:if test="${COMIDA.promedioCalificaciones == 1}">
							<span class="card-text">Calificación: </span>
							<img class="location-icon rounded"
								src="img/calificaciones/tenedor.jpg">
						</c:if>

						<c:if test="${COMIDA.promedioCalificaciones == 2}">
							<span class="card-text">Calificación: </span>
							<img class="location-icon rounded"
								src="img/calificaciones/tenedor.jpg">
							<img class="location-icon rounded"
								src="img/calificaciones/tenedor.jpg">
						</c:if>


						<c:if test="${COMIDA.promedioCalificaciones == 3}">
							<span class="card-text">Calificación: </span>
							<img class="location-icon rounded"
								src="img/calificaciones/tenedor.jpg">
							<img class="location-icon rounded"
								src="img/calificaciones/tenedor.jpg">
							<img class="location-icon rounded"
								src="img/calificaciones/tenedor.jpg">
						</c:if>

						<c:if test="${COMIDA.promedioCalificaciones == 4}">
							<span class="card-text">Calificación: </span>
							<img class="location-icon rounded"
								src="img/calificaciones/tenedor.jpg">
							<img class="location-icon rounded"
								src="img/calificaciones/tenedor.jpg">
							<img class="location-icon rounded"
								src="img/calificaciones/tenedor.jpg">
							<img class="location-icon rounded"
								src="img/calificaciones/tenedor.jpg">
						</c:if>

						<c:if test="${COMIDA.promedioCalificaciones == 5}">
							<span class="card-text">Calificación: </span>
							<img class="location-icon rounded"
								src="img/calificaciones/tenedor.jpg">
							<img class="location-icon rounded"
								src="img/calificaciones/tenedor.jpg">
							<img class="location-icon rounded"
								src="img/calificaciones/tenedor.jpg">
							<img class="location-icon rounded"
								src="img/calificaciones/tenedor.jpg">
							<img class="location-icon rounded"
								src="img/calificaciones/tenedor.jpg">
						</c:if>
					</p>

					<c:if test="${COMIDA.disponible == false}">
						<h3>NO DISPONIBLE</h3>
					</c:if>
				</div>
			</div>

			<div class="d-flex justify-content-around">
				<a href="../editarComida?id=${COMIDA.idComida}"><i
					class="far fa-edit restaurante-btn mb-3"></i></a> <a
					href="../eliminarComida?id=${COMIDA.idComida}"
					class="delete-btn-comida"><i
					class="far fa-trash-alt restaurante-btn mb-3"></i></a>
					<div class="col-3">
						<br>
						<form action="../nueva-calificacion-comida" class="form-inline"
							method="post">
							<input type="hidden" value="${COMIDA.idComida}" name="idComida"
								id="id-comida-input" />
							<div class="form-group">
								<input type="submit" id="calificacionComida-submit"
									value="Calificar" class="float-right btn btn-dark" />
							</div>
						</form>
				</div>


			</div>
		</article>
	</c:forEach>

	<a href="../hacerPedido?id=${restaurante.idRestaurante}"
		class="btn btn-primary btn-block">Realizar Pedido</a>
</section>

<%@ include file="footer.jsp"%>