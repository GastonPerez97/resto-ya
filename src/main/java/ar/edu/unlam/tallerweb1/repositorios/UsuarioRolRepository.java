package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.UsuarioRolModel;

public interface UsuarioRolRepository {
	
	List<UsuarioRolModel> buscarUsuarioRolPorId(Long id);
	
	List<UsuarioRolModel> buscarRolesPorUsuario(Long idUsuario);

	void guardarUsuarioRol(Long idUsuario, Long idRol);
	

}
