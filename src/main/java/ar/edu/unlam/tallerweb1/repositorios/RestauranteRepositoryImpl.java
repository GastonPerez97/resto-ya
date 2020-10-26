package ar.edu.unlam.tallerweb1.repositorios;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
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
	
	@Override
	public ArrayList<RestauranteModel> buscarRestaurantePorNombre(String nombre) {
		final Session session = sessionFactory.getCurrentSession();
		return (ArrayList<RestauranteModel>) session.createCriteria(RestauranteModel.class).list();
	}
	
	@Override
	public List<ComidaModel> buscarMenuPorRestaurante(RestauranteModel restaurante) {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(ComidaModel.class)
					.add(Restrictions.eq("restaurante", restaurante))
					.list();
	}
	
	@Override
	public RestauranteModel buscarRestaurantePorDireccion(String direccion) {
		final Session session = sessionFactory.getCurrentSession();
		
		return (RestauranteModel) session.createCriteria(RestauranteModel.class)
			   .add(Restrictions.eq("direccion", direccion))
			   .uniqueResult();
	}

	@Override
	public void guardarRestaurante(RestauranteModel restaurante) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(restaurante);
	}
	
	@Override
	public void editarRestaurante(RestauranteModel restaurante) {
		final Session session = sessionFactory.getCurrentSession();
		session.update(restaurante);
	}
	
}
