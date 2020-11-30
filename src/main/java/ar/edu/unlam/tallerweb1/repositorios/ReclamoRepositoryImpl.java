package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.ReclamoModel;

@Repository
@Transactional
public class ReclamoRepositoryImpl implements ReclamoRepository {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public void guardarReclamo(ReclamoModel reclamo) {
		sessionFactory.getCurrentSession().save(reclamo);	
	}

	@Override
	public ReclamoModel buscarReclamoPorIdPedido(Long idPedido) {
		return sessionFactory.getCurrentSession().get(ReclamoModel.class,idPedido);
	}



}
