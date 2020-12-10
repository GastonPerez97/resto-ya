<%@ include file="header.jsp"%>

<div class="main-container">
	<h1 class="text-center h1 display-3 bebas mb-4">Listado de usuarios</h1>
	
	<section class="restaurantes">
		<div class="mx-auto mb-4" style="width: 80%;">
			<form action="agregarUsuario" method="POST">
				<input type="submit" class="float-right btn btn-primary"
					value="Agregar Usuario">
			</form>
		</div>
	
		<c:if test="${not empty estadoEliminar}">
			<h4>
				<span>${estadoEliminar}</span>
			</h4>
			<a href="./usuarios"><button type="button"
					class="btn btn-secondary">Volver</button></a>
			<br>
		</c:if>
	
		<c:forEach items="${usuarios}" var="usr">
			<div class="d-flex justify-content-center align-items-center">
				<div class="card mb-3 restaurante shadow">
					<div class="row no-gutters">
						<div class="col-md-8">
							<div class="card-body">
								<h2 class="card-title bebas">Nombre: ${usr.nombreDeUsuario}</h2>
								<p class="card-text">
									<span class="h4">ID: ${usr.idUsuario} </span>
								</p>
								<p class="card-text">
									<span class="h4">Email: ${usr.email} </span>
								</p>
								<p class="card-text">
									<span class="h4">Rol: </span>
								</p>
								<p class="card-text">
								<c:forEach items="${usr.listaUsuarioRoles}" var="usuarioRol"
									varStatus="status">
									<span class="h4"> - ${usuarioRol.rolModel.nombre} </span>
									<br>
								</c:forEach>
								</p>
								<a href="editarUsuario?id=${usr.idUsuario}"><i class="far fa-edit restaurante-btn my-3 mr-4"></i></a> 
								<a href="validarEliminarUsuario?id=${usr.idUsuario}"><i class="far fa-trash-alt restaurante-btn my-3"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</section>
</div>

<%@ include file="footer.jsp"%>
