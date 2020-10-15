<%@ include file="header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section >
	<form:form action="procesarPedido" method="post" class="comidas-pedido mx-auto">
		<c:forEach items="${COMIDAS}" var="comida" varStatus="status">
			<article class="comida mx-auto" >
				<div>
				  <div class="card h-100 <c:if test="${comida.disponible == false}">no-disponible</c:if>">
					<img class="card-img-top" src="https://sevilla.abc.es/gurme/wp-content/uploads/sites/24/2012/01/comida-rapida-casera.jpg" alt="">
					<div class="card-body">
					  <h4 class="card-title">
						<a href="#">${comida.nombre}</a>
					  </h4>
					  <h5>$24.99</h5>
					  <p class="card-text">${comida.descripcion}</p>
					</div>
					<div class="card-footer">
					  <small class="text-muted">${comida.tipo} | Seleccionar: </small>
					  <c:if test="${comida.disponible == true}"><small><input type="checkbox" id="${comida.nombre}" value="${comida.idComida}"
						name="checkboxComidas" /></small></c:if>
					  <c:if test="${comida.disponible == false}"><small class="h5">NO DISPONIBLE</small></c:if>
					</div>
				  </div>
				</div>
			</article>
		</c:forEach>
		<input type="submit" value="Realizar el Pago" class="btn btn-primary btn-block" />
	</form:form>
</section>

<%@ include file="footer.jsp"%>