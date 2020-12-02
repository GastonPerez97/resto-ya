<%@ include file="header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1 class="text-center h1 display-3 bebas mb-4">Calificar
	Restaurante</h1>

<section class="mx-auto" style="width: 80%;">
	<div class="restaurantes">
		<div id="loginbox" style="margin-top: 50px;" class="card-body">


			<form:form action="guardado-calificacion" method="POST"
				modelAttribute="formularioCalificacion">
				<hr class="colorgraph">
				<br>
				<div class="form-group"></div>

				<c:forEach items="${calificacion}" var="CAL">
					<c:if test="${not empty CAL.valor}">
						<img src="img/calificaciones/tenedor.jpg" class="img-calificacion">
						<input type="image" src="img/calificaciones/tenedor.jpg"
							class="img-calificacion" id="idCalificacion">
					</c:if>

				</c:forEach>

				<div class="form-group">
					<form:hidden path="cliente.idCliente" value="${cliente.idCliente}" />

					<form:hidden path="restaurante.idRestaurante"
						value="${restaurante.idRestaurante}" />

					<form:input path="calificacion.comentario" id="comentario"
						class="form-control" required="true" />
					<br> <input type="submit" id="calificar-submit"
						value="Calificar" class="float-right btn btn-dark" />
				</div>
			</form:form>
		</div>
	</div>
</section>

<div class="mb-4 volver-btn">
	<a href="./restaurantes"><button type="button" class="btn btn-dark">Volver</button></a>
</div>



<%@ include file="footer.jsp"%>
