package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.ClienteModel;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository("repositorioCliente")

public class ClienteRepositoryImpl implements ClienteRepository {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public ClienteModel consultarClientePorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarCliente(ClienteModel cliente) {
		sessionFactory.getCurrentSession().save(cliente);

	}

}