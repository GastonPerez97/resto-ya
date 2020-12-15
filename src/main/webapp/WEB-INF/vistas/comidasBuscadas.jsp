<%@ include file="header.jsp" %>

<div class="main-container">
	<h1 class="text-center h1 display-3 bebas mb-4"><i class="fas fa-utensils mr-3"></i> Listado de comidas</h1>
	
	<section class="comidas mx-auto">
		<c:forEach items="${resultadoBusqueda.listaComidas}" var="resultado">
			<article class="card comida shadow">
		  		<c:if test="${not empty resultado.imageName}">
					<img src="img/comidas/${resultado.imageName}" class="card-img img-restaurante">
			    </c:if>
			    <c:if test="${empty resultado.imageName}">
			    	<img src="img/comidas/defaultComida.jpg" class="card-img">
			    </c:if>
		  		<div class="card-body">
		  		    <h3 class="card-title bebas">${resultado.nombre}</h3>
		  		    <h5>${resultado.tipo}</h5>
		 			<p class="card-text">${resultado.descripcion}</p>
				</div>
			</article>
		</c:forEach>
	</section>
	<div class="text-center">
		<a class="btn btn-dark" href="/proyecto-limpio-spring-master/home">Volver a buscar</a>
	</div>
</div>

<%@ include file="footer.jsp" %>