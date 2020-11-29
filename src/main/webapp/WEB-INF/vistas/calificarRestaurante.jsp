<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>

<h1 class="text-center h1 display-3 bebas mb-4">Calificar
	Restaurante</h1>


<section class="restaurantes">
	<div class="mx-auto mb-4" style="width: 75%;">
		<form action="guardado-calificacion" method="POST">
			<input type="submit" class="float-right btn btn-dark"
				value="Calificar">
		</form>
	</div>
	<div class="mb-4 volver-btn">
		<a href="./restaurantes"><button type="button"
				class="btn btn-dark">Volver</button></a>
	</div>


	<div class="form-row">

		<c:forEach items="${calificacionModel}" var="CALIFICACION">

			<c:if test="${not empty CALIFICACION.imagenNombre}">
				<img src="img/calificaciones/${CALIFICACION.imagenNombre}"
					class="card-img img-restaurante img-fluid">
			</c:if>

		</c:forEach>

	</div>


	<%-- 	<form:form action="guardado-calificacion" method="POST"
			modelAttribute="calificacion" enctype="multipart/form-data">
			<div class="form-row">
			
			<input type="hidden" value="${idCalificacion}" name="idRestaurante" id="id-restaurante-input" />
				<div class="form-group col-md-6">
					<label for="nombre">Comentario:</label>
					<form:input path="comentario" id="nombre" class="form-control" />
				</div>
			</div>

			<div class="form-group mt-5 text-center">
				<button type="submit" class="btn btn-dark mx-auto">Calificar</button>
			</div>
		</form:form>
		
	</article>
</section>
 --%>
	<%@ include file="footer.jsp"%>