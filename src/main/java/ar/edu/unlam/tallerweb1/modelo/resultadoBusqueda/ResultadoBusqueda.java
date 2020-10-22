package ar.edu.unlam.tallerweb1.modelo.resultadoBusqueda;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoBusqueda;

public class ResultadoBusqueda {

	private List<ComidaModel> listaComidas;
	private List<RestauranteModel> listaRestaurantes;
	private List<TipoBusqueda> tiposBusqueda;

	public ResultadoBusqueda() {
		// forma de convertir un array a un tipo lista
		setTiposBusqueda(List.of(TipoBusqueda.values()));
		listaComidas = new ArrayList<ComidaModel>();
		listaRestaurantes = new ArrayList<RestauranteModel>();
	}

	public List<RestauranteModel> getListaRestaurantes() {
		return listaRestaurantes;
	}

	public void setListaRestaurantes(List<RestauranteModel> listaRestaurantes) {
		this.listaRestaurantes = listaRestaurantes;
	}

	public List<ComidaModel> getListaComidas() {
		return listaComidas;
	}

	public void setListaComidas(List<ComidaModel> listaComidas) {
		this.listaComidas = listaComidas;
	}

	public List<TipoBusqueda> getTiposBusqueda() {
		return tiposBusqueda;
	}

	public void setTiposBusqueda(List<TipoBusqueda> tiposBusqueda) {
		this.tiposBusqueda = tiposBusqueda;
	}
}
