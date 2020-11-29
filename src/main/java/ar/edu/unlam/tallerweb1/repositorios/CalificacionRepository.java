package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.CalificacionModel;

public interface CalificacionRepository {

	List<CalificacionModel> buscarCalificaciones();
	
	void guardarCalificaciones(CalificacionModel calificacion);

}
