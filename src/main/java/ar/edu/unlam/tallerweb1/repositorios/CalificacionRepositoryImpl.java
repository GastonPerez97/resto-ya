package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.CalificacionComidaModel;
import ar.edu.unlam.tallerweb1.modelo.CalificacionRestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioCalificacionComida;
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
	public List<CalificacionComidaModel> buscarCalificacionesComidas() {
		return sessionFactory.getCurrentSession().createCriteria(CalificacionComidaModel.class).list();

	}

	@Override
	public void guardarCalificaciones(FormularioCalificacionRestaurante calificacion) {
		sessionFactory.getCurrentSession().save(calificacion.getCalificacionRestaurante());
	}

	@Override
	public void guardarCalificacionesComida(FormularioCalificacionComida formularioCalificacionComida) {
		sessionFactory.getCurrentSession().save(formularioCalificacionComida.getCalificacionComida());

	}

	@Override
	public List<CalificacionRestauranteModel> buscarCalificacionDelRestaurante(RestauranteModel restaurante) {
		return sessionFactory.getCurrentSession().createCriteria(RestauranteModel.class)
				.add(Restrictions.eq("idRestaurante", restaurante.getIdRestaurante())).list();
	}

	@Override
	public List<CalificacionRestauranteModel> buscarCalificacionPorRestaurante(Long idRestaurante) {
		return sessionFactory.getCurrentSession().createCriteria(CalificacionRestauranteModel.class)
				.add(Restrictions.eq("restauranteModel.idRestaurante", idRestaurante)).list();
	}

	@Override
	public List<CalificacionRestauranteModel> getCalificacionByRestaurante(Long idRestaurante) {
		return sessionFactory.getCurrentSession().createCriteria(CalificacionRestauranteModel.class)
				.add(Restrictions.eq("restauranteModel.idRestaurante", idRestaurante)).list();
	}

	@Override
	public Integer getPromedioCalificacionDeRestaurante(Long idRestaurante) {
		return (int) Math
				.ceil((double) sessionFactory.getCurrentSession().createCriteria(CalificacionRestauranteModel.class)
						.setProjection(Projections.avg("calificacionRestauranteModel.valor"))
						.add(Restrictions.eq("restauranteModel.idRestaurante", idRestaurante)).uniqueResult());
	}

	@Override
	public List<CalificacionComidaModel> getCalificacionByComida(Long idComida) {
		return sessionFactory.getCurrentSession().createCriteria(CalificacionComidaModel.class)
				.add(Restrictions.eq("comidaModel.idComida", idComida)).list();
	}

	@Override
	public Integer getPromedioCalificacionDeComida(Long idComida) {
		return (int) Math.ceil((double) sessionFactory.getCurrentSession().createCriteria(CalificacionComidaModel.class)
				.setProjection(Projections.avg("calificacionComidaModel.valor"))
				.add(Restrictions.eq("comidaModel.idComida", idComida)).uniqueResult());
	}

}
