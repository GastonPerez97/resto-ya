package ar.edu.unlam.tallerweb1.repositorios;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;

@Repository("comidaRepository")
public class ComidaRepositoryImpl implements ComidaRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public ArrayList<ComidaModel> buscarComida() {
		final Session session = sessionFactory.getCurrentSession();
		return (ArrayList<ComidaModel>) session.createCriteria(ComidaModel.class).list();
	}
	
}
