<%@ include file="header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center h1 display-3 bebas mb-4">Buscador de Restaurante:</h1>
<div class = "restaurantes">
	<div id="loginbox" style="margin-top:50px;" class="card-body">
	<form:form action="buscarRestaurante" method="POST"
		modelAttribute="restaurante">
		<hr class="colorgraph">
		<br>
		<form:input path="nombre" type="text" id="nombre" name="nombre"
			placeholder="Ingrese el nombre del Restaurante"
			class="form-control" />
		<br>
		<button class="float-right btn btn-dark" Type="Submit">Buscar</button>
	</form:form>
	</div>
</div>

<%@ include file="footer.jsp"%>