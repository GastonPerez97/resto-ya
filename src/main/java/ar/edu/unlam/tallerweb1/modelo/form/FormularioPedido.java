package ar.edu.unlam.tallerweb1.modelo.form;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;

public class FormularioPedido {

	private Long restaurante; 
	private ArrayList<ComidaModel> comidas;
	
	public FormularioPedido() {
		comidas = new ArrayList<ComidaModel>();
	}
	public Long getRestaurante() {
		return restaurante;
	}
	
	
	
	public void setRestaurante(Long restaurante) {
		this.restaurante = restaurante;
	}
	public List<ComidaModel> getComidas() {
		return comidas;
	}
	public void setComidas(ArrayList<ComidaModel> comidas) {
		this.comidas = comidas;
	}


	
	
	
}
