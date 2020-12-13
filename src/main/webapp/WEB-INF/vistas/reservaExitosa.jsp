<%@ include file="header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="main-container">
	<section class="mx-auto" style="width:80%;">
		<div class = "restaurantes">
			<div id="loginbox" style="margin-top:50px;" class="mx-auto">
				<h2 class="mb-4"><b>Tu numero de reserva es: </b>${reserva.numeroDeReserva}</h2>
			
				<h3><b>Restaurante: </b>${reserva.restauranteHorarioModel.restauranteModel.nombre}</h3>
				<h3><b>Fecha reserva: </b>${reserva.fechaReserva} - ${reserva.restauranteHorarioModel.horarioModel.horario}</h3>
				<h3><b>Reserva para: </b>${reserva.mesaModel.cantidad} personas</h3>
				
			</div>
		</div>
	</section>
</div>

<%@ include file="footer.jsp" %>