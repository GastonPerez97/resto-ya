<%@ include file="header.jsp"%>

<div class="main-container">
	<h1 class="text-center h1 display-3 bebas mb-4">Listado de usuarios:</h1>
	
	<section class="restaurantes">
		<div class="mb-4 float-right">
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
		<div class="d-flex justify-content-between flex-wrap">
			<c:forEach items="${usuarios}" var="usr">
					<div class="card mb-3 shadow" style="width: 32%;">
						<div class="row no-gutters">
							<div class="card-body">
								<p class="card-text">
									<span class="h4"><b>Nombre: </b>${usr.nombreDeUsuario}</span>
								</p>
								<p class="card-text">
									<span class="h4"><b>ID: </b>${usr.idUsuario} </span>
								</p>
								<p class="card-text">
									<span class="h4"><b>Email: </b>${usr.email} </span>
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
			</c:forEach>
		</div>
	</section>
</div>

<%@ include file="footer.jsp"%>
