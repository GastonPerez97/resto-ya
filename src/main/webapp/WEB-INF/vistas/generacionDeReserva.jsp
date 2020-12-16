<%@ include file="header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<style>
.radio-img {
	background-image:url(https://previews.123rf.com/images/djvstock/djvstock1712/djvstock171204312/91557085-bosquejo-del-icono-de-mesa-y-sillas-de-comedor-sobre-ilustraci%C3%B3n-de-vector-de-fondo-blanco.jpg);
}
.cc-selector input{
    margin:0;padding:0;
    -webkit-appearance:none;
       -moz-appearance:none;
            appearance:none;
}
.cc-selector input:active +.drinkcard-cc{opacity: .9;}
.cc-selector input:checked +.drinkcard-cc{
    -webkit-filter: none;
       -moz-filter: none;
            filter: none;
}
.drinkcard-cc{
    cursor:pointer;
    background-size:contain;
    background-repeat:no-repeat;
    display:inline-block;
    width:100px;height:70px;
    -webkit-transition: all 100ms ease-in;
       -moz-transition: all 100ms ease-in;
            transition: all 100ms ease-in;
    -webkit-filter: brightness(1.2) grayscale(5) opacity(.7);
       -moz-filter: brightness(1.2) grayscale(5) opacity(.7);
            filter: brightness(1.2) grayscale(5) opacity(.7);
}
.drinkcard-cc:hover{
    -webkit-filter: brightness(1) grayscale(.7) opacity(.9);
       -moz-filter: brightness(1) grayscale(.7) opacity(.9);
            filter: brightness(1) grayscale(.7) opacity(.9);
}
</style>

<div class="main-container">
	<h1 class="text-center h1 display-3 bebas mb-4"><i class="fas fa-utensils mr-3"></i> ¡Reserva tu lugar!</h1>
	<section class="mx-auto" style="width:80%;">
		<div class = "restaurantes">
			<div id="loginbox" style="margin-top:10px;" class="text-center mx-auto">
				<h3 class="mb-5"><b>Restaurante: </b>${restaurante.nombre}</h3>
				<h3 class="mb-5">1. Elegi tu mesa:</h3>
				<form:form action="confirmar-reserva" method="POST" modelAttribute="formularioGeneracionReserva">
					<form:hidden path = "idRestaurante" value = "${restaurante.idRestaurante}"/>
					<form:hidden path = "fechaReserva" value = "${formularioGeneracionReserva.fechaReserva}" id="fecha-reserva"/>
					<div class="form-group">
					<table class="cc-selector">
						<c:forEach var="rowData" items="${matriz}">
					        <tr>
					            <c:forEach var="cellData" varStatus="loop" items="${rowData}" >
					                <td>
						                <c:if test="${not empty cellData.idMesa}">
							                <form:radiobutton path="idMesa" id="mesa-${cellData.idMesa}" name="mesa" class="radio-mesa" value="${cellData.idMesa}"/> 
							                <label class="drinkcard-cc radio-img" for="mesa-${cellData.idMesa}">Cantidad: ${cellData.cantidad}</label>
						                </c:if>
					                </td>                    
					            </c:forEach>
					        </tr>
					    </c:forEach>
					    </table>
					    <div class="d-flex justify-content-between align-items-center mt-5">
						    <div>
	       					  	<label class="h3 mr-2">2. Elegi el horario:</label>
								<form:select id="horarios-select" path="idRestauranteHorario" required="required" class="form-control-lg">
								</form:select>
						    </div>

							<input type="submit" class="btn btn-outline-danger" value="Reservar"/>
					    </div>
					</div>
				</form:form>
			</div>
		</div>
	</section>
</div>

<script>
$(document).ready(function(){
	/*$("#mesas-select").on('change', function(){
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
	});*/
	$(".radio-mesa").on('click', function(){
		var fechaReserva = $('#fecha-reserva').val();
		var idMesa = $(this).val();
		$("#horarios-select").empty();
		console.log(idMesa);
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