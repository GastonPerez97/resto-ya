<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<h3 class="pedido-titulo">Mi pedido:</h3>
<section class="pedido mx-auto">
	<c:forEach items="${Comidas}" var="comida" varStatus="status">
		<article class="pedido-flex">
			<div class="pedido-detalle">${comida.nombre}</div> 
			<div>
				<c:if test="${not empty comida.imageName}">
					<img src="img/comidas/${comida.imageName}" width="300" height="200">
			    </c:if>
			    <c:if test="${empty comida.imageName}">
			    	<img src="img/comidas/defaultComida.jpg" width="300" height="200">
			    </c:if>
			</div>
		</article><br>
	</c:forEach>
	<form:form action="pagar" method="post" class="comidas-pedido mx-auto">
		<input type="submit" value="Pagar" class="btn btn-primary btn-block" />
	</form:form>
</section>

<%@ include file="footer.jsp" %>