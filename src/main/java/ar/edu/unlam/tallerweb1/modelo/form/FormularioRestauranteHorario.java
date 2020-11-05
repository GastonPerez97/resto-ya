package ar.edu.unlam.tallerweb1.modelo.form;

import java.sql.Time;

public class FormularioRestauranteHorario {

	private Long idRestaurante;
	private Long idHorario;
	
	public FormularioRestauranteHorario() {
		
	}

	public Long getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(Long idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public Long getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Long idHorario) {
		this.idHorario = idHorario;
	}
	
}
