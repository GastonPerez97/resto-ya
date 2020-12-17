<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="header.jsp"%>

<div class="main-container">
	<h1 class="text-center h1 display-3 bebas mb-4">¡TU calificación ha	sido guardada!</h1>
	
	<section class="restaurantes">
		<div class="mx-auto mb-4 d-flex justify-content-end" style="width: 80%;">
        	<a href="./restaurantes" class="btn btn-outline-secondary">Volver</a>
        </div>
						
		<c:forEach items="${calificacion}" var="res">
			<div class="d-flex justify-content-center align-items-center">
				<div class="card mb-3 restaurante shadow">
					<div class="row no-gutters">
						<div class="col-md-8">
							<div class="card-body">
								<h2 class="card-title bebas">${res.restauranteModel.nombre}</h2>
								<p class="card-text">
									<span class="h4">Calificación N°: </span>${res.idCalificacionRestaurante}</p>
	
								<c:if test="${res.calificacionModel.idCalificacion == 1}">
									<span class="h4">Calificación: </span>
									<img class="calification-icon"
										src="img/calificaciones/tenedor.jpg">
								</c:if>
	
								<c:if test="${res.calificacionModel.idCalificacion == 2}">
									<span class="h4">Calificación: </span>
									<img class="calification-icon"
										src="img/calificaciones/tenedor.jpg">
									<img class="calification-icon"
										src="img/calificaciones/tenedor.jpg">
								</c:if>
	
	
								<c:if test="${res.calificacionModel.idCalificacion == 3}">
									<span class="h4">Calificación: </span>
									<img class="calification-icon"
										src="img/calificaciones/tenedor.jpg">
									<img class="calification-icon"
										src="img/calificaciones/tenedor.jpg">
									<img class="calification-icon"
										src="img/calificaciones/tenedor.jpg">
								</c:if>
	
								<c:if test="${res.calificacionModel.idCalificacion == 4}">
									<span class="h4">Calificación: </span>
									<img class="calification-icon"
										src="img/calificaciones/tenedor.jpg">
									<img class="calification-icon"
										src="img/calificaciones/tenedor.jpg">
									<img class="calification-icon"
										src="img/calificaciones/tenedor.jpg">
									<img class="calification-icon"
										src="img/calificaciones/tenedor.jpg">
								</c:if>
	
								<c:if test="${res.calificacionModel.idCalificacion == 5}">
									<span class="h4">Calificación: </span>
									<img class="calification-icon"
										src="img/calificaciones/tenedor.jpg">
									<img class="calification-icon"
										src="img/calificaciones/tenedor.jpg">
									<img class="calification-icon"
										src="img/calificaciones/tenedor.jpg">
									<img class="calification-icon"
										src="img/calificaciones/tenedor.jpg">
									<img class="calification-icon"
										src="img/calificaciones/tenedor.jpg">
								</c:if>
	
	
								<p class="card-text mt-2">
									<span class="h4">Comentario: </span>${res.comentario}</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="d-flex flex-column ml-3"></div>
		</c:forEach>
	</section>
</div>


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