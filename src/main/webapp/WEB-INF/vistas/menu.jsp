<%@ include file="header.jsp" %>

<h1 class="text-center h1 display-3 bebas mb-4"><i class="fas fa-utensils mr-3"></i> Men&uacute de "${restaurante.nombre}"</h1>

<div class="mb-4 volver-btn">
	<a href="../restaurantes"><button type="button" class="btn btn-dark">Volver</button></a>
</div>

<section class="comidas mx-auto">
	<c:forEach items="${COMIDAS}" var="COMIDA">
		<article class="card comida shadow">
			<c:if test="${not empty COMIDA.imageName}">
				<img src="../img/comidas/${COMIDA.imageName}" class="card-img-top img-comida">
		    </c:if>
		    <c:if test="${empty COMIDA.imageName}">
		    	<img src="../img/comidas/defaultComida.jpg" class="card-img-top img-comida">
		    </c:if>
	  		<div class="card-body">
	  		    <h3 class="card-title bebas">${COMIDA.nombre}</h3>
	  		    <h5>${COMIDA.tipo}</h5>
	 			<p class="card-text">${COMIDA.descripcion}</p>
			</div>
		</article>
	</c:forEach>
	<a href="../hacerPedido?id=${restaurante.idRestaurante}" class="btn btn-primary btn-block">Procesar Pedido</a>
</section>

<%@ include file="footer.jsp" %>