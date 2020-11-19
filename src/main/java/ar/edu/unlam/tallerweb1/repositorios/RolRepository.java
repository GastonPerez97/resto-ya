package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.RolModel;

public interface RolRepository {

	public RolModel consultarRolPorId(Long id);
	
	public List<RolModel> listarRoles();
	

}
