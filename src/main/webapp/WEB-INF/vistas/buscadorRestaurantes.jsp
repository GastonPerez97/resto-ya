<%@ include file="header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	
	<h1 class="text-center h1 display-3 bebas mb-4">Buscador de Restaurante:</h1>
	<body>
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

			<%--Bloque que es visible si el elemento error no está vacío	--%>
				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>	
			</div>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
