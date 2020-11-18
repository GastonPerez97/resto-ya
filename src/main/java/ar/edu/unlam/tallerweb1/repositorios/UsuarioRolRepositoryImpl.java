package ar.edu.unlam.tallerweb1.repositorios;


import java.util.List;

import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ar.edu.unlam.tallerweb1.modelo.UsuarioRolModel;


@Repository("usuarioRolRepository")
public class UsuarioRolRepositoryImpl implements UsuarioRolRepository {

	
	@Inject
	private SessionFactory sessionFactory;
	

	public UsuarioRolModel buscarUsuarioRolPorId(Long id) {
		return sessionFactory.getCurrentSession().get(UsuarioRolModel.class,id);
	}


	@Override
	public List<UsuarioRolModel> buscarRolesPorUsuario(Long idUsuario) {
		return sessionFactory.getCurrentSession().createCriteria(UsuarioRolModel.class)
				.add(Restrictions.eq("usuarioModel.idUsuario",idUsuario)).list();
	}


	@Override
	public void guardarUsuarioRol(Long idUsuario, Long idRol) {
		sessionFactory.getCurrentSession().createSQLQuery("insert into usuario_rol (id_rol, id_usuario) values ( :valor1, :valor2)")
		.setParameter("valor1", idRol)
		.setParameter("valor2", idUsuario)
		.executeUpdate();
		
	}




}
