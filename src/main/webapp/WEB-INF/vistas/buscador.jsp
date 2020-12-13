<%@ include file="header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1 class="text-center h1 display-3 bebas mb-4">
	<i class="fas fa-utensils mr-3"></i> ¡Busc&aacute tu comida o restaurante!
</h1>
<section class="mx-auto" style="width: 80%;">
	<div class="restaurantes">
		<div id="loginbox" style="margin-top: 50px;" class="card-body">


			<form:form action="buscar" method="POST"
				modelAttribute="formularioBusqueda">
				<hr class="colorgraph">
				<br>
				<div class="form-group">

					<form:radiobutton value="${formularioBusqueda.tiposBusqueda[0].ordinal()}" 
						path="tipoBusquedaSeleccionada" checked="true"/>${formularioBusqueda.tiposBusqueda[0]}
						&nbsp
					<form:radiobutton value="${formularioBusqueda.tiposBusqueda[1].ordinal()}"
						path="tipoBusquedaSeleccionada" />${formularioBusqueda.tiposBusqueda[1]}
					<form:input path="datoBuscado"  type="text" placeholder="Ingrese el dato a buscar" class="form-control"  />  		
				</div>
				<input type="submit" class="float-right btn btn-dark" value="Buscar" />
			</form:form>
		</div>
	</div>
</section>


<%@ include file="footer.jsp"%>