<%@ include file="header.jsp" %>

<h3 class="pedido-titulo">Mi pedido:</h3>
<section class="pedido mx-auto">
	<c:forEach items="${Comidas}" var="comida" varStatus="status">
		<article class="pedido-flex">
			<div class="pedido-detalle">${comida.nombre}</div> 
			<div><img src="https://sevilla.abc.es/gurme/wp-content/uploads/sites/24/2012/01/comida-rapida-casera.jpg" alt="comida"
					width="300" height="200"></div>
		</article><br>
	</c:forEach>
	<input type="submit" value="Pagar" class="btn btn-primary btn-block" />
</section>

<%@ include file="footer.jsp" %>