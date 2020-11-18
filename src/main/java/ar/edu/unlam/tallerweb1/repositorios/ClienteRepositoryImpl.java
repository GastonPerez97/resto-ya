package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.ClienteModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoModel;

@Repository("repositorioCliente")
public class ClienteRepositoryImpl implements ClienteRepository {

	@Inject
	private SessionFactory sessionFactory;

	public ClienteModel consultarClientePorId(Long id) {
		return null;
	}

	public void guardarCliente(ClienteModel cliente) {
	}

	/*
	 * @Override public List<PedidoModel> consultarPedidosPorCliente(Long
	 * id_cliente) { return
	 * essionFactory.getCurrentSession().createCriteria(Restrictions("idCliente",
	 * id_cliente)).list();
	 * 
	 * }
	 */
	/*
	 * @Override public List<PedidoModel> consultarPedidoPorCliente(Long id_cliente)
	 * { PedidoModel list =
	 * sessionFactory.getCurrentSession().get(PedidoModel.class, 1L); return
	 * (List<PedidoModel>) list; }
	 */

	/*
	 * @Override public List<PedidoModel> consultarPedidoPorCliente(Long id_cliente)
	 * {
	 * 
	 * return sessionFactory.getCurrentSession().createCriteria(PedidoModel.class)
	 * .add(Restrictions.eq("clienteModel", 10L)).list();
	 * 
	 * 
	 * }
	 */

}
