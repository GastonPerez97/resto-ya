package ar.edu.unlam.tallerweb1.modelo.form;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.enums.TipoBusqueda;

public class FormularioBusqueda {
	
	private List<TipoBusqueda> tiposBusqueda;
	private Integer tipoBusquedaSeleccionada; 
	private String datoBuscado;

	public FormularioBusqueda() {
		//forma de convertir un array a un tipo lista (casteo)
		tiposBusqueda = List.of(TipoBusqueda.values());
	}
	
	public List<TipoBusqueda> getTiposBusqueda() {
		return tiposBusqueda;
	}
	
	public Integer getTipoBusquedaSeleccionada() {
		return tipoBusquedaSeleccionada;
	}

	public void setTipoBusquedaSeleccionada(Integer tipoBusquedaSeleccionada) {
		this.tipoBusquedaSeleccionada = tipoBusquedaSeleccionada;
	}

	public String getDatoBuscado() {
		return datoBuscado;
	}
	
	public void setDatoBuscado(String datoBuscado) {
		this.datoBuscado = datoBuscado;
	}
	
}
