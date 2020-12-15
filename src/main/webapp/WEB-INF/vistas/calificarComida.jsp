<%@ include file="header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1 class="text-center h1 display-3 bebas mb-4">Calificar Comida</h1>

${calificacionComida.comidaModel.idComida.valor}
<section class="mx-auto col-lg-6" style="width: 80%;">
	<div class="mb-4">
		<a href="./restaurantes"><button type="button"
				class="btn btn-outline-dark">Volver</button></a>
	</div>
	<div class="text-center">
		<label for="nombreDeUsuario" class="h4 mb-3">Calific&aacute:</label>
		<c:forEach items="${formularioCalificacionComida.valor}" var="CAL">

		</c:forEach>
		<button id="boton-image1" class="img-calificacion-btn">
			<img src="img/calificaciones/tenedor.jpg" id="teneder01"
				class="img-calificacion">
		</button>
		<button id="boton-image2" class="img-calificacion-btn">
			<img src="img/calificaciones/tenedor.jpg" id="teneder02"
				class="img-calificacion">
		</button>
		<button id="boton-image3" class="img-calificacion-btn">
			<img src="img/calificaciones/tenedor.jpg" id="teneder03"
				class="img-calificacion">
		</button>
		<button id="boton-image4" class="img-calificacion-btn">
			<img src="img/calificaciones/tenedor.jpg" id="teneder04"
				class="img-calificacion">
		</button>
		<button id="boton-image5" class="img-calificacion-btn">
			<img src="img/calificaciones/tenedor.jpg" id="teneder05"
				class="img-calificacion">
		</button>
	</div>

	<div class="restaurantes">
		<div id="loginbox" style="margin-top: 50px;" class="card-body">
			<form:form action="guardado-calificacion-comida" method="POST"
				modelAttribute="formularioCalificacionComida">
				<hr class="colorgraph">
				<br>
				<div class="form-group">

					<form:hidden path="calificacionComida.comidaModel.idComida"
						value="${calificacionComida.comidaModel.idComida}" />
					<label for="nombreDeUsuario">Ingresa un comentario:</label>
					<div class="form-row">
						<form:input path="calificacionComida.comentario"
							id="calificacionComida.comentario" class="form-control" />
						<br>
					</div>
					<form:input type="hidden"
						path="calificacionComida.calificacionModel.idCalificacion"
						value="" id="id-calificacion" />
					<br> <input type="submit" id="calificar-submit"
						value="Calificar" class="float-right btn btn-dark" />
				</div>


			</form:form>
		</div>
	</div>
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
