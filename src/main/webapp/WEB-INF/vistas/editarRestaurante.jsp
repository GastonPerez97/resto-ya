<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<h1 class="text-center h1 display-3 bebas mb-4">Editar "${restaurante.nombre}"</h1>

<div class="mb-4 volver-btn">
    <a href="./restaurantes"><button type="button" class="btn btn-dark">Volver</button></a>
</div>

<section class="mx-auto col-lg-6">
	<article>
		<form:form action="validar-editarRestaurante" method="POST" modelAttribute="restaurante" enctype="multipart/form-data">
			<form:hidden path="idRestaurante" values="restaurante.idRestaurante"/>
			<form:hidden path="imageName" values="restaurante.imageName"/>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="nombre">Nombre:</label>
					<form:input path="nombre" id="nombre" class="form-control"/>
				</div>
				<div class="form-group col-md-6">
					<label for="telefono">Telefono:</label>
					<form:input path="telefono" id="telefono" class="form-control"/>
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
			<div class="text-center d-flex justify-content-center align-items-center">
				<p class="mr-4">Imagen Actual:</p>
				<c:if test="${not empty restaurante.imageName}">
					<img src="img/restaurantes/${restaurante.imageName}" class="img-fluid" width="150">
				</c:if>
				<c:if test="${empty restaurante.imageName}">
					<img src="img/restaurantes/defaultRestaurante.jpg" class="img-fluid" width="250">
				</c:if>
			</div>
			<div class="form-row mt-4">
				<div class="form-group col-md-6 my-auto">
					<div class="custom-file">
					    <input type="file" name="file" class="custom-file-input" id="imagen">
					    <label class="custom-file-label" for="imagen">Elegir nueva imagen...</label>
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
				<button type="submit" class="btn btn-dark mx-auto">Editar Restaurante</button>
			</div>
		</form:form>
	</article>
</section>

<%@ include file="footer.jsp" %>