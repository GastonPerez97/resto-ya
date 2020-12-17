package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.UsuarioRolModel;

public interface UsuarioRolService {
	
	public UsuarioRolModel buscarUsuarioRolPorId(Long id);
	
	void guardarUsuarioRol(Long idUsuario, Long idRol);

}
