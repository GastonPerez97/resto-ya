<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>

<h1 class="text-center h1 display-3 bebas mb-4">Calificar
	Restaurante</h1>

<section class="restaurantes">
	<div class="img-calificacion">
		<c:forEach items="${calificacionModel}" var="CALIFICACION">
			<c:if test="${not empty CALIFICACION.imageName}">
				<img src="img/calificaciones/${CALIFICACION.imageName}"
					class="img-calificacion">
				<img src="img/calificaciones/${CALIFICACION.imageName}"
					class="img-calificacion">
			</c:if>
		</c:forEach>
	</div>
</section>




		

<%@ include file="footer.jsp"%>