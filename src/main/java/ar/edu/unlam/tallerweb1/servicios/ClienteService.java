package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ClienteModel;
import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioRegistro;
import ar.edu.unlam.tallerweb1.modelo.resultadoBusqueda.ResultadoRegistro;

// Interface que define los metodos del Servicio de Usuarios.
public interface ClienteService {

	ResultadoRegistro consultarClienteRegistrado(FormularioRegistro registro);

	void guardarClienteRegistrado(FormularioRegistro registro);

	public List<PedidoModel> buscarPedidosCliente(ClienteModel cliente);

	List<ClienteModel> buscarClientes();
	
	public List<PedidoModel> buscarPedidosClienteOrdenadosPorFecha(ClienteModel cliente);
	
	ClienteModel buscarClienteLogueado(Long idUsuario);

}
