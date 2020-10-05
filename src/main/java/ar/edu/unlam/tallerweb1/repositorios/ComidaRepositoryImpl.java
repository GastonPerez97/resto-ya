package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;

@Repository("comidaRepository")
public class ComidaRepositoryImpl implements ComidaRepository {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public ComidaModel consultarComidaPorId(Long id) {
		return sessionFactory.getCurrentSession().get(ComidaModel.class, id);
	}
	
	
}
