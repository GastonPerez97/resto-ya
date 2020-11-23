package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ClienteModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoModel;

public interface PedidoRepository {
	void guardarPedido(PedidoModel pedido);

	PedidoModel consultarPedidoPorId(Long id);

	List<PedidoModel> buscarPedido();

	List<PedidoModel> buscarPedidoPorCliente(ClienteModel cliente);
	

}
