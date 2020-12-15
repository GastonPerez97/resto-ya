package ar.edu.unlam.tallerweb1.modelo;

import java.util.LinkedList;
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

	@Column(name = "valor")
	private Integer valor;

	@Column(name = "image_name")
	private String imageName;

	
	/* List <CalificacionModel> listadoCalificaciones = new LinkedList<>(); */

	public List<CalificacionRestauranteModel> getCalificacionRestaurante() {
		return calificacionRestaurante;
	}

	public void setCalificacionRestaurante(List<CalificacionRestauranteModel> calificacionRestaurante) {
		this.calificacionRestaurante = calificacionRestaurante;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "calificacionModel", cascade = CascadeType.ALL)
	private List<CalificacionRestauranteModel> calificacionRestaurante = new LinkedList<CalificacionRestauranteModel>();


	public List<CalificacionComidaModel> getCalificacionComida() {
		return calificacionComida;
	}

	public void setCalificacionComida(List<CalificacionComidaModel> calificacionComida) {
		this.calificacionComida = calificacionComida;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "calificacionModel", cascade = CascadeType.ALL)
	private List<CalificacionComidaModel> calificacionComida = new LinkedList<CalificacionComidaModel>();

	
	
	
	
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

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

}
