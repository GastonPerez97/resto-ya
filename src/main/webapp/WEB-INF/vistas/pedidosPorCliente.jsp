<%@ include file="header.jsp" %>

<h1 class="text-center h1 display-3 bebas mb-4"> Histórico de pedidos</h1>

<section class="comidas mx-auto">
	<c:forEach items="${pedidoModel.listaComidas}" var="pedido">
		<article class="card comida shadow">
	  		<c:if test="${not empty pedido.imageName}">
				<img src="img/comidas/${pedido.imageName}" class="card-img img-restaurante">
		    </c:if>
		    <c:if test="${empty resultado.imageName}">
		    	<img src="img/comidas/defaultComida.jpg" class="card-img">
		    </c:if>
	  		<div class="card-body">
	  		    <h3 class="card-title bebas">${pedido.idPedido}</h3>
	  		    <h5>${pedido.restaurante}</h5>
	  		    <h3 class="card-title bebas">${pedido.clienteModel}</h3>
	 			<p class="card-text">${resultado.descripcion}</p>
			</div>
		</article>
	</c:forEach>
	<a class="nav-link" href="/proyecto-limpio-spring-master/historicoPedidos">Volver a buscar</a>
</section>

<%@ include file="footer.jsp" %>