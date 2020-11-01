package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;
import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;

@Repository("usuarioRepository")
public class UsuarioRepositoryImpl implements UsuarioRepository {
	
	@Inject
	private SessionFactory sessionFactory;
	

	@Override
	public void guardarUsuario(UsuarioModel usuario) {
		sessionFactory.getCurrentSession().save(usuario);
	}

	@Override
	public void modificarUsuario(UsuarioModel usuario) {
		sessionFactory.getCurrentSession().update(usuario);
		
	}

	@Override
	public void eliminarUsuario(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		session.delete(session.get(UsuarioModel.class, id));
		
	}

	@Override
	public List<UsuarioModel> buscarUsuarios() {
		final Session session = sessionFactory.getCurrentSession();
		return (List<UsuarioModel>) session.createCriteria(UsuarioModel.class).list();
	}

	@Override
	public UsuarioModel existeUsuarioPorNombre(String nombre) {
		final Session session = sessionFactory.getCurrentSession();
		
		return (UsuarioModel) session.createCriteria(UsuarioModel.class)
			   .add(Restrictions.eq("nombre", nombre))
			   .uniqueResult();
	}

	@Override
	public UsuarioModel buscarUsuarioPorId(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		return session.get(UsuarioModel.class,id);
	}


	

}
