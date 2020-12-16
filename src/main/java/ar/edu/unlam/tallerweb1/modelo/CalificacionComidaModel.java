package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

import ar.edu.unlam.tallerweb1.modelo.enums.Calificacion;

@Entity
@Table(name = "calificacionComida")
public class CalificacionComidaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_calificacion_comida")
	private Long idCalificacionComida;

	@ManyToOne
	@JoinColumn(name = "id_comida")
	private ComidaModel comidaModel;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private ClienteModel clienteModel;

	@ManyToOne
	@JoinColumn(name = "id_calificacion")
	private CalificacionModel calificacionModel;

	public ComidaModel getComidaModel() {
		return comidaModel;
	}

	public void setComidaModel(ComidaModel comidaModel) {
		this.comidaModel = comidaModel;
	}

	@Column(name = "comentario")
	private String comentario;

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public ClienteModel getClienteModel() {
		return clienteModel;
	}

	public void setClienteModel(ClienteModel clienteModel) {
		this.clienteModel = clienteModel;
	}

	public Long getIdCalificacionComida() {
		return idCalificacionComida;
	}

	public void setIdCalificacionComida(Long idCalificacionComida) {
		this.idCalificacionComida = idCalificacionComida;
	}

	public CalificacionModel getCalificacionModel() {
		return calificacionModel;
	}

	public void setCalificacionModel(CalificacionModel calificacionModel) {
		this.calificacionModel = calificacionModel;
	}

}
