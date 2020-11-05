<%@ include file="header.jsp" %>

<h1 class="text-center h1 display-3 bebas mb-4">Listado de restaurantes:</h1>

<section class="restaurantes">
	<c:forEach items="${RESTAURANTES}" var="REST">
		<div class="card mb-3 restaurante mx-auto shadow <c:if test="${REST.disponible == false}">no-disponible</c:if>">
		  <div class="row no-gutters">
		    <div class="col-md-4 text-center my-auto">
		      <c:if test="${not empty REST.imageName}">
			  	<img src="img/restaurantes/${REST.imageName}" class="card-img img-restaurante">
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
		        <a href="restaurante/menu?id=${REST.idRestaurante}" class="float-left btn btn-dark">Ver Men&uacute</a>
		      </div>
     		  <div class="card-body">
		        <form action="reservar" class="form-inline" method="post">
		        	<input type="hidden" value="${REST.idRestaurante}" name="idRestaurante" id="id-restaurante-input"/>
		        	<div class="form-group">
		        		<input type="date" name="fechaReserva" id="fecha-reserva-input" class="col-8 form-control" <c:if test="${REST.disponible == false}">disabled</c:if>/>
		        		<input type="submit" id="reserva-submit" value="Reservar" class="float-right btn btn-dark" <c:if test="${REST.disponible == false}">disabled</c:if>/>
		        	</div>
		        </form>
		      </div>
		      <div class="card-body">
		        <form action="nueva-mesa" class="form-inline" method="post">
		        	<input type="hidden" value="${REST.idRestaurante}" name="idRestaurante" id="id-restaurante-input"/>
		        	<div class="form-group">
		        		<input type="submit" id="reserva-submit" value="Agregar mesa" class="float-right btn btn-dark"/>
		        	</div>
		        </form>
		        <form action="nuevo-horario" class="form-inline" method="post">
		        	<input type="hidden" value="${REST.idRestaurante}" name="idRestaurante" id="id-restaurante-input"/>
		        	<div class="form-group">
		        		<input type="submit" id="reserva-submit" value="Agregar horario" class="float-right btn btn-dark"/>
		        	</div>
		        </form>
		      </div>
		    </div>
		  </div>
		</div>
	</c:forEach>
</section>

<%@ include file="footer.jsp" %>