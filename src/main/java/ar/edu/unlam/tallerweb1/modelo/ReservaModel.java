package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "reserva")
public class ReservaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero_reserva")
	private Long numeroDeReserva;
	
	@Column(name = "fecha_reserva", nullable = false)
	private Date fechaReserva;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_restaurante_horario", nullable = false)
    private RestauranteHorarioModel restauranteHorarioModel;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_mesa", nullable = true)
    private MesaModel mesaModel;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente", nullable = true)
    private ClienteModel clienteModel;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_estado_reserva", nullable = false)
    private EstadoReservaModel estadoReservaModel;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_restaurante", nullable = false)
    private RestauranteModel restauranteModel;
    
    public ReservaModel() {
    	
    }
    
    public void setNumeroDeReserva(Long numeroDeReserva) {
		this.numeroDeReserva = numeroDeReserva;
	}
    
    public Long getNumeroDeReserva() {
		return numeroDeReserva;
	}
    
    public ReservaModel(Date fechaReserva) {
    	this.fechaReserva = fechaReserva;
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
	
	public void setMesaModel(MesaModel mesaModel) {
		this.mesaModel = mesaModel;
	}
	
	public MesaModel getMesaModel() {
		return mesaModel;
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

	public RestauranteModel getRestauranteModel() {
		return restauranteModel;
	}

	public void setRestauranteModel(RestauranteModel restauranteModel) {
		this.restauranteModel = restauranteModel;
	}

}
