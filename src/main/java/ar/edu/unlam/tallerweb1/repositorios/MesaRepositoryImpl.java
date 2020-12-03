package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.MesaModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioNuevaMesa;

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

	@Override
	public Integer getMaximaUbicacionFilaByRestaurante(Long idRestaurante) {
		return (Integer)sessionFactory.getCurrentSession().createCriteria(MesaModel.class)
				.setProjection(Projections.max("ubicacionFila"))
				.add(Restrictions.eq("restaurante.idRestaurante", idRestaurante))
				.uniqueResult();
	}

	@Override
	public Integer getMaximaUbicacionColumnaByRestaurante(Long idRestaurante) {
		return (Integer)sessionFactory.getCurrentSession().createCriteria(MesaModel.class)
				.setProjection(Projections.max("ubicacionColumna"))
				.add(Restrictions.eq("restaurante.idRestaurante", idRestaurante))
				.uniqueResult();
	}

	@Override
	public Boolean existeMesaEnRestauranteByNumero(FormularioNuevaMesa formularioNuevaMesa) {
		MesaModel mesa = (MesaModel) sessionFactory.getCurrentSession().createCriteria(MesaModel.class)
				.add(Restrictions.eq("restaurante.idRestaurante", formularioNuevaMesa.getIdRestaurante()))
				.add(Restrictions.eq("numeroDeMesa", formularioNuevaMesa.getNumeroDeMesa()))				
				.uniqueResult();
		
		return mesa != null;
	}

	@Override
	public Boolean existeMesaEnRestauranteByFilaYColumna(FormularioNuevaMesa formularioNuevaMesa) {
		MesaModel mesa = (MesaModel) sessionFactory.getCurrentSession().createCriteria(MesaModel.class)
				.add(Restrictions.eq("restaurante.idRestaurante", formularioNuevaMesa.getIdRestaurante()))
				.add(Restrictions.eq("ubicacionFila", formularioNuevaMesa.getUbicacionFila()))				
				.add(Restrictions.eq("ubicacionColumna", formularioNuevaMesa.getUbicacionColumna()))				
				.uniqueResult();
		
		return mesa != null;

	}
	
}
