package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

import javax.persistence.*;

import ar.edu.unlam.tallerweb1.modelo.enums.Calificacion;

@Entity
@Table(name = "calificacion")
public class CalificacionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_calificacion")
	private Long idCalificacion;

	@Column(name = "comentario")
	private String comentario;

	@Column(name = "valor")
	private Calificacion valor;

	@Column(name = "imageName")
	private String imageName;

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@ManyToOne
	@JoinColumn(name = "id_restaurante")
	private RestauranteModel restauranteModel;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private ClienteModel clienteModel;	


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

	public Long getIdCalificacion() {
		return idCalificacion;
	}

	public void setIdCalificacion(Long idCalificacion) {
		this.idCalificacion = idCalificacion;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Calificacion getValor() {
		return valor;
	}

	public void setValor(Calificacion valor) {
		this.valor = valor;
	}

}
