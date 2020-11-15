package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.ClienteModel;

public interface ClienteRepositoryImpl {

	ClienteModel consultarClientePorId(Long id);
	
	void guardarCliente(ClienteModel cliente);

}
