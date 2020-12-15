package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.CalificacionComidaModel;
import ar.edu.unlam.tallerweb1.modelo.CalificacionRestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioCalificacionComida;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioCalificacionRestaurante;

public interface CalificacionRepository {

	List<CalificacionRestauranteModel> buscarCalificaciones();

	void guardarCalificaciones(FormularioCalificacionRestaurante calificacion);

	List<CalificacionRestauranteModel> buscarCalificacionDelRestaurante(RestauranteModel restaurante);

	List<CalificacionRestauranteModel> getCalificacionByRestaurante(Long idRestaurante);

	Integer getPromedioCalificacionDeRestaurante(Long idRestaurante);

	List<CalificacionRestauranteModel> buscarCalificacionPorRestaurante(Long idRestaurante);

	void guardarCalificacionesComida(FormularioCalificacionComida formularioCalificacionComida);

	List<CalificacionComidaModel> buscarCalificacionesComidas();

	List<CalificacionComidaModel> getCalificacionByComida(Long idComida);

	Integer getPromedioCalificacionDeComida(Long idComida);

}