<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ include file="header.jsp" %>

        <h3 class="pedido-titulo">Número de pedido: ${pedido.idPedido} </h3> <br>
        <h3 class="pedido-titulo">Fecha y hora de generación: ${pedido.fechaPedido} </h3> <br>
        <c:if test="${not empty pedido.fechaFinalizacionPedido}">
			<h3 class="pedido-titulo">Fecha de Finalizacion: ${pedido.fechaFinalizacionPedido}</h3> <br>
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
                    <div class="pedido-detalle">Cantidad: $${pedidoComida.cantidad}</div>
                    <div>
                        <c:if test="${not empty comida.imageName}">
                            <img src="img/comidas/${comida.imageName}" width="300" height="200">
                        </c:if>
                        <c:if test="${empty comida.imageName}">
                            <img src="img/comidas/defaultComida.jpg" width="300" height="200">
                        </c:if>
                    </div>
                </article><br>
            </c:forEach>
        </section>

        <%@ include file="footer.jsp" %>