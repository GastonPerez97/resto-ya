package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.ReservaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteHorarioModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioGeneracionReserva;

import java.util.List;

public interface RestauranteHorarioRepository {
		
	RestauranteHorarioModel getRestauranteHorarioById(Long idRestauranteHorario);
	void guardarRestauranteHorario(RestauranteHorarioModel restauranteHorarioModel);

}
