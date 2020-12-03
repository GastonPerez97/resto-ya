package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.ClienteModel;
import ar.edu.unlam.tallerweb1.modelo.MesaModel;

@Repository("repositorioCliente")
public class ClienteRepositoryImpl implements ClienteRepository {

	@Inject
	private SessionFactory sessionFactory;

	public ClienteModel consultarClientePorId(Long id) {
		return null;
	}

	public void guardarCliente(ClienteModel cliente) {
		sessionFactory.getCurrentSession().save(cliente);
	}

	@Override
	public List<ClienteModel> buscarCliente() {

		return sessionFactory.getCurrentSession().createCriteria(ClienteModel.class).list();
	}

	@Override
	public ClienteModel getClienteByUsuario(Long idUsuario) {
		return (ClienteModel) sessionFactory.getCurrentSession().createCriteria(ClienteModel.class)
				.add(Restrictions.eq("usuario.idUsuario", idUsuario))
				.uniqueResult();
	}

}
