package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.PedidoComidaModel;


@Repository("pedidoComidaRepository")
public class PedidoComidaRepositoryImpl implements PedidoComidaRepository {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public void guardarPedidoComida(PedidoComidaModel pedidoComida) {
		sessionFactory.getCurrentSession().save(pedidoComida);
		
	}
	
}
