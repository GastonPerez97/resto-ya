<%@ include file="header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <section class="comidas mx-auto">
        	<div class="main-container">
        	<h1 class="text-center h1 display-3 bebas mb-4">Historico de pedidos</h1>
	        	<c:forEach items="${reservas}" var="reserva">
		            <article class="card comida shadow d-flex flex-column justify-content-between">
		                <div class="card-body">
		                    <h4 class="card-title"><b>N° de reserva: </b>${reserva.numeroDeReserva}</h4>
		                    <h4 class="card-title"><b>Fecha: </b>${reserva.fechaReserva}</h4>
		                    <h4 class="card-title"><b>Estado: </b>${reserva.estadoReservaModel.nombreEstado}</h4>
							<c:if test="${reserva.estadoReservaModel.idEstadoReserva == 1}">
								<div class="row d-flex justify-content-around align-items-center">
									<form action="../reserva/modificarMiReserva" class="form-inline" method="post">
					                    <input type="hidden" value="${reserva.numeroDeReserva}" name="idReserva" id="idReserva" />
					                    <input type="hidden" value="2" name="idEstadoReserva" id="id-estado" class="form-control" required="required" />
					                    <div class="form-group">
					                        <button class="btn btn-success"><i class="fa fa-check" aria-hidden="true"></i></button>
					                    </div>
				                    </form>
				                    <form action="../reserva/modificarMiReserva" class="form-inline" method="post">
					                    <input type="hidden" value="${reserva.numeroDeReserva}" name="idReserva" id="idReserva" />
					                    <input type="hidden" value="3" name="idEstadoReserva" id="id-estado" class="form-control" required="required" />
					                    <div class="form-group">
					                        <button class="btn btn-danger"><i class="fa fa-times" aria-hidden="true"></i></button>
					                    </div>
				                    </form>
			                    </div>
		                	</c:if>
		                </div>
		            </article>
		        </c:forEach>
	        </div>
    </section>

    <%@ include file="footer.jsp"%>