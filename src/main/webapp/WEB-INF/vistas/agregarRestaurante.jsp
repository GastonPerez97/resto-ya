<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<div class="main-container">
	<h1 class="text-center h1 display-3 bebas mb-4">Agregar Restaurante</h1>
	
	<section class="mx-auto col-lg-6">
		<c:if test="${not empty errorValidacion}">
	        <h4><span>${errorValidacion}</span></h4>
	        <br>
	    </c:if>
	
		<div class="mb-4">
		    <a href="./restaurantes"><button type="button" class="btn btn-outline-dark">Volver</button></a>
		</div>
	
		<article>
			<form:form action="validar-nuevoRestaurante" method="POST" modelAttribute="restaurante" enctype="multipart/form-data">
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="nombre">Nombre:</label>
						<form:input path="nombre" id="nombre" class="form-control"/>
					</div>
					<div class="form-group col-md-6">
						<label for="telefono">Telefono:</label>
						<form:input path="telefono" type="number" id="telefono" class="form-control"/>
					</div>
				</div>
				<div class="form-group">
					<label for="direccion">Direccion:</label>
					<form:input path="direccion" type="text" id="direccion" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="urlMaps">URL de Google Maps:</label>
					<form:input path="urlMaps" type="url" id="urlMaps" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="horario">Horario:</label>
					<form:input path="horario" type="text" id="horario" class="form-control"/>
				</div>
				<div class="form-row mt-4">
					<div class="form-group col-md-6 my-auto">
						<div class="custom-file">
						    <input type="file" name="file" class="custom-file-input" id="imagen">
						    <label class="custom-file-label" for="imagen">Elegir imagen...</label>
					  	</div>
					</div>
					<div class="form-group col-md-6 text-center my-auto">
						<div class="custom-control custom-checkbox">
							<form:checkbox path="disponible" class="custom-control-input" id="disponible"/>
							<label class="custom-control-label" for="disponible">Disponible</label>
						</div>
					</div>
				</div>
				
				<div class="form-group mt-5 text-center">
					<button type="submit" class="btn btn-dark mx-auto">Agregar Restaurante</button>
				</div>
			</form:form>
		</article>
	</section>
</div>

<%@ include file="footer.jsp" %>