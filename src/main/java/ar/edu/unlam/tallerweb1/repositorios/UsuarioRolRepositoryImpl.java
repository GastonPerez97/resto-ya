package ar.edu.unlam.tallerweb1.repositorios;


import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ar.edu.unlam.tallerweb1.modelo.UsuarioRolModel;


@Repository("usuarioRolRepository")
public class UsuarioRolRepositoryImpl implements UsuarioRolRepository {

	
	@Inject
	private SessionFactory sessionFactory;
	

	public UsuarioRolModel buscarUsuarioRolPorId(Long id) {
		return sessionFactory.getCurrentSession().get(UsuarioRolModel.class,id);
	}

}
