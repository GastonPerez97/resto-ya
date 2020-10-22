<%@ include file="header.jsp" %>

<h1 class="text-center h1 display-3 bebas mb-4"><i class="fas fa-utensils mr-3"></i> Listado de comidas</h1>

<section class="comidas mx-auto">
	<c:forEach items="${resultadoBusqueda.listaComidas}" var="resultado">
		<article class="card comida shadow">
	  		<img src="https://sevilla.abc.es/gurme/wp-content/uploads/sites/24/2012/01/comida-rapida-casera.jpg" class="card-img-top" alt="IMAGEN DE DB">
	  		<div class="card-body">
	  		    <h3 class="card-title bebas">${resultado.nombre}</h3>
	  		    <h5>${resultado.tipo}</h5>
	 			<p class="card-text">${resultado.descripcion}</p>
			</div>
		</article>
	</c:forEach>
	<a class="nav-link" href="/proyecto-limpio-spring-master/home">Volver a buscar</a>
</section>

<%@ include file="footer.jsp" %>