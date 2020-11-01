<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<h1 class="text-center h1 display-3 bebas mb-4">Agregar Comida</h1>

<div class="mb-4 volver-btn">
    <a href="../../restaurante/menu?id=${comida.restaurante.idRestaurante}"><button type="button" class="btn btn-dark">Volver</button></a>
</div>

<section class="mx-auto col-lg-6">
	<article>
		<form:form action="../../validar-nuevaComida" method="POST" modelAttribute="comida" enctype="multipart/form-data">
			<form:hidden path="restaurante.idRestaurante" values="comida.restaurante.idRestaurante"/>
			
			<div class="form-group">
				<label for="nombre">Nombre:</label>
				<form:input path="nombre" type="text" id="nombre" class="form-control"/>
			</div>
			
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="precio">Precio:</label>
					<form:input path="precio" type="number" id="precio" class="form-control"/>
				</div>
				<div class="form-group col-md-6">
					<label for="tipo">Tipo:</label>
					<form:select path="tipo" id="tipo" class="form-control">
			            <form:option value="Entrada"/>
			            <form:option value="Plato Principal"/>
			            <form:option value="Postre"/>
			            <form:option value="Guarnicion"/>
		            </form:select>
				</div>
			</div>
			
			<div class="form-group">
				<label for="descripcion">Descripcion:</label>
				<form:textarea path="descripcion" type="text" id="descripcion" class="form-control" rows="3" maxlength="254"/>
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
				<button type="submit" class="btn btn-dark mx-auto">Agregar Comida</button>
			</div>
		</form:form>
	</article>
</section>

<%@ include file="footer.jsp" %>