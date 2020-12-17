<%@ include file="header.jsp"%>

    <div class="main-container">
        <h1 class="text-center h1 display-3 bebas mb-4 mt-4">Listado de restaurantes:</h1>

        <section class="restaurantes">
        	<c:if test="${rol == 1}">
	            <div class="mx-auto mb-4" style="width: 75%;">
	                <form action="agregarRestaurante" method="POST">
	                    <div class="float-right rounded d-flex align-items-center agregar-rest-btn">
	                        <i class="far fa-plus-square ml-3 mr-1"></i>
	                        <input type="submit" class="btn verde" value="Agregar Restaurante">
	                    </div>
	                </form>
	            </div>
			</c:if>
            <c:forEach items="${RESTAURANTES}" var="REST">
                <div class="d-flex justify-content-center align-items-center">
                    <div class="card mb-3 restaurante shadow <c:if test="${REST.disponible == false}">no-disponible</c:if>">
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
                                    <h2 class="card-title"><span class="bebas">${REST.nombre} </span>
                                        <a href="restaurante/menu?id=${REST.idRestaurante}" class="float-right btn btn-outline-primary">Ver Men&uacute</a>
                                        <c:if test="${rol == 1}">
	                                        <a href="pedidosPorRestaurante?id=${REST.idRestaurante}" class="float-right btn btn-outline-primary mr-2">Ver Pedidos</a>
	                                        <a href="restaurante/reservas?idRestaurante=${REST.idRestaurante}" class="float-right btn btn-outline-primary mr-2">Ver Reservas</a>
                                    	</c:if>
                                    </h2>
                                    <p class="card-text">
                                        <span class="h4">Direcci&oacuten: </span>${REST.direccion}
                                        <c:if test="${not empty REST.urlMaps}">
                                            <a href="${REST.urlMaps}" target="_blank" class="ml-1"> <img class="location-icon rounded" src="img/restaurantes/Localizacion.png">
                                            </a>
                                        </c:if>
                                    </p>
                                    <p class="card-text">
                                        <span class="h4">Horario: </span>${REST.horario}</p>
                                    <p class="card-text">
                                        <span class="h4">Tel&eacutefono: </span>${REST.telefono}</p>
                                    <p class="card-text">
                                        <c:if test="${REST.promedioCalificaciones == 1}">
                                            <span class="h4">Calificaci&oacute;n: </span>
                                            <img class="calification-icon" src="img/calificaciones/tenedor.jpg">
                                        </c:if>

                                        <c:if test="${REST.promedioCalificaciones == 2}">
                                            <span class="h4">Calificaci&oacute;n: </span>
                                            <img class="calification-icon" src="img/calificaciones/tenedor.jpg">
                                            <img class="calification-icon" src="img/calificaciones/tenedor.jpg">
                                        </c:if>


                                        <c:if test="${REST.promedioCalificaciones == 3}">
                                            <span class="h4">Calificaci&oacute;n:</span>
                                            <img class="calification-icon" src="img/calificaciones/tenedor.jpg">
                                            <img class="calification-icon" src="img/calificaciones/tenedor.jpg">
                                            <img class="calification-icon" src="img/calificaciones/tenedor.jpg">
                                        </c:if>

                                        <c:if test="${REST.promedioCalificaciones == 4}">
                                            <span class="h4">Calificaci&oacute;n: </span>
                                            <img class="calification-icon" src="img/calificaciones/tenedor.jpg">
                                            <img class="calification-icon" src="img/calificaciones/tenedor.jpg">
                                            <img class="calification-icon" src="img/calificaciones/tenedor.jpg">
                                            <img class="calification-icon" src="img/calificaciones/tenedor.jpg">
                                        </c:if>

                                        <c:if test="${REST.promedioCalificaciones == 5}">
                                            <span class="h4">Calificaci&oacute;n: </span>
                                            <img class="calification-icon" src="img/calificaciones/tenedor.jpg">
                                            <img class="calification-icon" src="img/calificaciones/tenedor.jpg">
                                            <img class="calification-icon" src="img/calificaciones/tenedor.jpg">
                                            <img class="calification-icon" src="img/calificaciones/tenedor.jpg">
                                            <img class="calification-icon" src="img/calificaciones/tenedor.jpg">
                                        </c:if>
                                    </p>

									<c:if test="${rol == 2}">
	                                    <form action="nueva-calificacion" class="form-inline" method="post">
	                                        <input type="hidden" value="${REST.idRestaurante}" name="idRestaurante" id="id-restaurante-input" />
	                                        <div class="form-group">
	                                            <input type="submit" id="reserva-submit" value="Calificar" class="btn btn-outline-danger" />
	                                        </div>
	                                    </form>
									</c:if>
                                    <c:if test="${REST.disponible == false}">
                                        <h2 class="mt-3">NO DISPONIBLE</h2>
                                    </c:if>
                                </div>
                            </div>
                        </div>

                        <div class="card-body">
                            <div class="row">
                                <c:if test="${rol == 2}">
	                                <div class="col-5">
	                                    <form action="reservar" class="form-inline" method="post">
	                                        <input type="hidden" value="${REST.idRestaurante}" name="idRestaurante" id="id-restaurante-input" />
	                                        <div class="form-group">
	                                            <input type="date" name="fechaReserva" id="fecha-reserva-input" class="col-8 form-control" required="required" <c:if test="${REST.disponible == false}">disabled</c:if> /> <input type="submit" id="reserva-submit"
	                                                value="Reservar" class="float-right btn btn-outline-danger" <c:if test="${REST.disponible == false}">disabled</c:if> />
	                                        </div>
	                                    </form>
	                                </div>
                                </c:if>
                                <c:if test="${rol == 1}">
	                                <div class="col-3 border-right">
	                                    <form action="nueva-mesa" class="form-inline" method="post">
	                                        <input type="hidden" value="${REST.idRestaurante}" name="idRestaurante" id="id-restaurante-input" />
	                                        <div class="form-group">
	                                            <input type="submit" id="reserva-submit" value="Agregar mesa" class="float-right btn btn-outline-success" />
	                                        </div>
	                                    </form>
	                                </div>
	                                <div class="col-3">
	                                    <form action="nuevo-horario" class="form-inline" method="post">
	                                        <input type="hidden" value="${REST.idRestaurante}" name="idRestaurante" id="id-restaurante-input" />
	                                        <div class="form-group">
	                                            <input type="submit" id="reserva-submit" value="Agregar horario" class="float-right btn btn-outline-success" />
	                                        </div>
	                                    </form>
	                                </div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                    <c:if test="${rol == 1}">
	                    <div class="d-flex flex-column ml-3">
	                        <a href="agregarComida?idRestaurante=${REST.idRestaurante}"><i
							class="far fa-plus-square restaurante-btn my-3"></i></a> <a href="editarRestaurante?id=${REST.idRestaurante}"><i
							class="far fa-edit restaurante-btn my-3"></i></a> 
	                    </div>
                    </c:if>
                </div>

            </c:forEach>
        </section>
    </div>

<script>
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1;
	var yyyy = today.getFullYear();
	if(dd<10){
	  dd='0'+dd
	} 
	if(mm<10){
	  mm='0'+mm
	} 
	
	today = yyyy+'-'+mm+'-'+dd;
	document.getElementById("fecha-reserva-input").setAttribute("min", today);
</script>

    <%@ include file="footer.jsp"%>
