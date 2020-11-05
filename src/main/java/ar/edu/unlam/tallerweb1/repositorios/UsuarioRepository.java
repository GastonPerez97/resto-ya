package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;

public interface UsuarioRepository {

	
	public void guardarUsuario (UsuarioModel usuario);
	
	public void modificarUsuario (UsuarioModel usuario);
	
	public void eliminarUsuarioPorId (Long id);

	public List<UsuarioModel> listarUsuarios();

	public UsuarioModel existeUsuarioPorNombre(String nombre);
	
	public UsuarioModel existeUsuarioPorId(Long id);
	
	public UsuarioModel existeUsuarioPorEmail(String email);

	public UsuarioModel buscarUsuarioPorId(Long id);

	
}
