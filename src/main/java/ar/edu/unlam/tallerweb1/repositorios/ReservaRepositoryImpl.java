package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import java.util.ArrayList;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.ReservaModel;

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
	
}
