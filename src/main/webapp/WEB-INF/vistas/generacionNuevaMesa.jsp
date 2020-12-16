<%@ include file="header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="main-container">
	<h1 class="text-center h1 display-3 bebas mb-4"><i class="fas fa-utensils mr-3"></i> Nueva mesa</h1>
	<section class="mx-auto" style="width:50%;">
		<div class = "restaurantes">
			<div id="loginbox" style="margin-top:30px;" class="mx-auto">
				<h3>${restaurante.nombre}</h3>
				<form:form action="guardar-nueva-mesa" method="POST" modelAttribute="formularioNuevaMesa">
					<p class="text-danger">${error}</p>
					<form:hidden path = "idRestaurante" value = "${restaurante.idRestaurante}"/>
					<div class="form-inline mb-3 d-flex justify-content-between align-items-center">
					  	<label class="h5 mr-2">Número de mesa:</label>
						<form:input path = "numeroDeMesa" type="text" class="form-control-lg col-2"/>
						
						<label class="h5 mr-2">Cantidad de comensales:</label>
						<form:input path = "cantidad" type="text" class="form-control-lg col-2"/>
					</div>
					<div class="form-inline mb-3 d-flex justify-content-between align-items-center">
						<label class="h5 mr-2">Número de fila:</label>
						<form:input path = "ubicacionFila" type="number" class="form-control-lg col-2"/>
						
						<label class="h5 mr-2">Número de columna:</label>
						<form:input path = "ubicacionColumna" type="number" class="form-control-lg col-2"/>
					</div>
					<input type="submit" class="float-right btn btn-outline-danger" value="Guardar"/>
				</form:form>
			</div>
		</div>
	</section>
</div>

<%@ include file="footer.jsp" %>