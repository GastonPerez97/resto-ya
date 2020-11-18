package ar.edu.unlam.tallerweb1.servicios;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.repositorios.ClienteRepository;
import ar.edu.unlam.tallerweb1.repositorios.PedidoRepository;
import ar.edu.unlam.tallerweb1.modelo.ClienteModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioRegistro;
import ar.edu.unlam.tallerweb1.modelo.resultadoBusqueda.ResultadoRegistro;

@Service("servicioCliente")
@Transactional
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public void guardarClienteRegistrado(FormularioRegistro registro) {
		registro.getClienteBuscado().setUsuario(registro.getDatoBuscado());
		clienteRepository.guardarCliente(registro.getClienteBuscado());

	}

	@Override
	public ResultadoRegistro consultarClienteRegistrado(FormularioRegistro registro) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public PedidoModel consultarPedidosPorCliente(ClienteModel cliente)
	 * { return (PedidoModel)
	 * clienteRepository.consultarPedidoPorCliente(cliente.getIdCliente());
	 * 
	 * }
	 */

	@Override
	public List<PedidoModel> buscarPedidosCliente(ClienteModel cliente) {

		List<PedidoModel> pedidos = new LinkedList<PedidoModel>();
		List<PedidoModel> pedidoDB = pedidoRepository.buscarPedido();
		for (PedidoModel pedidos1 : pedidoDB) {
			if (pedidos1.getCliente().getIdCliente().equals(cliente.getIdCliente()))
				pedidos.add(pedidos1);
		}

		return pedidos;
	}

}