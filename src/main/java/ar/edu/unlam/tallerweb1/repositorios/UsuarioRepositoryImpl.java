package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioAgregarUsuario;

@Repository("usuarioRepository")
public class UsuarioRepositoryImpl implements UsuarioRepository {
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public UsuarioModel consultarUsuario(UsuarioModel usuario) {

		// Se obtiene la sesion asociada a la transaccion iniciada en el servicio que invoca a este metodo y se crea un criterio
		// de busqueda de Usuario donde el email y password sean iguales a los del objeto recibido como parametro
		// uniqueResult da error si se encuentran más de un resultado en la busqueda.
		final Session session = sessionFactory.getCurrentSession();
		return (UsuarioModel) session.createCriteria(UsuarioModel.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.add(Restrictions.eq("clave", usuario.getClave()))
				.uniqueResult();
	}

	@Override
	public void guardarUsuario(UsuarioModel usuario) {
		sessionFactory.getCurrentSession().save(usuario);
	}

	public void modificarUsuario(UsuarioModel usuario) {
		sessionFactory.getCurrentSession().update(usuario);
	}

	@Override
	public void eliminarUsuarioPorId(Long id) {
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(UsuarioModel.class, id));
	}

	@Override
	public List<UsuarioModel> listarUsuarios() {
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
	public UsuarioModel existeUsuarioPorEmail(String email) {
		return (UsuarioModel) sessionFactory.getCurrentSession().createCriteria(UsuarioModel.class)
				   .add(Restrictions.eq("email", email))
				   .uniqueResult();
	}
	
	@Override
	public UsuarioModel buscarUsuarioPorId(Long id) {
		return sessionFactory.getCurrentSession().get(UsuarioModel.class,id);
	}




	

}
