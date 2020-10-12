<%@ include file="header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section >
	<form:form action="procesarPedido" method="post" class="comidas-pedido mx-auto">
		<c:forEach items="${COMIDAS}" var="comida" varStatus="status">
			<article class="comida mx-auto" >
				<div>
				  <div class="card h-100">
					<c:if test="${not empty comida.imageName}">
						<img src="img/comidas/${comida.imageName}" class="card-img-top img-comida">
				    </c:if>
				    <c:if test="${empty comida.imageName}">
				    	<img src="img/comidas/defaultComida.jpg" class="card-img-top img-comida">
				    </c:if>
					<div class="card-body">
					  <h4 class="card-title">
						<a href="#">${comida.nombre}</a>
					  </h4>
					  <h5>$24.99</h5>
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