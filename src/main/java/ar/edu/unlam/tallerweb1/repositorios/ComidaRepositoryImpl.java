package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;

@Repository("comidaRepository")
public class ComidaRepositoryImpl implements ComidaRepository {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public ComidaModel consultarComidaPorId(Long id) {
		return sessionFactory.getCurrentSession().get(ComidaModel.class, id);
	}
	
	@Override
	public List<ComidaModel> buscarComida() {
		return (ArrayList<ComidaModel>) sessionFactory.getCurrentSession()
				.createCriteria(ComidaModel.class).list();
	}
	
	@Override
	public List<ComidaModel> getComidasDisponiblesByRestaurante(Long idRestaurante) {
		return (ArrayList<ComidaModel>) sessionFactory.getCurrentSession()
				.createCriteria(ComidaModel.class)
				.add(Restrictions.eq("restaurante.idRestaurante", idRestaurante))
				.add(Restrictions.eq("disponible", true)).list();
	}

	@Override
	public void editarComida(ComidaModel comida) {
		sessionFactory.getCurrentSession().update(comida);
	}


	@Override
	public void eliminarComida(ComidaModel comida) {
		sessionFactory.getCurrentSession().delete(comida);
	}

	@Override
	public void guardarComidaEnDB(ComidaModel comida) {
		sessionFactory.getCurrentSession().save(comida);
	}
	
}
