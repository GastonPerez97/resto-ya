package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;

public interface UsuarioService {
	
	public void guardarUsuario(UsuarioModel usuario);
	
	public void modificarUsuario(UsuarioModel usuario);
	
	public void eliminarUsuario(Long id);

	public List<UsuarioModel> buscarUsuarios();

	public Boolean existeUsuarioPorNombre(String nombre);
	
	public Boolean existeUsuarioPorId(Long id);
	
	public UsuarioModel buscarUsuarioPorId(Long id);


}
