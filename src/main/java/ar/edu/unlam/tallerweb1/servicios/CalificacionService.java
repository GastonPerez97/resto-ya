package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.CalificacionModel;
import ar.edu.unlam.tallerweb1.modelo.ClienteModel;

public interface CalificacionService {
	

	List<CalificacionModel> buscarCalificaciones();
}
