package ar.edu.unlam.tallerweb1.servicios;


import java.util.ArrayList;
import java.util.Arrays;
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
	public PedidoModel cargarPedidoComida(String pedidoSinFormato) {
        
		String[] comidasYCantidades = pedidoSinFormato.split(";");
		List<String> comidasYCantidadesList = Arrays.asList(comidasYCantidades);
		
		PedidoModel pedido = new PedidoModel();
		
		for (String comidaCantidad : comidasYCantidadesList) {
			PedidoComidaModel pedidoComida = new PedidoComidaModel();
			pedidoComida.setCantidad(Double.parseDouble(comidaCantidad.split("-")[1]));
			pedidoComida.setComidaModel(comidaService.consultarComidaPorId((Long.parseLong(comidaCantidad.split("-")[0]))));
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
