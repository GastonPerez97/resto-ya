<%@ include file="header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="main-container">
    <section>
        <form:form action="procesarPedido" method="post" modelAttribute="formularioPedido" class="comidas-pedido mx-auto" id="form-pedido">
            <form:hidden path="restaurante" value="${formularioPedido.restaurante}" />
            <c:forEach items="${COMIDAS}" var="comida" varStatus="status">
                <article class="comida mx-auto">
                    <div>
                        <div class="card h-100">
                            <c:if test="${not empty comida.imageName}">
                                <img src="img/comidas/${comida.imageName}" class="card-img-top img-comida">
                            </c:if>
                            <c:if test="${empty comida.imageName}">
                                <img src="img/comidas/defaultComida.jpg" class="card-img-top img-comida">
                            </c:if>
                            <div class="card-body">
                                <h4 class="card-title">
                                    <p style="color:#047cfc;">${comida.nombre}</p>
                                </h4>
                                <h5>$${comida.precio}</h5>
                                <p class="card-text">${comida.descripcion}</p>
                            </div>
                            <div class="card-footer">
                                <small class="text-muted">${comida.tipo}</small>
                                <c:if test="${comida.disponible == true}">
                                    <small class="d-block mt-2">Cantidad: <input type="number" id="${comida.idComida}" value="0" class="form-control cantidades"/></small>
                                </c:if>
                                <c:if test="${comida.disponible == false}"><small class="h5">NO DISPONIBLE</small></c:if>
                            </div>
                        </div>
                    </div>
                </article>
            </c:forEach>

            <form:hidden path="pedidoSinFormato" id="hidden-cantidades" name="pedidoHidden" />
            <input type="submit" id="boton-pago" value="Procesar Pedido" class="btn btn-outline-success btn-block" />
        </form:form>
    </section>
</div>

<script>
    $(document).ready(function() {

        $("#form-pedido").submit(function(event) {
            var valueHidden = "";
            $(".cantidades").each(function() {
                if ($(this).val() > 0) {
                    valueHidden += $(this).attr('id') + '-' + $(this).val() + ';';
                }
            });
            $("#hidden-cantidades").val(valueHidden);
        });

    });
</script>

<%@ include file="footer.jsp"%>