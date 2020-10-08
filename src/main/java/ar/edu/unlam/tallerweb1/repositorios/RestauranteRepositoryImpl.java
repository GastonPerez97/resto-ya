package ar.edu.unlam.tallerweb1.repositorios;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;

@Repository("restauranteRepository")
public class RestauranteRepositoryImpl implements RestauranteRepository {


	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public ArrayList<RestauranteModel> buscarRestaurantes() {
		final Session session = sessionFactory.getCurrentSession();
		return (ArrayList<RestauranteModel>) session.createCriteria(RestauranteModel.class).list();
	}

	@Override
	public RestauranteModel buscarRestaurantePorId(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		return session.get(RestauranteModel.class, id);
	}
	
}
