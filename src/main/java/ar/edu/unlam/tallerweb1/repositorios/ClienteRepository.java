package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ClienteModel;

public interface ClienteRepository {

	ClienteModel consultarClientePorId(Long id);

	void guardarCliente(ClienteModel cliente);

	List<ClienteModel> buscarCliente();
	
	ClienteModel getClienteByUsuario(Long idUsuario);

}
