package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoComidaModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoModel;
import ar.edu.unlam.tallerweb1.repositorios.PedidoComidaRepository;

@Service
@Transactional
public class PedidoComidaServiceImpl implements PedidoComidaService{

	@Inject
	private PedidoComidaRepository repositorioPedidoComida;
	
	public void guardarPedidoComida(PedidoComidaModel pedidoComida) {
		repositorioPedidoComida.guardarPedidoComida(pedidoComida);
		
	}

	@Override
	public List<PedidoComidaModel> getComidasByPedido(Long idPedido) {
		return repositorioPedidoComida.getComidasByPedido(idPedido);
	}
	
}
