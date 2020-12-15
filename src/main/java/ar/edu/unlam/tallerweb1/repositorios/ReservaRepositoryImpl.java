package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
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
import ar.edu.unlam.tallerweb1.modelo.PedidoModel;
import ar.edu.unlam.tallerweb1.modelo.ReservaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteHorarioModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioGeneracionReserva;

@Repository("reservaRepository")
public class ReservaRepositoryImpl implements ReservaRepository {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public void guardarReserva(ReservaModel reservaModel) {
		sessionFactory.getCurrentSession().save(reservaModel);
	}

	@Override
	public ReservaModel getReservaByIdReserva(Long idReserva) {
		return sessionFactory.getCurrentSession().get(ReservaModel.class, idReserva);
	}

	@Override
	public List<RestauranteHorarioModel> getHorariosDisponiblesParaReservaDeMesa(
			FormularioGeneracionReserva formularioGeneracionReserva) {
		List<RestauranteHorarioModel> lista;
		
		List<Long> idsReservados = 
				sessionFactory.getCurrentSession().createSQLQuery("select id_restaurante_horario from reserva "
						+ "where fecha_reserva = ? and id_mesa = ? and id_estado_reserva != ?")
				.setParameter(1, formularioGeneracionReserva.getFechaReserva())
				.setParameter(2, formularioGeneracionReserva.getIdMesa())
				.setParameter(3, 3L)
		        .addScalar("id_restaurante_horario", StandardBasicTypes.LONG).list();
		
		MesaModel mesa = sessionFactory.getCurrentSession().get(MesaModel.class, formularioGeneracionReserva.getIdMesa());
				
		if (!idsReservados.isEmpty()) {
			lista = sessionFactory.getCurrentSession().createCriteria(RestauranteHorarioModel.class)
					.add(Restrictions.not(Restrictions.in("idRestauranteHorario", idsReservados)))
					.add(Restrictions.disjunction()
							.add(Restrictions.eq("restauranteModel.idRestaurante", mesa.getRestaurante().getIdRestaurante())))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)  
		 			.list();
		} else {
			lista = sessionFactory.getCurrentSession().createCriteria(RestauranteHorarioModel.class)
					.add(Restrictions.eq("restauranteModel.idRestaurante", mesa.getRestaurante().getIdRestaurante()))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)  
		 			.list();
		}

		return lista;
	}

	@Override
	public List<ReservaModel> getReservasByClienteOrderByFechaDescendiente(Long idCliente) {
		return sessionFactory.getCurrentSession().createCriteria(ReservaModel.class)
				.add(Restrictions.eq("clienteModel.idCliente", idCliente))
				.addOrder(Order.desc("fechaReserva"))
				.list();
	}
	
}
