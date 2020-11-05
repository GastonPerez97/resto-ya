<%@ include file="header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center h1 display-3 bebas mb-4"><i class="fas fa-utensils mr-3"></i> ¡Reserva tu lugar!</h1>
<section class="mx-auto" style="width:80%;">
	<div class = "restaurantes">
		<div id="loginbox" style="margin-top:50px;" class="card-body">
			<h3>${restaurante.nombre}</h3>
			<form:form action="confirmar-reserva" method="POST" modelAttribute="formularioGeneracionReserva">
				<form:hidden path = "idRestaurante" value = "${restaurante.idRestaurante}"/>
				<form:hidden path = "fechaReserva" value = "${formularioGeneracionReserva.fechaReserva}" id="fecha-reserva"/>
				<div class="form-group">
				  	<label>Cantidad de comensales:</label>
					<form:select id="mesas-select" path="idMesa" required="required">
						<option value="0">---</option>
						<c:forEach items="${mesas}" var="mesa">
					    	<form:option value="${mesa.idMesa}">${mesa.cantidad}</form:option>
						</c:forEach>
					</form:select>
					<form:select id="horarios-select" path="idRestauranteHorario" required="required">
					</form:select>
				</div>
				<input type="submit" class="float-right btn btn-dark" value="Reservar"/>
			</form:form>
		</div>
	</div>
</section>
<script>
$(document).ready(function(){
	$("#mesas-select").on('change', function(){
		var fechaReserva = $('#fecha-reserva').val();
		var idMesa = $(this).val();
		$("#horarios-select").empty();

		if(idMesa != 0) {
			$.ajax({
				type : "POST",
				//contentType : "application/json",
				url : "get-horarios-mesa",
				data : 'fechaReserva=' + fechaReserva + '&idMesa=' + idMesa,
				//dataType : 'json',				
				success : function(list) {
					$.each(list, function(index, data){
						$("#horarios-select").append("<option value='" + data.idRestauranteHorario + "'>" + data.horario + "</option>");
					});
				}
			});
		}
	});
});
</script>

<%@ include file="footer.jsp" %>