package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.PedidoComidaModel;

public interface PedidoComidaService {

	void guardarPedidoComida(PedidoComidaModel pedidoComida);
	
	List<PedidoComidaModel> getComidasByPedido(Long idPedido);
}
