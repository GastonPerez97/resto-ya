package ar.edu.unlam.tallerweb1.servicios;


import java.util.ArrayList;

import ar.edu.unlam.tallerweb1.modelo.PedidoModel;

public interface PedidoService {
	void guardarPedido(PedidoModel pedido);
	PedidoModel consultarPedidoPorId(Long id);
	PedidoModel cargarPedidoComida(ArrayList<Long> idComidas);

}
