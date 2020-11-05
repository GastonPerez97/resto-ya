package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.HorarioModel;

public interface HorarioService {

	List<HorarioModel> getHorariosNoAsignadosARestaurante(Long idRestaurante);
	HorarioModel getHorarioById(Long idHorario);
}
