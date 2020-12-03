package ar.edu.unlam.tallerweb1.modelo.form;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;

public class FormularioPedido {

	private Long restaurante; 
	private String pedidoSinFormato;
	private Long idCliente;
	
	public FormularioPedido() {

	}
	
	public Long getRestaurante() {
		return restaurante;
	}
	
	public void setRestaurante(Long restaurante) {
		this.restaurante = restaurante;
	}

	public String getPedidoSinFormato() {
		return pedidoSinFormato;
	}

	public void setPedidoSinFormato(String pedidoSinFormato) {
		this.pedidoSinFormato = pedidoSinFormato;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

}
