<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="header.jsp"%>

<h1 class="text-center h1 display-3 bebas mb-4">¡TU calificación ha
	sido guardada!</h1>

<section class="restaurantes">
	<c:forEach items="${calificacion}" var="res">
		<div class="d-flex justify-content-center align-items-center">
			<div class="card mb-3 restaurante shadow">
				<div class="row no-gutters">
					<div class="col-md-8">
						<div class="card-body">
							<h2 class="card-title bebas">${res.restauranteModel.nombre}</h2>
							<p class="card-text">
								<span class="h4">Calificacion N°: </span>${res.idCalificacionRestaurante}</p>
							<p class="card-text">
								<span class="h4">Calificacion: </span>${res.calificacionModel.idCalificacion}</p>
							<p class="card-text">
								<span class="h4">Comentario: </span>${res.comentario}</p>
								<a href="./restaurantes"><button type="button"
								class="btn btn-dark">Volver</button></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="d-flex flex-column ml-3"></div>
	</c:forEach>
</section>



<%@ include file="footer.jsp"%>