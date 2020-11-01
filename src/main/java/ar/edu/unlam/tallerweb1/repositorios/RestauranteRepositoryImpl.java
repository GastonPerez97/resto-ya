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
		return (ArrayList<RestauranteModel>) sessionFactory.getCurrentSession()
				.createCriteria(RestauranteModel.class).list();
	}

	@Override
	public RestauranteModel buscarRestaurantePorId(Long id) {
		return sessionFactory.getCurrentSession().get(RestauranteModel.class, id);
	}
	
	@Override
	public ArrayList<RestauranteModel> buscarRestaurantePorNombre(String nombre) {
		return (ArrayList<RestauranteModel>) sessionFactory.getCurrentSession()
				.createCriteria(RestauranteModel.class).list();
	}
	
	@Override
	public List<ComidaModel> buscarMenuPorRestaurante(RestauranteModel restaurante) {
		return sessionFactory.getCurrentSession().createCriteria(ComidaModel.class)
					.add(Restrictions.eq("restaurante", restaurante))
					.list();
	}
	
	@Override
	public RestauranteModel buscarRestaurantePorDireccion(String direccion) {
		return (RestauranteModel) sessionFactory.getCurrentSession()
			   .createCriteria(RestauranteModel.class)
			   .add(Restrictions.eq("direccion", direccion))
			   .uniqueResult();
	}

	@Override
	public void guardarRestaurante(RestauranteModel restaurante) {
		sessionFactory.getCurrentSession().save(restaurante);
	}
	
	@Override
	public void editarRestaurante(RestauranteModel restaurante) {
		sessionFactory.getCurrentSession().update(restaurante);
	}

	@Override
	public void eliminarRestaurante(RestauranteModel restaurante) {
		sessionFactory.getCurrentSession().delete(restaurante);		
	}
	
}
