<%@ include file="header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center h1 display-3 bebas mb-4"><i class="fas fa-utensils mr-3"></i> ¡Reserva tu lugar!</h1>
<section class="mx-auto" style="width:80%;">
	<div class = "restaurantes">
		<div id="loginbox" style="margin-top:50px;" class="card-body">
			<h3>${restaurante.nombre}</h3>
			<form:form action="confirmar-reserva" method="POST" modelAttribute="reserva">
				<%--<form:hidden path = "restauranteHorarioModel.idRestaurante" values = "${restaurante.idRestaurante}"/>--%>
				<div class="form-group">
				  	<label>Horario</label>
					<form:select id="id-horarios" path="restauranteHorarioModel.idRestauranteHorario">
						<c:forEach items="${restaurante.restauranteHorarioList}" var="horario">
					    	<form:option value="${horario.idRestauranteHorario}">${horario.horarioModel.horario}</form:option>
						</c:forEach>
					</form:select>
				  </div>
				<input type="submit" class="float-right btn btn-dark" value="Reservar"/>
			</form:form>
		</div>
	</div>
</section>

<%@ include file="footer.jsp" %>