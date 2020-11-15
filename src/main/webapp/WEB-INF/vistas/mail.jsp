<%@ include file="header.jsp" %>

<h1 class="text-center h1 display-3 bebas mb-4">Enviar mail</h1>

<section class="my-5 col-4 mx-auto">
	<form action="enviarMail" method="POST">
		<div class="form-group text-center">
			<input type="email" name="email" placeholder="Ingresar E-Mail" class="form-control">
			<button type="submit" class="btn btn-primary mt-4">Enviar Mail de confirmación</a>	
		</div>
	</form>
</section>

<%@ include file="footer.jsp" %>