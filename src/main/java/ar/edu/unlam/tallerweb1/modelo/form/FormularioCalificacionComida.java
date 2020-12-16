package ar.edu.unlam.tallerweb1.modelo.form;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.CalificacionComidaModel;
import ar.edu.unlam.tallerweb1.modelo.CalificacionModel;
import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.enums.Calificacion;

public class FormularioCalificacionComida {

	private CalificacionModel calificacion = new CalificacionModel();
	private ComidaModel comida = new ComidaModel();
	private CalificacionComidaModel calificacionComida = new CalificacionComidaModel();

	private List<Calificacion> valor;

	public FormularioCalificacionComida() {
		valor = List.of(Calificacion.values());

	}

	public List<Calificacion> getValor() {
		return valor;
	}

	public ComidaModel getComida() {
		return comida;
	}

	public void setComida(ComidaModel comida) {
		this.comida = comida;
	}

	public CalificacionComidaModel getCalificacionComida() {
		return calificacionComida;
	}

	public void setCalificacionComida(CalificacionComidaModel calificacionComida) {
		this.calificacionComida = calificacionComida;
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

}
