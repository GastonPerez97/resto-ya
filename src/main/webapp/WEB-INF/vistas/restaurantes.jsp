<%@ include file="header.jsp" %>

<h1 class="text-center h1 display-3 bebas mb-4">Listado de restaurantes:</h1>

<section class="restaurantes">
    <div class="mx-auto mb-4" style="width: 75%;">
        <form action="agregarRestaurante" method="POST">
            <input type="submit" class="float-right btn btn-dark" value="Agregar Restaurante">
        </form>
    </div>

    <c:forEach items="${RESTAURANTES}" var="REST">
        <div class="d-flex justify-content-center align-items-center">
            <div class="card mb-3 restaurante shadow <c:if test=" ${REST.disponible==false} ">no-disponible</c:if>">
                <div class="row no-gutters">
                    <div class="col-md-4 text-center my-auto">
                        <c:if test="${not empty REST.imageName}">
                            <img src="img/restaurantes/${REST.imageName}" class="card-img img-restaurante img-fluid">
                        </c:if>
                        <c:if test="${empty REST.imageName}">
                            <img src="img/restaurantes/defaultRestaurante.jpg" class="card-img">
                        </c:if>
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h2 class="card-title bebas">${REST.nombre}</h2>
                            <p class="card-text"><span class="h4">Direcci&oacuten: </span>${REST.direccion}</p>
                            <p class="card-text"><span class="h4">Horario: </span>${REST.horario}</p>
                            <p class="card-text"><span class="h4">Telefono: </span>${REST.telefono}</p>
                            <a href="restaurante/menu?id=${REST.idRestaurante}" class="float-right btn btn-dark
								<c:if test=" ${REST.disponible==false} ">disabled</c:if>">Ver Men&uacute</a>
                            <c:if test="${REST.disponible == false}">
                                <h2>NO DISPONIBLE</h2>
                            </c:if>
                        </div>
                        <div class="card-body">
                            <form action="reservar" class="form-inline" method="post">
                                <input type="hidden" value="${REST.idRestaurante}" name="idRestaurante" id="id-restaurante-input" />
                                <div class="form-group">
                                    <input type="date" name="fechaReserva" id="fecha-reserva-input" class="col-8 form-control" required="required"<c:if test="${REST.disponible == false}">disabled</c:if>/>
                                    <input type="submit" id="reserva-submit" value="Reservar" class="float-right btn btn-dark" <c:if test="${REST.disponible == false}">disabled</c:if>/>
                                </div>
                            </form>
                        </div>
                        <div class="card-body">
                            <form action="nueva-mesa" class="form-inline" method="post">
                                <input type="hidden" value="${REST.idRestaurante}" name="idRestaurante" id="id-restaurante-input" />
                                <div class="form-group">
                                    <input type="submit" id="reserva-submit" value="Agregar mesa" class="float-right btn btn-dark" />
                                </div>
                            </form>
                            <form action="nuevo-horario" class="form-inline" method="post">
                                <input type="hidden" value="${REST.idRestaurante}" name="idRestaurante" id="id-restaurante-input" />
                                <div class="form-group">
                                    <input type="submit" id="reserva-submit" value="Agregar horario" class="float-right btn btn-dark" />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="d-flex flex-column ml-3">
            <a href="agregarComida?idRestaurante=${REST.idRestaurante}"><i class="far fa-plus-square restaurante-btn my-3"></i></a>
            <a href="editarRestaurante?id=${REST.idRestaurante}"><i class="far fa-edit restaurante-btn my-3"></i></a>
            <a href="eliminarRestaurante?id=${REST.idRestaurante}" class="delete-btn"><i class="far fa-trash-alt restaurante-btn my-3"></i></a>
        </div>
      </div>

        

    </c:forEach>
</section>

<%@ include file="footer.jsp" %>