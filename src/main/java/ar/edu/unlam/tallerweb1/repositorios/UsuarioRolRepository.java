package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.UsuarioRolModel;

public interface UsuarioRolRepository {
	
	UsuarioRolModel buscarUsuarioRolPorId(Long id);
	
	List<UsuarioRolModel> buscarRolesPorUsuario(Long idUsuario);
	

}
