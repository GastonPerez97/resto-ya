package ar.edu.unlam.tallerweb1.modelo.form;

import java.sql.Date;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.enums.TipoBusqueda;

public class FormularioGeneracionReserva {

	private Long idMesa;
	private Long idRestaurante;
	private Long idRestauranteHorario;
	private Date fechaReserva;
	
	public FormularioGeneracionReserva() {
		
	}

	public FormularioGeneracionReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Long getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(Long idMesa) {
		this.idMesa = idMesa;
	}

	public Long getIdRestaurante() {
		return idRestaurante;
	}
	
	public void setIdRestaurante(Long idRestaurante) {
		this.idRestaurante = idRestaurante;
	}
	
	public Long getIdRestauranteHorario() {
		return idRestauranteHorario;
	}

	public void setIdRestauranteHorario(Long idRestauranteHorario) {
		this.idRestauranteHorario = idRestauranteHorario;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
}
