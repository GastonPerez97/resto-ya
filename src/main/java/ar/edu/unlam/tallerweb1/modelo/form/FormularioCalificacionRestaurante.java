package ar.edu.unlam.tallerweb1.modelo.form;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.CalificacionModel;
import ar.edu.unlam.tallerweb1.modelo.CalificacionRestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.ClienteModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.enums.Calificacion;

public class FormularioCalificacionRestaurante {

	private CalificacionModel calificacion = new CalificacionModel();
	private RestauranteModel restaurante = new RestauranteModel();
	private ClienteModel cliente = new ClienteModel();
	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	private List<Calificacion> valor;

	public FormularioCalificacionRestaurante() {
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
