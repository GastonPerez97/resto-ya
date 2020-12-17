<%@ include file="header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="main-container">
	<h1 class="text-center h1 display-3 bebas mb-4">Restaurantes Encontrados:</h1>
	
	<section class="comidas mx-auto">
		<c:forEach items="${RESTAURANTES}" var="RESTO">
			<article class="card comida shadow">
				<c:if test="${not empty RESTO.imageName}">
			  		<img src="img/restaurantes/${RESTO.imageName}" style="height: 252px; object-fit: cover;" class="card-img-top">
		        </c:if>
		        <c:if test="${empty RESTO.imageName}">
		      		<img src="img/restaurantes/defaultRestaurante.jpg" class="card-img-top">
		        </c:if>
				<div class="card-body">
					<h2 class="card-title bebas">${RESTO.nombre}</h2>
					<p class="card-text"><span class="h4">Direcci&oacuten: </span>${RESTO.direccion}</p>
			        <p class="card-text"><span class="h4">Horario: </span>${RESTO.horario}</p>
			        <p class="card-text"><span class="h4">Telefono: </span>${RESTO.telefono}</p>
				</div>
			</article>
		</c:forEach>
	</section>
	<div class="text-center">
		<form:form action="home" method="get">
			<button class="btn btn-outline-secondary" type="submit">Volver a buscar</button>
		</form:form>
	</div>
</div>

<%@ include file="footer.jsp"%>