package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.MesaModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoComidaModel;


@Repository("pedidoComidaRepository")
public class PedidoComidaRepositoryImpl implements PedidoComidaRepository {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public void guardarPedidoComida(PedidoComidaModel pedidoComida) {
		sessionFactory.getCurrentSession().save(pedidoComida);
		
	}

	@Override
	public List<PedidoComidaModel> getComidasByPedido(Long idPedido) {
		return sessionFactory.getCurrentSession().createCriteria(PedidoComidaModel.class)
				.add(Restrictions.eq("pedidoModel.idPedido", idPedido)).list();
	}
	
}
