<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container">
			<div style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				
				<%-- Usando PathVariable (al cambiar el path no encuentra la carpeta css y js) 
				<form onsubmit="miFuncion()" id="miForm" method="POST">
			    	<h3 class="form-signin-heading">Taller Web I</h3>
					<hr class="colorgraph"><br>

					<input name="nombre" id="nombre" type="text" placeholder="Nombre" class="form-control" style="margin-bottom:10px;">
					<input name="apellido" id="apellido" type="text" placeholder="Apellido" class="form-control">     		  
					
					<button class="btn btn-lg btn-primary btn-block" style="margin-top:20px;" Type="submit">Enviar</button>
				</form>
				--%>
				
				<%-- Usando RequestParam: --%>
				<form action="saludar" method="GET">
			    	<h3 class="form-signin-heading">Taller Web I</h3>
					<hr class="colorgraph"><br>

					<input path="nombraco" name="nombre" id="nombre" type="text" placeholder="Nombre" class="form-control" style="margin-bottom:10px;">
					<input name="apellido" id="apellido" type="text" placeholder="Apellido" class="form-control">     		  
					
					<button class="btn btn-lg btn-primary btn-block" style="margin-top:20px;" Type="submit">Enviar</button>
				</form>


			</div>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<script>
			function miFuncion() {
				var action = "http://localhost:8080/proyecto-limpio-spring/saludar/"
				+ document.getElementById("nombre").value + "/"
				+ document.getElementById("apellido").value;
				
				var form = document.getElementById("miForm");
				
				form.action = action;
			}
		</script>
	</body>
</html>
