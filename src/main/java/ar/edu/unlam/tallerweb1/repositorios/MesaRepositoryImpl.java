package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.MesaModel;

@Repository("mesaRepository")
public class MesaRepositoryImpl implements MesaRepository {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public List<MesaModel> getMesasByRestaurante(Long idRestaurante) {
		return sessionFactory.getCurrentSession().createCriteria(MesaModel.class)
				.add(Restrictions.eq("restaurante.idRestaurante", idRestaurante)).list();
	}

	@Override
	public MesaModel getMesaById(Long idMesa) {
		return sessionFactory.getCurrentSession().get(MesaModel.class, idMesa);
	}

	@Override
	public void guardarMesa(MesaModel mesa) {
		sessionFactory.getCurrentSession().save(mesa);
	}
	
}
