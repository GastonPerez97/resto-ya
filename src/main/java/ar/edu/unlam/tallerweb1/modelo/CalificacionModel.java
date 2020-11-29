package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "calificacion")
public class CalificacionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_calificacion")
	private Long idCalificacion;

	@Type(type = "org.hibernate.type.TrueFalseType")
	private Boolean estado;

	@Column(name = "comentario")
	private String comentario;

	@Column(name = "imageName")
	private String imageName;
	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public RestauranteModel getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(RestauranteModel restaurante) {
		this.restaurante = restaurante;
	}

	@ManyToOne
	@JoinColumn(name = "id_restaurante")

	private RestauranteModel restaurante;

	
	public Long getIdCalificacion() {
		return idCalificacion;
	}

	public void setIdCalificacion(Long idCalificacion) {
		this.idCalificacion = idCalificacion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

}
