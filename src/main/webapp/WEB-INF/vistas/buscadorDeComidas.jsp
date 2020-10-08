<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<h1 class="text-center h1 display-3 bebas mb-4"><i class="fas fa-utensils mr-3"></i> ¡Busc&aacute tu comida!</h1>
<section class="mx-auto" style="width:80%;">
	<div class = "restaurantes">
		<div id="loginbox" style="margin-top:50px;" class="card-body">
			<form:form action="busqueda" method="POST" modelAttribute="busqueda">
				<hr class="colorgraph"><br>
				  <div class="form-group">
   					<form:input path="nombre" id="nombreComida" type="text" placeholder="" class="form-control"  />  	
				  </div>
				<input type="submit" class="float-right btn btn-dark" value="Buscar"/>
			</form:form>
		</div>
	</div>
</section>

<%@ include file="footer.jsp" %>