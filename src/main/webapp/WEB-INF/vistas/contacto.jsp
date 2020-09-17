<%@ include file="header.jsp" %>

	<main>
		<h1>Contacto</h1>
		<form action="mostrarConfirmacion">
			<label for="nombre">Nombre: </label>
			<input type="text" id="nombre" name="nombre">
			
			<label for="apellido">Apellido: </label>
			<input type="text" id="apellido" name="apellido">
			
			<input type="submit" value="Enviar">
		</form>
	</main>

<%@ include file="footer.jsp" %>