<%@ include file="header.jsp" %>

<h1 class="text-center h1 display-3 bebas mb-4"><i class="fas fa-utensils mr-3"></i> Men&uacute de "${restaurante.nombre}"</h1>

<section class="comidas mx-auto">
	<c:forEach items="${COMIDAS}" var="COMIDA">
		<article class="card comida shadow">
	  		<img src="https://sevilla.abc.es/gurme/wp-content/uploads/sites/24/2012/01/comida-rapida-casera.jpg" class="card-img-top" alt="IMAGEN DE DB">
	  		<div class="card-body">
	  		    <h3 class="card-title bebas">${COMIDA.nombre}</h3>
	  		    <h5>${COMIDA.tipo}</h5>
	 			<p class="card-text">${COMIDA.descripcion}</p>
			</div>
		</article>
	</c:forEach>
</section>

<%@ include file="footer.jsp" %>