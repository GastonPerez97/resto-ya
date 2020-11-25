package ar.edu.unlam.tallerweb1.modelo.form;

import ar.edu.unlam.tallerweb1.modelo.PedidoModel;
import ar.edu.unlam.tallerweb1.modelo.ReclamoModel;

public class FormularioGeneracionReclamo {
	
	private ReclamoModel reclamo = new ReclamoModel();
	private PedidoModel pedido;
	
	
	public ReclamoModel getReclamo() {
		return reclamo;
	}
	public void setReclamo(ReclamoModel reclamo) {
		this.reclamo = reclamo;
	}
	
	public PedidoModel getPedido() {
		return pedido;
	}
	public void setPedido(PedidoModel idPedido) {
		this.pedido = idPedido;
	}

	
	

}
