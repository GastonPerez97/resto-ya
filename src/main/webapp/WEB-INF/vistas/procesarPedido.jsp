<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ include file="header.jsp" %>

        <div class="main-container">
            <h3 class="pedido-titulo">Su Numero Identificador de Pedido es: ${idPedido} </h3> <br>

            <section class="pedido mx-auto">
                <form:form action="pagar" method="post">
                    <c:forEach items="${pedidoComidaList}" var="pedidoComida" varStatus="status">
                        <input type="hidden" name="comidas" value="${pedidoComida.comidaModel.nombre}">
                        <input type="hidden" name="cantidades" value="${pedidoComida.cantidad}">
                        <input type="hidden" name="precios" value="${pedidoComida.comidaModel.precio}">

                        <article class="pedido-flex">
                            <div class="pedido-detalle">
                                <p style="text-decoration-line: underline;">${pedidoComida.comidaModel.tipo}</p>
                                <p>${pedidoComida.comidaModel.nombre}</p>

                            </div>
                            <div class="pedido-detalle">Precio: $${pedidoComida.comidaModel.precio}</div>
                            <div>
                                <c:if test="${not empty pedidoComida.comidaModel.imageName}">
                                    <img src="img/comidas/${pedidoComida.comidaModel.imageName}" width="300" height="200">
                                </c:if>
                                <c:if test="${empty pedidoComida.comidaModel.imageName}">
                                    <img src="img/comidas/defaultComida.jpg" width="300" height="200">
                                </c:if>
                            </div>
                        </article><br>
                    </c:forEach>
                    <p class="h5">Fecha de realizacion del pedido: ${hora} hs.</p>
                    <p class="h5">Te enviamos un mail de confirmacion a tu casilla.</p>
                    <p class="h5">Podes pagar en efectivo o con Mercado Pago utilizando el boton de abajo.</p>

                    <div class="d-flex justify-content-around mt-4">
                        <input type="submit" value="Pagar con Mercado Pago" class="btn btn-outline-success" />

                        <a href="/proyecto-limpio-spring-master/restaurantes" class="btn btn-outline-secondary">Volver a Restaurantes</a>
                    </div>
                </form:form>
            </section>
        </div>

        <%@ include file="footer.jsp" %>