package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.HorarioModel;
import ar.edu.unlam.tallerweb1.modelo.ReservaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteHorarioModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioGeneracionReserva;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioHorarioReserva;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioRestauranteHorario;

public interface RestauranteHorarioService {
	
	RestauranteHorarioModel getRestauranteHorarioById(Long idRestauranteHorario);
	void guardarRestauranteHorario(RestauranteHorarioModel restauranteHorarioModel);
	HorarioModel procesarNuevoHorarioRestaurante(FormularioRestauranteHorario formulario);
}
