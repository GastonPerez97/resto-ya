package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.CalificacionRestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.ClienteModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioCalificacionRestaurante;

public interface CalificacionService {
	

	List<CalificacionRestauranteModel> buscarCalificaciones();

	void guardarCalificaciones(FormularioCalificacionRestaurante calificacion);

	public List <CalificacionRestauranteModel> buscarCalificacionPorRestaurante(RestauranteModel restaurante);

}
