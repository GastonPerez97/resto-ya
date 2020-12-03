package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ar.edu.unlam.tallerweb1.modelo.CalificacionRestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioCalificacionRestaurante;

@Repository("repositorioCalificacion")
public class CalificacionRepositoryImpl implements CalificacionRepository {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public List<CalificacionRestauranteModel> buscarCalificaciones() {

		return sessionFactory.getCurrentSession().createCriteria(CalificacionRestauranteModel.class).list();
	}

	@Override
	public void guardarCalificaciones(FormularioCalificacionRestaurante calificacion) {
		sessionFactory.getCurrentSession().save(calificacion.getCalificacionRestaurante());
	}

	@Override
	public List<CalificacionRestauranteModel> buscarCalificacionPorRestaurante(RestauranteModel restaurante) {
		return sessionFactory
				.getCurrentSession().createCriteria(CalificacionRestauranteModel.class).add(Restrictions
						.eq("calificacionRestaurante.restauranteModel.idRestaurante", restaurante.getIdRestaurante()))
				.list();
	}

}
