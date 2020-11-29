package ar.edu.unlam.tallerweb1.modelo.form;

import ar.edu.unlam.tallerweb1.modelo.CalificacionModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;

public class FormularioCalificarRestaurante {

	private CalificacionModel calificacion = new CalificacionModel();
	private RestauranteModel restaurante = new RestauranteModel();

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
