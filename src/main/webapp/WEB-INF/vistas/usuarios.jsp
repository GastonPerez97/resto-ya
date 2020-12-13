<%@ include file="header.jsp"%>

<div class="main-container">
	<h1 class="text-center h1 display-3 bebas mb-4">Listado de usuarios:</h1>
	
	<section class="restaurantes">
		<div class="mb-4 float-right">
			<form action="agregarUsuario" method="POST">
				<input type="submit" class="float-right btn btn-outline-primary"
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
							<div class="card-body pb-1">
								<div class="d-flex justify-content-between">
									<p><span class="h4"><b class="d-block">Nombre de usuario: </b></span>${usr.nombreDeUsuario}</p>
									<p><span class="h4"><b>ID: </b></span>${usr.idUsuario}</p>
								</div>
								<p><span class="h4"><b>Email: </b></span>${usr.email}</p>
								<p><span class="h4"><b>Rol: </b></span></p>
								<c:forEach items="${usr.listaUsuarioRoles}" var="usuarioRol"
									varStatus="status">
									<p class="mb-0"> - ${usuarioRol.rolModel.nombre} </p>
									<br>
								</c:forEach>
								
								<div class="d-flex justify-content-end">
									<a href="editarUsuario?id=${usr.idUsuario}"><i class="far fa-edit restaurante-btn my-3 mr-4"></i></a> 
								</div>
							</div>
						</div>
					</div>
			</c:forEach>
		</div>
	</section>
</div>

<%@ include file="footer.jsp"%>
