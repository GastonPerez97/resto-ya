package ar.edu.unlam.tallerweb1.modelo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReservaID implements Serializable {
	
	@Column(name = "fecha_reserva")        
	private Date fechaReserva;
	
	@Column(name = "id_restaurante_horario")        
	private Long idRestauranteHorario;
	
	@Column(name = "id_mesa")        
	private Long idMesa;
}
