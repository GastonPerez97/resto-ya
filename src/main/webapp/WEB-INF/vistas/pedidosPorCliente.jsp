<%@ include file="header.jsp"%>

    <h1 class="text-center h1 display-3 bebas my-4">Historico de pedidos</h1>

    <section class="comidas mx-auto">
        <c:forEach items="${pedidoModel}" var="pedido">
            <article class="card comida shadow">

                <div class="card-body d-flex flex-column justify-content-between">
	                <div>
	                    <p><span class="h4"><b>Numero de pedido: </b></span>${pedido.idPedido}</p>
	                    <p><span class="h4"><b>Restaurante: </b></span>${pedido.restaurante.nombre}</p>
	                    <p><span class="h4"><b>Fecha: </b></span>${pedido.fechaPedido}</p>
	                    <p><span class="h4"><b>Direccion: </b></span>${pedido.restaurante.direccion}</p>
	                    <p><span class="h4"><b>Estado: </b></span>${pedido.estadoPedidoModel.nombreEstado}</p>
	                </div>
					<div class="d-flex justify-content-around">
	                    <form action="detalle-pedido" class="form-inline" method="post">
	                        <input type="hidden" value="${pedido.idPedido}" name="idPedido" id="id-restaurante-input" />
	                        <div class="form-group">
	                            <input type="submit" id="reserva-submit" value="Ver detalle" class="float-right btn btn-dark" />
	                        </div>
	                    </form>
	                    
	                    <form action="generarReclamo" class="form-inline" method="post">
	                        <input type="hidden" value="${pedido.idPedido}" name="idPedido" id="idPedido" />
	                        <div class="form-group">
	                            <input type="submit" id="reclamo-submit" value="Hacer un reclamo" class="float-right btn btn-dark" />
	                        </div>
	                    </form>
					</div>
                </div>
            </article>
        </c:forEach>
    </section>
    </div>

    <%@ include file="footer.jsp"%>