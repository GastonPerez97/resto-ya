package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		return (ReclamoModel) sessionFactory.getCurrentSession().createCriteria(ReclamoModel.class)
				.add(Restrictions.eq("pedido.idPedido", idPedido))
				.uniqueResult();
	}

	@Override
	public void actualizarReclamo(ReclamoModel reclamo) {
		sessionFactory.getCurrentSession().update(reclamo);	
	}



}
