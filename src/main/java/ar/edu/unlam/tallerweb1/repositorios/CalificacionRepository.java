package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.CalificacionRestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioCalificacionRestaurante;

public interface CalificacionRepository {

	List<CalificacionRestauranteModel> buscarCalificaciones();
	
	void guardarCalificaciones(FormularioCalificacionRestaurante calificacion);

	List <CalificacionRestauranteModel> buscarCalificacionPorRestaurante(RestauranteModel restaurante);

	
}
