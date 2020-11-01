package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;

public interface UsuarioRepository {

	
	public void guardarUsuario (UsuarioModel usuario);
	
	public void modificarUsuario (UsuarioModel usuario);
	
	public void eliminarUsuario (Long id);

	public List<UsuarioModel> buscarUsuarios();

	public UsuarioModel existeUsuarioPorNombre(String nombre);

	public UsuarioModel buscarUsuarioPorId(Long id);

	
}
