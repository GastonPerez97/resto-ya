<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>

<h1 class="text-center h1 display-3 bebas mb-4">Calificar
	Restaurante</h1>

<section class="restaurantes"></section>


<section class="comidas mx-auto">
	<article class="card comida shadow">

		<div class="card-body">
			<div class="img-calificacion"></div>
			<h3 class="card-title bebas">
				<form action="guardado-calificacion" class="form-inline"
					method="post">

					<c:forEach items="${calificacionModel}" var="CALIFICACION">
						<c:if test="${not empty CALIFICACION.imageName}">
							<%-- <img src="img/calificaciones/${CALIFICACION.imageName}"
							class="img-calificacion"> --%>
							<input type="image"
								src="img/calificaciones/${CALIFICACION.imageName}"
								class="img-calificacion" id="idCalificacion">
						</c:if>

						<br>
						<input type="hidden" value="${calificacion.idCalificacion}"
							name="idCalificacion" id="idCalificacion" />
					</c:forEach>

					<input type="hidden"
						value="${calificacion.restaurante.idRestaurante}"
						name="idRestaurante" id="idRestaurante" /> <input type="text"
						value="Ingrese su comentario" name="comentario" id="" />

					<div class="form-group">
						<br> <input type="submit" id="calificar-submit"
							value="Calificar" class="float-right btn btn-dark" />
					</div>
				</form>
			</h3>
		</div>
	</article>

</section>

<div class="mb-4 volver-btn">
	<a href="./restaurantes"><button type="button" class="btn btn-dark">Volver</button></a>
</div>

<script>
	$(document).ready(function() {
		$('.calificar-submit').click(function() {
			var imageName = $('.img-calificacion').val();
			alert(imageName);
		});
	});
</script>
<%@ include file="footer.jsp"%>