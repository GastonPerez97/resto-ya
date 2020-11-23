<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ include file="header.jsp" %>

        <h3 class="pedido-titulo">Su Número Identificador de Pedido es: ${idPedido} </h3> <br>
        <section class="pedido mx-auto">
            <c:forEach items="${pedidoComidaList}" var="pedidoComida" varStatus="status">
                <article class="pedido-flex">
                    <div class="pedido-detalle">
                        <p style="text-decoration-line: underline;">${pedidoComida.comidaModel.tipo}</p>
                        <p>${pedidoComida.comidaModel.nombre}</p>

                    </div>
                    <div class="pedido-detalle">Precio: $${pedidoComida.comidaModel.precio}</div>
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
            <p>Pedido realizado a las ${hora} hs.</p>
            <p>Te enviamos un mail de confirmacion a ${email}</p>
            <p>Podes pagar en efectivo o con Mercado Pago utilizando el boton de abajo.</p>

			<div class="d-flex justify-content-around mt-4">
            	<a href="/proyecto-limpio-spring-master/restaurantes" class="btn btn-dark">Volver a Restaurantes</a>
            	
                <form:form action="pagar" method="post">
                	<input type="submit" value="Pagar" class="btn btn-primary" />
            	</form:form>
			</div>
        </section>

        <%@ include file="footer.jsp" %>