<%@ include file="header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<section class="mx-auto" style="width:80%;">
	<div class = "restaurantes">
		<div id="loginbox" style="margin-top:50px;" class="card-body">
			<h2>Tu numero de reserva es: ${reserva.idReserva}</h2>
		
			<h3>${reserva.restauranteHorarioModel.restauranteModel.nombre}</h3>
			<h3>${reserva.fechaReserva} - ${reserva.restauranteHorarioModel.horarioModel.horario}</h3>
				
		</div>
	</div>
</section>

<%@ include file="footer.jsp" %>