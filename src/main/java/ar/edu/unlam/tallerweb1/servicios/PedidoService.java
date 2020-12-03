package ar.edu.unlam.tallerweb1.servicios;


import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.PedidoComidaModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoModel;

public interface PedidoService {
	void guardarPedido(PedidoModel pedido);
	PedidoModel consultarPedidoPorId(Long id);
	PedidoModel cargarPedidoComida(String pedidoSinFormato);
	Double calcularTotalPedido(List<PedidoComidaModel> pedidoComidaList);

}
