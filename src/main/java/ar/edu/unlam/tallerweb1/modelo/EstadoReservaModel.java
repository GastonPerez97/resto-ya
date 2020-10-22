package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
@Table(name = "estado_reserva")
public class EstadoReservaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado_reserva")
	private Long idEstadoReserva;
	
	@Column(name = "nombre_estado")
	private String nombreEstado;

    public EstadoReservaModel() {
    	
    }
    
    public EstadoReservaModel(Long idEstadoReserva) {
    	this.idEstadoReserva = idEstadoReserva;
    }
}
