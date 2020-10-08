<%@ include file="header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1 class="text-center h1 display-3 bebas mb-4">Resultado de la búsqueda:</h1>

<section class="comidas mx-auto">
	<c:forEach items="${restaurantes}" var="RESTO">
		<article class="card comida shadow">
			<div class="card-body">
				<h2 class="card-title bebas">${RESTO.nombre}</h2>
				<p class="card-text"><span class="h4">Direcci&oacuten: </span>${RESTO.direccion}</p>
		        <p class="card-text"><span class="h4">Horario: </span>${RESTO.horario}</p>
		        <p class="card-text"><span class="h4">Telefono: </span>${RESTO.telefono}</p>
			</div>
		</article>
	</c:forEach>

	<form:form action="buscarRestaurantes" method="get">
		<button class="float-right btn btn-dark" type="submit">Volver</button>
	</form:form>
</section>

<%@ include file="footer.jsp"%>