package ar.edu.unlam.tallerweb1.repositorios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.ClienteModel;
import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;

@Repository
@Transactional
public class PedidoRepositoryImpl implements PedidoRepository {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public void guardarPedido(PedidoModel pedido) {
		sessionFactory.getCurrentSession().save(pedido);

	}

	@Override
	public PedidoModel consultarPedidoPorId(Long id) {
		PedidoModel pedido = sessionFactory.getCurrentSession().get(PedidoModel.class, id);
		return pedido;
	}

	@Override
	public List<PedidoModel> buscarPedido() {
		return (ArrayList<PedidoModel>) sessionFactory.getCurrentSession().createCriteria(PedidoModel.class).list();
	}

	@Override
	public List<PedidoModel> buscarPedidoPorCliente(ClienteModel cliente) {
		return sessionFactory.getCurrentSession().createCriteria(PedidoModel.class)
				.add(Restrictions.eq("clienteModel.idCliente", cliente.getIdCliente())).list();
	}

	@Override
	public List<PedidoModel> buscarPedidosClienteOrdenadosPorFecha(ClienteModel cliente) {
		return sessionFactory.getCurrentSession().createCriteria(PedidoModel.class)
				.add(Restrictions.eq("clienteModel.idCliente", cliente.getIdCliente()))
				.addOrder(Order.desc("fechaPedido"))
				.list();
	}

	@Override
	public List<PedidoModel> buscarPedidosRestauranteOrdenadosPorFecha(Long idRestaurante) {
		return sessionFactory.getCurrentSession().createCriteria(PedidoModel.class)
				.add(Restrictions.eq("restaurante.idRestaurante", idRestaurante))
				.addOrder(Order.desc("fechaPedido"))
				.list();
	}

}
