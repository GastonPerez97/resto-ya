		</main>
		
		<footer class="container-footer bg-dark footer mt-5">
        	<div class="container d-flex justify-content-between align-items-center">
        		<span class="text-light">Copyright © 2020, Capa 8. Todos los derechos reservados.</span>
        		<a href="#" class="btn btn-light float-right">Ir arriba</a>
     		</div>
   		</footer>
		
	 	<!-- Optional JavaScript -->
    	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
    	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    	<script src="/proyecto-limpio-spring-master/js/sweetalert2.all.min.js"></script>
		<script>
		    $('.delete-btn').on('click', function(e) {
		        e.preventDefault();
		        const href = $(this).attr('href');
		
		        Swal.fire({
		            title: 'Eliminar Restaurante',
		            text: "¿Estás seguro de querer eliminar este restaurante?",
		            icon: 'warning',
		            showCancelButton: true,
		            cancelButtonText: 'Cancelar',
		            confirmButtonColor: '#d33',
		            cancelButtonColor: '#3085d6',
		            confirmButtonText: 'Eliminar Restaurante'
		        }).then((result) => {
		            if (result.isConfirmed) {
		                document.location.href = href;
		            }
		        })
		    });
		</script>
	</body>
</html>