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
		        <a href="restaurante/menu?id=${REST.idRestaurante}" class="float-right btn btn-dark
		        <c:if test="${REST.disponible == false}">disabled</c:if>">Ver Men&uacute</a>
		        <c:if test="${REST.disponible == false}"><h2>NO DISPONIBLE</h2></c:if>
		      </div>
		    </div>
		  </div>
		</div>
	</c:forEach>
</section>

<%@ include file="footer.jsp" %>