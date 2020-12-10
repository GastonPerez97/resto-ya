<%@ include file="header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" style="width: 100%; height: 500px !important;">
          <div class="carousel-item active">
            <img src="./img/homeSlider/image1.jpg" class="d-block w-100" alt="imagenSlider1">
          </div>
          <div class="carousel-item">
            <img src="./img/homeSlider/image2.jpg" class="d-block w-100" alt="imagenSlider2">
          </div>
          <div class="carousel-item">
            <img src="./img/homeSlider/image3.jpg" class="d-block w-100" alt="imagenSlider3">
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
</section>

<div class="main-container">
	<h1 class="text-center h1 display-2 bebas mb-2">
		<i class="fas fa-utensils mr-3"></i> Busc&aacute tu comida o restaurante!
	</h1>
	
	<section style="width: 60%; height: 300px;" class="mx-auto">
		<div class="restaurantes">
			<div id="loginbox" class="card-body">
	
				<form:form action="buscar" method="POST" modelAttribute="formularioBusqueda">
					<hr class="colorgraph">
					<br>
					<div class="form-group">
	
						<form:radiobutton value="${formularioBusqueda.tiposBusqueda[0].ordinal()}"
							path="tipoBusquedaSeleccionada" class="mr-2" />${formularioBusqueda.tiposBusqueda[0]}
							&nbsp
						<form:radiobutton value="${formularioBusqueda.tiposBusqueda[1].ordinal()}"
							path="tipoBusquedaSeleccionada" class="mr-2" />${formularioBusqueda.tiposBusqueda[1]}
						<form:input path="datoBuscado"  type="text" placeholder="Ingresa el dato a buscar" class="form-control"  />  		
					</div>
					<input type="submit" class="float-right btn btn-dark" value="Buscar" />
				</form:form>
			</div>
		</div>
	</section>
</div>


<%@ include file="footer.jsp"%>