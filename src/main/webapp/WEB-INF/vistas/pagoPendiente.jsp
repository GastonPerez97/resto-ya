<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<div class="main-container">
	<h2 class="text-center h1 display-3 bebas mb-4">Tu pago esta pendiente en estos momentos</h2>
	
	<p class="text-center bebas h2">Usa este numero de referencia para poder realizar el pago:</p>
	
	<h3 class="text-center h1 display-3 bebas mb-4">${nroReferencia}</h3>
	
	<section class="comidas mx-auto">
		<a class="nav-link btn btn-dark" href="/proyecto-limpio-spring-master/restaurantes">Volver a buscar</a>
	</section>
</div>

<%@ include file="footer.jsp" %>