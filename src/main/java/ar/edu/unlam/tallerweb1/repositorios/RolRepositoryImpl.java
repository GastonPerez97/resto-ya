package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;
import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ar.edu.unlam.tallerweb1.modelo.RolModel;

@Repository("rolRepository")
public class RolRepositoryImpl implements RolRepository {
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public RolModel consultarRolPorId(Long id) {
		return sessionFactory.getCurrentSession().get(RolModel.class, id);
	}
	
	@Override
	public List<RolModel> listarRoles() {
		return (List<RolModel>) sessionFactory.getCurrentSession()
				.createCriteria(RolModel.class).list();
	}

}
