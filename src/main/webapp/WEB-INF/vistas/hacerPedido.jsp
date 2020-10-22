<%@ include file="header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section >
	<form:form action="procesarPedido" method="post" modelAttribute="formularioPedido" class="comidas-pedido mx-auto">
		<form:hidden path="restaurante" value="${formularioPedido.restaurante}"/>
		<c:forEach items="${COMIDAS}" var="comida" varStatus="status">
			<article class="comida mx-auto" >
				<div>
				  <div class="card h-100">
					<img class="card-img-top" src="https://sevilla.abc.es/gurme/wp-content/uploads/sites/24/2012/01/comida-rapida-casera.jpg" alt="">
					<div class="card-body">
					  <h4 class="card-title">
						<p style="color:#047cfc;">${comida.nombre}</p>
					  </h4>
					  <h5>$${comida.precio}</h5>
					  <p class="card-text">${comida.descripcion}</p>
					</div>
					<div class="card-footer">
					  <small class="text-muted">${comida.tipo} | Seleccionar: </small>
					  <small><input type="checkbox" id="${comida.nombre}" value="${comida.idComida}"
						name="checkboxComidas" /></small>
					</div>
				  </div>
				</div>
			</article>
		</c:forEach>
		<input type="submit" value="Realizar el Pago" class="btn btn-primary btn-block" />
	</form:form>
	
</section>

<%@ include file="footer.jsp"%>