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

	public void modificarUsuario(UsuarioModel usuario) {
		sessionFactory.getCurrentSession().update(usuario);
		
	}

	@Override
	public void eliminarUsuario(Long id) {
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(UsuarioModel.class, id));
	}

	@Override
	public List<UsuarioModel> buscarUsuarios() {
		return (List<UsuarioModel>) sessionFactory.getCurrentSession().createCriteria(UsuarioModel.class).list();
	}

	@Override
	public UsuarioModel existeUsuarioPorNombre(String nombre) {
		return (UsuarioModel) sessionFactory.getCurrentSession().createCriteria(UsuarioModel.class)
			   .add(Restrictions.eq("nombreDeUsuario", nombre))
			   .uniqueResult();
	}

	@Override
	public UsuarioModel existeUsuarioPorId(Long id) {
		return (UsuarioModel) sessionFactory.getCurrentSession().createCriteria(UsuarioModel.class)
				   .add(Restrictions.eq("idUsuario", id))
				   .uniqueResult();
	}
	
	@Override
	public UsuarioModel buscarUsuarioPorId(Long id) {
		return sessionFactory.getCurrentSession().get(UsuarioModel.class,id);
	}




	

}
