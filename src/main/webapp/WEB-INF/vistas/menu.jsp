<%@ include file="header.jsp"%>

<div class="main-container">
	<h1 class="text-center h1 display-3 bebas my-4">
        <i class="fas fa-utensils mr-3"></i> Men&uacute de "${restaurante.nombre}"
    </h1>

    <div class="mb-4 volver-btn d-flex justify-content-between">
        <a href="../restaurantes"><button type="button"
			class="btn btn-outline-secondary">Volver</button></a>
        <c:if test="${rol == 1}">
	        <a href="../agregarComida?idRestaurante=${restaurante.idRestaurante}">
	            <button type="button" class="btn btn-outline-success mr-3">
				<i class="far fa-plus-square mr-3"></i>Agregar Comida
			</button>
	        </a>
        </c:if>
    </div>

    <section class="comidas mx-auto">
        <c:forEach items="${COMIDAS}" var="COMIDA">
            <article class="card comida shadow d-flex flex-column justify-content-between">
                <div class="<c:if test="${COMIDA.disponible == false}">no-disponible</c:if>">
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

                        <p class="card-text">
                            <c:if test="${COMIDA.promedioCalificaciones == 1}">
                                <span class="card-text mr-2">Calificaci&oacute;n:</span>
                                <img class="calification-icon" src="img/calificaciones/tenedor.jpg">
                            </c:if>

                            <c:if test="${COMIDA.promedioCalificaciones == 2}">
                                <span class="card-text mr-2">Calificaci&oacute;n: </span>
                                <img class="calification-icon" src="/proyecto-limpio-spring-master/img/calificaciones/tenedor.jpg">
                                <img class="calification-icon" src="/proyecto-limpio-spring-master/img/calificaciones/tenedor.jpg">
                            </c:if>


                            <c:if test="${COMIDA.promedioCalificaciones == 3}">
                                <span class="card-text mr-2">Calificaci&oacute;n:</span>
                                <img class="calification-icon" src="/proyecto-limpio-spring-master/img/calificaciones/tenedor.jpg">
                                <img class="calification-icon" src="/proyecto-limpio-spring-master/img/calificaciones/tenedor.jpg">
                                <img class="calification-icon" src="/proyecto-limpio-spring-master/img/calificaciones/tenedor.jpg">
                            </c:if>

                            <c:if test="${COMIDA.promedioCalificaciones == 4}">
                                <span class="card-text mr-2">Calificaci&oacute;n: </span>
                                <img class="calification-icon" src="/proyecto-limpio-spring-master/img/calificaciones/tenedor.jpg">
                                <img class="calification-icon" src="/proyecto-limpio-spring-master/img/calificaciones/tenedor.jpg">
                                <img class="calification-icon" src="/proyecto-limpio-spring-master/img/calificaciones/tenedor.jpg">
                                <img class="calification-icon" src="/proyecto-limpio-spring-master/img/calificaciones/tenedor.jpg">
                            </c:if>

                            <c:if test="${COMIDA.promedioCalificaciones == 5}">
                                <span class="card-text mr-2">Calificaci&oacute;n:</span>
                                <img class="calification-icon" src="/proyecto-limpio-spring-master/img/calificaciones/tenedor.jpg">
                                <img class="calification-icon" src="/proyecto-limpio-spring-master/img/calificaciones/tenedor.jpg">
                                <img class="calification-icon" src="/proyecto-limpio-spring-master/img/calificaciones/tenedor.jpg">
                                <img class="calification-icon" src="/proyecto-limpio-spring-master/img/calificaciones/tenedor.jpg">
                                <img class="calification-icon" src="/proyecto-limpio-spring-master/img/calificaciones/tenedor.jpg">
                            </c:if>
                        </p>

                        <c:if test="${COMIDA.disponible == false}">
                            <h3>NO DISPONIBLE</h3>
                        </c:if>
                    </div>
                </div>

                <div class="d-flex justify-content-around align-items-center mb-3">
                    <c:if test="${rol == 1}">
	                    <a href="../editarComida?id=${COMIDA.idComida}"><i
							class="far fa-edit restaurante-btn"></i></a>
					</c:if>
					<c:if test="${rol == 2}">
	                    <form action="../nueva-calificacion-comida" class="form-inline" method="post">
	                        <input type="hidden" value="${COMIDA.idComida}" name="idComida" id="id-comida-input" />
	                        <div class="form-group <c:if test="${COMIDA.disponible == false}">no-disponible</c:if>">
	                            <input type="submit" id="calificacionComida-submit" value="Calificar" class="float-right btn btn-outline-danger" />
	                        </div>
	                    </form>
                    </c:if>
                </div>
            </article>
        </c:forEach>

        <a href="../hacerPedido?id=${restaurante.idRestaurante}" class="btn btn-outline-success btn-block mb-4">Realizar Pedido</a>
    </section>
</div>

<%@ include file="footer.jsp"%>