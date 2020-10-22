package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "reserva")
public class ReservaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reserva")
	private Long idReserva;
	
	@Column(name = "fecha_reserva")
	private Date fechaReserva;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_restaurante_horario", nullable = false)
    private RestauranteHorarioModel restauranteHorarioModel;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente", nullable = true)
    private ClienteModel clienteModel;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_estado_reserva", nullable = false)
    private EstadoReservaModel estadoReservaModel;
    
    public ReservaModel() {
    	
    }

	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public RestauranteHorarioModel getRestauranteHorarioModel() {
		return restauranteHorarioModel;
	}

	public void setRestauranteHorarioModel(RestauranteHorarioModel restauranteHorarioModel) {
		this.restauranteHorarioModel = restauranteHorarioModel;
	}

	public ClienteModel getClienteModel() {
		return clienteModel;
	}

	public void setClienteModel(ClienteModel clienteModel) {
		this.clienteModel = clienteModel;
	}

	public EstadoReservaModel getEstadoReservaModel() {
		return estadoReservaModel;
	}

	public void setEstadoReservaModel(EstadoReservaModel estadoReservaModel) {
		this.estadoReservaModel = estadoReservaModel;
	}

}
