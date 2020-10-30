package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import java.util.ArrayList;
import org.hibernate.Session;
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
	
	
	@Override
	public ArrayList<ComidaModel> buscarComida() {
		final Session session = sessionFactory.getCurrentSession();
		return (ArrayList<ComidaModel>) session.createCriteria(ComidaModel.class).list();
	}


	@Override
	public void editarComida(ComidaModel comida) {
		final Session session = sessionFactory.getCurrentSession();
		session.update(comida);
	}
	
}
