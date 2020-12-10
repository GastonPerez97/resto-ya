<%@ include file="header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="main-container">
	<h1 class="text-center h1 display-3 bebas mb-4"><i class="fas fa-utensils mr-3"></i> Nuevo Horario</h1>
	<section class="mx-auto" style="width:80%;">
		<div class = "restaurantes">
			<div id="loginbox" style="margin-top:50px;" class="card-body">
				<h3>${restaurante.nombre}</h3>
				<form:form action="guardar-nuevo-horario" method="POST" modelAttribute="formularioNuevoHorario">
					<form:hidden path = "idRestaurante" value = "${restaurante.idRestaurante}"/>
					<div class="form-group">
					  	<label>Horario:</label>
						<form:select id="horarios-select" path="idHorario" required="required">
							<c:forEach items="${horarios}" var="horario">
						    	<form:option value="${horario.idHorario}">${horario.horario}</form:option>
							</c:forEach>
						</form:select>
					</div>
					<input type="submit" class="float-right btn btn-dark" value="Guardar"/>
				</form:form>
			</div>
		</div>
	</section>
</div>

<%@ include file="footer.jsp" %>