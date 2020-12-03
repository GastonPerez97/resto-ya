package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

import ar.edu.unlam.tallerweb1.modelo.enums.Calificacion;

@Entity
@Table(name = "calificacionRestaurante")
public class CalificacionRestauranteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_calificacion_restaurante")
	private Long idCalificacionRestaurante;

	@ManyToOne
	@JoinColumn(name = "id_restaurante")
	private RestauranteModel restauranteModel;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private ClienteModel clienteModel;

	@ManyToOne
	@JoinColumn(name = "id_calificacion")
	private CalificacionModel calificacionModel;

	@Column(name = "comentario")
	private String comentario;
	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public RestauranteModel getRestauranteModel() {
		return restauranteModel;
	}

	public void setRestauranteModel(RestauranteModel restauranteModel) {
		this.restauranteModel = restauranteModel;
	}

	public ClienteModel getClienteModel() {
		return clienteModel;
	}

	public void setClienteModel(ClienteModel clienteModel) {
		this.clienteModel = clienteModel;
	}

	public Long getIdCalificacionRestaurante() {
		return idCalificacionRestaurante;
	}

	public void setIdCalificacionRestaurante(Long idCalificacionRestaurante) {
		this.idCalificacionRestaurante = idCalificacionRestaurante;
	}

	public CalificacionModel getCalificacionModel() {
		return calificacionModel;
	}

	public void setCalificacionModel(CalificacionModel calificacionModel) {
		this.calificacionModel = calificacionModel;
	}

}
