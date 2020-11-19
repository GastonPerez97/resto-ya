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
		registro.getClienteModel().setUsuario(registro.getUsuarioModel());
		clienteRepository.guardarCliente(registro.getClienteModel());

	}

	@Override
	public ResultadoRegistro consultarClienteRegistrado(FormularioRegistro registro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidoModel> buscarPedidosCliente(ClienteModel cliente) {

		return  pedidoRepository.buscarPedidoPorCliente(cliente);

		
	}

	@Override
	public List<ClienteModel> buscarClientes() {

		return clienteRepository.buscarCliente();
	}

}