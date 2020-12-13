<%@ include file="header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="main-container">
	<section class="mx-auto" style="width:50%;">
		<div class="text-center">
			<h1 class="bebas display-4 mb-4 col-9 mx-auto">Ingresar Nro de Referencia de Mercado Pago</h1>
			<h4 class="mb-4">${error}</h4>
			
			<form action="/proyecto-limpio-spring-master/finalizar-pedido/nro-referencia" method="post">
				<input type="hidden" value="${idPedido}" name="idPedido" />
				<div class="form-group">
					<input type="number" placeholder="Nro de Referencia" name="nroReferencia" class="form-control-lg col-6">
				</div>
				<input type="submit" value="Enviar" class="btn btn-dark mt-2" />
			</form>
		</div>
	</section>
</div>

<%@ include file="footer.jsp" %>