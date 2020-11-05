package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.HorarioModel;

public interface HorarioRespository {
	
	List<HorarioModel> getHorariosByRestaurante(Long idRestaurante);
	List<HorarioModel> getHorariosNoAsignadosARestaurante(Long idRestaurante);
	HorarioModel getHorarioById(Long idHorario);
}
