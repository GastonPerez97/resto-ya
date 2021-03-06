<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<div class="main-container">
	<h3 class="pedido-titulo">N?mero de pedido: ${pedido.idPedido} </h3>
	<h3 class="pedido-titulo">Fecha y hora de generaci?n: ${pedido.fechaPedido} </h3>
	<c:if test="${not empty pedido.fechaFinalizacionPedido}">
		<h3 class="pedido-titulo">Fecha de Finalizacion: ${pedido.fechaFinalizacionPedido}</h3>
	</c:if>
	<h3 class="pedido-titulo">Total: $${total} </h3> <br>
	
	<section class="pedido mx-auto">
	    <c:forEach items="${pedidoComidaList}" var="pedidoComida" varStatus="status">
	        <article class="pedido-flex">
	            <div class="pedido-detalle">
	                <p style="text-decoration-line: underline;">${pedidoComida.comidaModel.tipo}</p>
	                <p>${pedidoComida.comidaModel.nombre}</p>
	            </div>
	            <div class="pedido-detalle">Precio: $${pedidoComida.comidaModel.precio}</div>
	            <div class="pedido-detalle">Cantidad: ${pedidoComida.cantidad}</div>
	            <div>
	                <c:if test="${not empty pedidoComida.comidaModel.imageName}">
	                    <img src="img/comidas/${pedidoComida.comidaModel.imageName}" width="300" height="200">
	                </c:if>
	                <c:if test="${empty pedidoComida.comidaModel.imageName}">
	                    <img src="img/comidas/defaultComida.jpg" width="300" height="200">
	                </c:if>
	            </div>
	        </article>
	    </c:forEach>
	    
	    <button type="button" class="btn btn-outline-secondary mt-3" onclick="history.back()">Volver</button>
	</section>
</div>

<%@ include file="footer.jsp" %>