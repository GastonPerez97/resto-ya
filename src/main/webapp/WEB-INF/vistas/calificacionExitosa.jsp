<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>

<h2 class="text-center h1 display-3 bebas mb-4">¡Calificacion
	guardada!</h2>


<div class="mb-4 volver-btn">
	<a href="./restaurantes"><button type="button" class="btn btn-dark">Volver</button></a>
</div>

<div class="card-body">
	<form action="consultarCalificacionRestaurante" class="form-inline"	method="POST">
			<input type="submit" id="ver-pedidos-submit" value="verCalificacion"
				class="float-right btn btn-dark">
		</div>		
	</form>
	
	<%-- <c:forEach items="${calificacionRestaurante.restauranteModel}" var="cal">
	<div class="card-body">
							<span class="h4">NUMERO: </span>${cal.idCalificacionRestaurante}</p>
							<p class="card-text">
								<span class="h4">RESTAURANTE: </span>${cal.restauranteModel}
								
								<span class="h4">COMENTARIO: </span>${cal.comentario}</p>
								
						</div>
	</c:forEach>
	
</div>
 --%>
<%@ include file="footer.jsp"%>