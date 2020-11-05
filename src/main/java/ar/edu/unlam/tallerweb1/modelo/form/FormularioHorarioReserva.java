package ar.edu.unlam.tallerweb1.modelo.form;

import java.sql.Time;

public class FormularioHorarioReserva {

	private Long idRestauranteHorario;
	private Time horario;
	
	public FormularioHorarioReserva() {
		
	}
	
	public FormularioHorarioReserva(Long idRestauranteHorario, Time horario) {
		this.idRestauranteHorario = idRestauranteHorario;
		this.horario = horario;
	}

	public Long getIdRestauranteHorario() {
		return idRestauranteHorario;
	}

	public void setIdRestauranteHorario(Long idRestauranteHorario) {
		this.idRestauranteHorario = idRestauranteHorario;
	}

	public Time getHorario() {
		return horario;
	}

	public void setHorario(Time horario) {
		this.horario = horario;
	}
	
}
