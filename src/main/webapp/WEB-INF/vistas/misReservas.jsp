<%@ include file="header.jsp"%>

    <h1 class="text-center h1 display-3 bebas mb-4">Hist�rico de pedidos
    </h1>

    <section class="comidas mx-auto">
        <c:forEach items="${reservas}" var="reserva">
            <article class="card comida shadow">

                <div class="card-body">
                    <h3 class="card-title bebas">N�mero de pedido: ${reserva.numeroDeReserva}</h3>
                    <h3 class="card-title bebas">Restaurante: ${reserva.fechaReserva}</h3>
                    <h3 class="card-title bebas">
                        <form action="detalle-pedido" class="form-inline" method="post">
                            <input type="hidden" value="${reserva.numeroDeReserva}" name="idPedido" id="id-restaurante-input" />
                            <div class="form-group">
                                <input type="submit" id="reserva-submit" value="Ver detalle" class="float-right btn btn-dark" />
                            </div>
                        </form>
                    </h3>
                    <form action="generarReclamo" class="form-inline" method="post">
                        <input type="hidden" value="${reserva.numeroDeReserva}" name="idPedido" id="idPedido" />
                        <div class="form-group">
                            <input type="submit" id="reclamo-submit" value="Hacer un reclamo" class="float-right btn btn-dark" />
                        </div>
                </div>
            </article>
        </c:forEach>
    </section>
    </div>

    <%@ include file="footer.jsp"%>