<%@ include file="header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1 class="text-center h1 display-3 bebas mb-4">Calificar
	Restaurante</h1>


<section class="mx-auto col-lg-6" style="width: 80%;">

	<c:forEach items="${formularioCalificacion.valor}" var="CAL">

	</c:forEach>
	<button id="boton-image1" class="img-calificacion">
		<img src="img/calificaciones/tenedor.jpg" width="13" height="13">
	</button>
	<button id="boton-image2" class="img-calificacion">
		<img src="img/calificaciones/tenedor.jpg" width="13" height="13">
	</button>
	<button id="boton-image3" class="img-calificacion">
		<img src="img/calificaciones/tenedor.jpg" width="13" height="13">
	</button>
	<button id="boton-image4" class="img-calificacion">
		<img src="img/calificaciones/tenedor.jpg" width="13" height="13">
	</button>
	<button id="boton-image5" class="img-calificacion">
		<img src="img/calificaciones/tenedor.jpg" width="13" height="13">
	</button>

	<div class="restaurantes">
		<div id="loginbox" style="margin-top: 50px;" class="card-body">
			<form:form action="guardado-calificacion" method="POST"
				modelAttribute="formularioCalificacion">
				<hr class="colorgraph">
				<br>
				<div class="form-group">

					<form:hidden path="cliente.idCliente" value="${cliente.idCliente}" />
					<form:hidden
						path="calificacionRestaurante.restauranteModel.idRestaurante"
						value="${calificacionRestaurante.restauranteModel.idRestaurante}" />
					<label for="nombreDeUsuario">Ingresa un comentario y una calificacion:*</label>
					<div class="form-row">
						<form:input path="calificacionRestaurante.comentario"
							id="calificacionRestaurante.comentario" class="form-control" />
						<br>
					</div>
					<form:input type="hidden"
						path="calificacionRestaurante.calificacionModel.idCalificacion"
						value="" id="id-calificacion" />
						<br>
					<input type="submit" id="calificar-submit" value="Calificar"
						class="float-right btn btn-dark" />
				</div>


			</form:form>
		</div>
	</div>
</section>

<div class="mb-4 volver-btn">
	<a href="./restaurantes"><button type="button" class="btn btn-dark">Volver</button></a>
</div>

<script>
	$('#boton-image1').click(function() {
		$('#id-calificacion').attr('value', "1");

	});

	$('#boton-image2').click(function() {
		$('#id-calificacion').attr('value', "2");

	});
	$('#boton-image3').click(function() {
		$('#id-calificacion').attr('value', "3");

	});
	$('#boton-image4').click(function() {
		$('#id-calificacion').attr('value', "4");

	});

	$('#boton-image5').click(function() {
		$('#id-calificacion').attr('value', "5");
	});
</script>



<%@ include file="footer.jsp"%>
