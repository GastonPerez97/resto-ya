<%@ include file="header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<section class="mx-auto" style="width:80%;">
	<div class = "restaurantes">
		<div id="loginbox" style="margin-top:50px;" class="card-body">
			<h2>Generaste la mesa #${mesa.numeroDeMesa}</h2>
			<h3>Para ${mesa.cantidad} comensales</h3>
		</div>
	</div>
</section>

<%@ include file="footer.jsp" %>