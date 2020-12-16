<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="header.jsp"%>

<h1 class="text-center h1 display-3 bebas mb-4">¡TU calificación ha
	sido guardada!</h1>

<section class="restaurantes">
	<c:forEach items="${calificacion}" var="comida">
		<div class="d-flex justify-content-center align-items-center">
			<div class="card mb-3 restaurante shadow">
				<div class="row no-gutters">
					<div class="col-md-8">
						<div class="card-body">
							<h2 class="card-title bebas">${comida.comidaModel.nombre}</h2>
							<p class="card-text">
								<span class="h4">Calificación N°: </span>${comida.idCalificacionComida}</p>

							<c:if test="${comida.calificacionModel.idCalificacion == 1}">
								<span class="h4">Calificación: </span>
								<img class="location-icon rounded"
									src="img/calificaciones/tenedor.jpg">
							</c:if>

							<c:if test="${comida.calificacionModel.idCalificacion == 2}">
								<span class="h4">Calificación: </span>
								<img class="location-icon rounded"
									src="img/calificaciones/tenedor.jpg">
								<img class="location-icon rounded"
									src="img/calificaciones/tenedor.jpg">
							</c:if>


							<c:if test="${comida.calificacionModel.idCalificacion == 3}">
								<span class="h4">Calificación: </span>
								<img class="location-icon rounded"
									src="img/calificaciones/tenedor.jpg">
								<img class="location-icon rounded"
									src="img/calificaciones/tenedor.jpg">
								<img class="location-icon rounded"
									src="img/calificaciones/tenedor.jpg">
							</c:if>

							<c:if test="${comida.calificacionModel.idCalificacion == 4}">
								<span class="h4">Calificación: </span>
								<img class="location-icon rounded"
									src="img/calificaciones/tenedor.jpg">
								<img class="location-icon rounded"
									src="img/calificaciones/tenedor.jpg">
								<img class="location-icon rounded"
									src="img/calificaciones/tenedor.jpg">
								<img class="location-icon rounded"
									src="img/calificaciones/tenedor.jpg">
							</c:if>

							<c:if test="${comida.calificacionModel.idCalificacion == 5}">
								<span class="h4">Calificación: </span>
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


							<p class="card-text">
								<span class="h4">Comentario: </span>${comida.comentario}</p>
							<a href="./restaurantes"><button type="button"
									class="btn btn-outline-secondary">Volver</button></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="d-flex flex-column ml-3"></div>
	</c:forEach>
</section>

<script>
	$('#id-calificacion').attr('value', "1");
	$('#boton-image1').click(function() {
		$('#id-calificacion').attr('value', "1");
		$('#teneder01').attr('src', "img/calificaciones/tenedor verde.jpg");
		$('#teneder02').attr('src', "img/calificaciones/tenedor.jpg");
		$('#teneder03').attr('src', "img/calificaciones/tenedor.jpg");
		$('#teneder04').attr('src', "img/calificaciones/tenedor.jpg");
		$('#teneder05').attr('src', "img/calificaciones/tenedor.jpg");

	});

	$('#boton-image2').click(function() {
		$('#id-calificacion').attr('value', "2");
		$('#teneder01').attr('src', "img/calificaciones/tenedor verde.jpg");
		$('#teneder02').attr('src', "img/calificaciones/tenedor verde.jpg");
		$('#teneder03').attr('src', "img/calificaciones/tenedor.jpg");
		$('#teneder04').attr('src', "img/calificaciones/tenedor.jpg");
		$('#teneder05').attr('src', "img/calificaciones/tenedor.jpg");

	});
	$('#boton-image3').click(function() {
		$('#id-calificacion').attr('value', "3");
		$('#teneder01').attr('src', "img/calificaciones/tenedor verde.jpg");
		$('#teneder02').attr('src', "img/calificaciones/tenedor verde.jpg");
		$('#teneder03').attr('src', "img/calificaciones/tenedor verde.jpg");
		$('#teneder04').attr('src', "img/calificaciones/tenedor.jpg");
		$('#teneder05').attr('src', "img/calificaciones/tenedor.jpg");
	});
	$('#boton-image4').click(function() {
		$('#id-calificacion').attr('value', "4");
		$('#teneder01').attr('src', "img/calificaciones/tenedor verde.jpg");
		$('#teneder02').attr('src', "img/calificaciones/tenedor verde.jpg");
		$('#teneder03').attr('src', "img/calificaciones/tenedor verde.jpg");
		$('#teneder04').attr('src', "img/calificaciones/tenedor verde.jpg");
		$('#teneder05').attr('src', "img/calificaciones/tenedor.jpg");

	});

	$('#boton-image5').click(function() {
		$('#id-calificacion').attr('value', "5");
		$('#teneder01').attr('src', "img/calificaciones/tenedor verde.jpg");
		$('#teneder02').attr('src', "img/calificaciones/tenedor verde.jpg");
		$('#teneder03').attr('src', "img/calificaciones/tenedor verde.jpg");
		$('#teneder04').attr('src', "img/calificaciones/tenedor verde.jpg");
		$('#teneder05').attr('src', "img/calificaciones/tenedor verde.jpg");
	});
</script>

<%@ include file="footer.jsp"%>