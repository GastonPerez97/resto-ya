package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.PedidoComidaModel;

public interface PedidoComidaRepository {

	void guardarPedidoComida(PedidoComidaModel pedidoComida);
	List<PedidoComidaModel> getComidasByPedido(Long idPedido);
	
}
