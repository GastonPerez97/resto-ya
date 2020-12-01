package ar.edu.unlam.tallerweb1.modelo.form;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.CalificacionModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;
import ar.edu.unlam.tallerweb1.modelo.enums.Calificacion;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoBusqueda;

public class FormularioCalificarRestaurante {

	private CalificacionModel calificacion = new CalificacionModel();
	private RestauranteModel restaurante = new RestauranteModel();
	private List<Calificacion> valor;

	public FormularioCalificarRestaurante() {
		valor = List.of(Calificacion.values());
	}

	public List<Calificacion> getValor() {
		return valor;
	}

	public void setValor(List<Calificacion> valor) {
		this.valor = valor;
	}

	public CalificacionModel getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(CalificacionModel calificacion) {
		this.calificacion = calificacion;
	}

	public RestauranteModel getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(RestauranteModel restaurante) {
		this.restaurante = restaurante;
	}

}
