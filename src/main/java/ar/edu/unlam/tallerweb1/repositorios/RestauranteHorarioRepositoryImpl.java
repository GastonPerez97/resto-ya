package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.type.StandardBasicTypes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.MesaModel;
import ar.edu.unlam.tallerweb1.modelo.ReservaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteHorarioModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioGeneracionReserva;

@Repository("restauranteHorarioRepository")
public class RestauranteHorarioRepositoryImpl implements RestauranteHorarioRepository {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public RestauranteHorarioModel getRestauranteHorarioById(Long idRestauranteHorario) {
		return sessionFactory.getCurrentSession().get(RestauranteHorarioModel.class, idRestauranteHorario);
	}

	@Override
	public void guardarRestauranteHorario(RestauranteHorarioModel restauranteHorarioModel) {
		sessionFactory.getCurrentSession().save(restauranteHorarioModel);
	}
}
