<%@ include file="header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <h1 class="text-center h1 display-3 bebas mb-4">Reservas de ${restaurante.nombre}
    </h1>

    <section class="comidas mx-auto">
    	
    	<div class="main-container">
    		<h2>Buscar reservas</h2>
            <form action="reservas" method="post">
	             <input type="hidden" value="${restaurante.idRestaurante}" name="idRestaurante" id="idRestaurante" />
	             <div class="form-group row">
	             	 <label class="col-2 col-form-label">Desde:</label>
	             	 <div class="col-4">   
			             <input type="date" name="fechaDesde" id="fecha-desde" class="form-control" required="required" />
		             </div>
	             	 <label class="col-2 col-form-label">Hasta:</label>
	             	 <div class="col-4">   
			             <input type="date" name="fechaHasta" id="fecha-hasta" class="form-control" required="required" />
		             </div>
	             </div>
	             <div class="form-group row">
       				<label class="col-2 col-form-label">Desde:</label>
	             	<div class="col-4">
						<select id="estados-select" required="required" class="form-control" name="idEstadoReserva">
							<c:forEach items="${estados}" var="estado">
							   	<option value="${estado.idEstadoReserva}">${estado.nombreEstado}</option>
							</c:forEach>
						</select>
					</div>
				</div>
	             <div class="form-group">
	                 <input type="submit" id="reclamo-submit" value="Buscar" class="float-left btn btn-dark" />
	             </div>
            </form>
    	</div>
    
    	<div class="d-flex justify-content-between flex-wrap">
	        <c:forEach items="${reservas}" var="reserva">
	            <article class="card comida shadow d-flex flex-column justify-content-between">
	                <div class="card-body">
	                    <h3 class="card-title bebas">N° de reserva: ${reserva.numeroDeReserva}</h3>
	                    <h3 class="card-title bebas">Fecha: ${reserva.fechaReserva}</h3>
	                    <h3 class="card-title bebas">Estado: ${reserva.estadoReservaModel.nombreEstado}</h3>
	
						<div class="row d-flex justify-content-around align-items-center">
							<form action="../reserva/modificarEstado" class="form-inline" method="post">
			                    <input type="hidden" value="${reserva.numeroDeReserva}" name="idReserva" id="idReserva" />
			                    <input type="hidden" value="${restaurante.idRestaurante}" name="idRestaurante" id="idRestaurante" />
			                    <input type="hidden" value="${fechaDesde}" name="fechaDesde" id="fecha-desde" class="form-control" required="required" />
			                    <input type="hidden" value="${fechaHasta}" name="fechaHasta" id="fecha-hasta" class="form-control" required="required" />
			                    <input type="hidden" value="2" name="idEstadoReserva" id="id-estado" class="form-control" required="required" />
			                    <div class="form-group">
			                        <button class="btn btn-success"><i class="fa fa-check" aria-hidden="true"></i></button>
			                    </div>
		                    </form>
		                    <form action="../reserva/modificarEstado" class="form-inline" method="post">
			                    <input type="hidden" value="${reserva.numeroDeReserva}" name="idReserva" id="idReserva" />
			                    <input type="hidden" value="${restaurante.idRestaurante}" name="idRestaurante" id="idRestaurante" />
			                    <input type="hidden" value="${fechaDesde}" name="fechaDesde" id="fecha-desde" class="form-control" required="required" />
			                    <input type="hidden" value="${fechaHasta}" name="fechaHasta" id="fecha-hasta" class="form-control" required="required" />
			                    <input type="hidden" value="3" name="idEstadoReserva" id="id-estado" class="form-control" required="required" />
			                    <div class="form-group">
			                        <button class="btn btn-danger"><i class="fa fa-times" aria-hidden="true"></i></button>
			                    </div>
		                    </form>
	                    </div>
	                </div>
	            </article>
	        </c:forEach>
        </div>
    </section>

    <%@ include file="footer.jsp"%>