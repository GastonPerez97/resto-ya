package ar.edu.unlam.tallerweb1.repositorios;


import ar.edu.unlam.tallerweb1.modelo.PedidoModel;

public interface PedidoRepository {
	void guardarPedido(PedidoModel pedido);
	PedidoModel consultarPedidoPorId(Long id);
	
	
	
	

}
