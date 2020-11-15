package ar.edu.unlam.tallerweb1.repositorios;

import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.ClienteModel;

@Repository("repositorioCliente")
public class ClienteRepositoryImpl implements ClienteRepository {

	public ClienteModel consultarClientePorId(Long id) {
		return null;
	}

	public void guardarCliente(ClienteModel cliente) {
	}

}
