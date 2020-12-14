package ar.edu.unlam.tallerweb1.servicios;


import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.PedidoComidaModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioPedido;

public interface PedidoService {
	
	PedidoModel procesarPedido(FormularioPedido formularioPedido);
	void guardarPedido(PedidoModel pedido);
	PedidoModel consultarPedidoPorId(Long id);
	PedidoModel cargarPedidoComida(String pedidoSinFormato);
	Double calcularTotalPedido(List<PedidoComidaModel> pedidoComidaList);
	void guardarNroReferencia(Long idPedido, Long nroReferencia);
	void cambiarEstadoDePedido(Long idPedido, Long idEstadoPedido);
	void generarFechaFinalizacionDe(Long idPedido);
	Integer[] convertirDeStringAIntegerA(String[] array);
	
}
