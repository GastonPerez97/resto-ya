package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.CalificacionModel;
import ar.edu.unlam.tallerweb1.modelo.ClienteModel;

@Repository("repositorioCalificacion")
public class CalificacionRepositoryImpl implements CalificacionRepository {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public List<CalificacionModel> buscarCalificaciones() {

		return sessionFactory.getCurrentSession().createCriteria(CalificacionModel.class).list();
	}

	@Override
	public void guardarCalificaciones(CalificacionModel calificacion) {
		sessionFactory.getCurrentSession().createCriteria(CalificacionModel.class).list();
		
	}

}
