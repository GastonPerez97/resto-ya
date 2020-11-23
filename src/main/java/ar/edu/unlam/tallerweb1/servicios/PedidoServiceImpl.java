package ar.edu.unlam.tallerweb1.servicios;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoComidaModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoModel;
import ar.edu.unlam.tallerweb1.repositorios.PedidoRepository;

@Service
@Transactional
public class PedidoServiceImpl implements PedidoService {

	@Inject
	private PedidoRepository repositorioPedido;
	
	
	@Inject
	private ComidaService comidaService;
	
	
	@Override
	public void guardarPedido(PedidoModel pedido) {
		repositorioPedido.guardarPedido(pedido);

	}

	@Override
	public PedidoModel consultarPedidoPorId(Long id) {
		return repositorioPedido.consultarPedidoPorId(id);
	}

	@Override
	public PedidoModel cargarPedidoComida(ArrayList<Long> idComidas) {
		
		List<ComidaModel> comidas = comidaService.mostrarComidaPedida(idComidas);	
		PedidoModel pedido = new PedidoModel();
		
		for (ComidaModel comida : comidas) {
			PedidoComidaModel pedidoComida = new PedidoComidaModel();
			pedidoComida.setCantidad(0d);
			pedidoComida.setComidaModel(comida);
			pedidoComida.setPedidoModel(pedido);
			pedido.getPedidoComida().add(pedidoComida);
		}
	
		return pedido;
	}

	@Override
	public Double calcularTotalPedido(List<PedidoComidaModel> pedidoComidaList) {
		Double total = 0D;
		for (PedidoComidaModel pedidoComidaModel : pedidoComidaList)
			total += (pedidoComidaModel.getComidaModel().getPrecio() * pedidoComidaModel.getCantidad());
		
		return total;
	}


}
