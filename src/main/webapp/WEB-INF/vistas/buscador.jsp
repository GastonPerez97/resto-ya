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
	<h1 class="text-center display-3 bebas mb-2 mt-5">
		<i class="fas fa-utensils mr-3"></i> ¡Busc&aacute tu comida o restaurante!
	</h1>
	<hr class="colorgraph col-8 mx-auto">
	<br>
	
	<section style="width: 60%; height: 300px;" class="mx-auto">
		<div class="restaurantes">
			<div id="loginbox" class="mx-auto mt-2 col-6">
				<form:form action="buscar" method="POST" modelAttribute="formularioBusqueda">
					<div class="form-group">
						<div class="mb-1 d-flex pl-0 justify-content-start align-items-center col-6">
							<form:radiobutton value="${formularioBusqueda.tiposBusqueda[0].ordinal()}"
									path="tipoBusquedaSeleccionada" class="mr-2 mb-1 radio-home" /><span class="h5 mr-3">${formularioBusqueda.tiposBusqueda[0]}</span>
									&nbsp
							<form:radiobutton value="${formularioBusqueda.tiposBusqueda[1].ordinal()}"
								path="tipoBusquedaSeleccionada" class="mr-2 mb-1 radio-home" /><span class="h5">${formularioBusqueda.tiposBusqueda[1]}</span>
						</div>
						
						<form:input path="datoBuscado"  type="text" placeholder="Ingresa el dato a buscar" class="form-control-lg col-12"  /> 	
					</div>
					
					<input type="submit" class="float-right btn btn-dark" value="Buscar" /> 	
				</form:form>
			</div>
		</div>
	</section>
</div>


<%@ include file="footer.jsp"%>