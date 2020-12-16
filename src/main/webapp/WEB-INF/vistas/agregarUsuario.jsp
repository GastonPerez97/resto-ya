<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp"%>

<div class="main-container">
	<h1 class="text-center h1 display-3 bebas mb-4">Agregar Usuario</h1>
	
	<section class="mx-auto col-4">
		<c:if test="${not empty errorValidacion}">
			<h4>
				<span>${errorValidacion}</span>
			</h4>
			<br>
		</c:if>
	
		<article>
			<form:form action="validarRegistroUsuario" method="POST"
				modelAttribute="formularioAgregarUsuario">
	
				<div class="form-group">
					<label for="nombreDeUsuario">* Nombre de usuario:</label>
					<form:input path="usuario.nombreDeUsuario" id="nombreDeUsuario"
						class="form-control" required="true" />
				</div>
	
				<div class="form-group">
					<label for="email">* Email:</label>
					<form:input path="usuario.email" type="text" id="email" class="form-control"
						required="true" />
				</div>
				<div class="form-group">
					<label for="clave">* Clave:</label>
					<form:input path="usuario.clave" type="password" id="clave"
						class="form-control" required="true" />
				</div>
				<div class="form-group">
				<label for="rol-select">* Rol:</label> <br>
						<form:select id="rol-select" path="idRol" required="required" class="form-control-lg">
							<option value="0">---</option>
							<c:forEach items="${listaDeRoles}" var="rol">
						    	<form:option value="${rol.idRol}">${rol.nombre}</form:option>
							</c:forEach>
						</form:select>
				</div>
				<div class="form-group mt-5 text-center">
					<button type="submit" class="btn btn-outline-success mx-auto">Agregar</button>
	
					<a href="./usuarios"><button type="button" class="btn btn-outline-secondary">Volver</button></a>
				</div>
			</form:form>
		</article>
	</section>
</div>

<%@ include file="footer.jsp"%>