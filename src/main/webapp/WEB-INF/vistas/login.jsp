<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp"%>

<div class="main-container">
	<div class="container">
		<div id="loginbox" style="margin-top:40px;" class="col-lg-5 col-sm-12 mx-auto">
			<form:form action="validar-login" method="POST" modelAttribute="usuario">
		    	<h1 class="form-signin-heading text-center bebas display-3">Bienvenido!</h1>
				<hr class="colorgraph"><br>
	
				<label for="email">E-Mail:</label>
				<form:input path="email" id="email" type="email" class="form-control mb-2" />
				
				<label for="clave">Contraseña:</label>
				<form:input path="clave" type="password" id="clave" class="form-control mb-2" />
				
				<button id="ingresar-btn" class="btn btn-lg btn-primary btn-block mb-4 mt-3" type="Submit"/>Ingresar</button>
			</form:form>
	
			<c:if test="${not empty error}">
		        <h4><span>${error}</span></h4>
		        <br>
	        </c:if>
	        
	        <p class="mb-3" id="tenes-google">¿Tenés cuenta de Google?</p>
			<div class="g-signin2" data-onsuccess="onSignIn" id="myP"></div>
			
			<div class="d-flex align-items-center justify-content-center mb-4">
				<img class="rounded-circle mr-4" width="80px" id="myImg"><br>
	  			<h4 id="name"></h4>
			</div>
	
		    <div id="status"></div>
	        
		</div>
	</div>
</div>

<script>
	function onSignIn(googleUser) {
		var profile = googleUser.getBasicProfile();
		var imgurl = profile.getImageUrl();
		var name = profile.getName();
		var email = profile.getEmail();
		document.getElementById("myImg").src = imgurl;
		document.getElementById("myP").style.display = "none";
		document.getElementById("tenes-google").style.display = "none";
		document.getElementById("ingresar-btn").disabled = true;
		document.getElementById("name").innerHTML = "Hola " + name + "!";
		document.getElementById("status").innerHTML =
					"<a class='btn btn-success btn-block' href='/proyecto-limpio-spring-master/login/google/exito?email=" + email + "&name=" + name 
					+ "'>Continuar con mi cuenta de Google</a><button class='btn btn-danger btn-block mt-2' onclick='logOut()'>Me arrepentí, cerrar sesión de Google</button>"
	}
	
	function logOut() {
		gapi.auth2.getAuthInstance().disconnect();
		document.getElementById("tenes-google").style.display = "inline";
		document.getElementById("ingresar-btn").disabled = false;
		location.reload();
	}
</script>
	   
<%@ include file="footer.jsp"%>