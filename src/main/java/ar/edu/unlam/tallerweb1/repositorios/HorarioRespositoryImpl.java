package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.HorarioModel;
import ar.edu.unlam.tallerweb1.modelo.MesaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteHorarioModel;

@Repository("horarioRepository")
public class HorarioRespositoryImpl implements HorarioRespository {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<HorarioModel> getHorariosByRestaurante(Long idRestaurante) {
		//TODO
		return sessionFactory.getCurrentSession().createCriteria(HorarioModel.class).list();
	}
	
	@Override
	public List<HorarioModel> getHorariosNoAsignadosARestaurante(Long idRestaurante) {
		
		List<Long> idsReservados = 
				sessionFactory.getCurrentSession().createSQLQuery("select id_horario from restaurante_horario "
						+ "where id_restaurante = ?")
				.setParameter(1, idRestaurante)
		        .addScalar("id_horario", StandardBasicTypes.LONG).list();
		
		return sessionFactory.getCurrentSession().createCriteria(HorarioModel.class)
				.add(Restrictions.not(Restrictions.in("idHorario", idsReservados)))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)  
	 			.list();
	}
	
	@Override
	public HorarioModel getHorarioById(Long idHorario) {
		return sessionFactory.getCurrentSession().get(HorarioModel.class, idHorario);
	}
	
}
