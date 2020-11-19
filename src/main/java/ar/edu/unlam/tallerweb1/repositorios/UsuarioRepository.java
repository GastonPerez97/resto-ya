package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioAgregarUsuario;

public interface UsuarioRepository {

	public UsuarioModel consultarUsuario (UsuarioModel usuario);
	
	public void guardarUsuario (UsuarioModel usuario);
	
	public void modificarUsuario (UsuarioModel usuario);
	
	public void eliminarUsuarioPorId (Long id);

	public List<UsuarioModel> listarUsuarios();

	public UsuarioModel existeUsuarioPorNombre(String nombre);
	
	public UsuarioModel existeUsuarioPorId(Long id);
	
	public UsuarioModel existeUsuarioPorEmail(String email);

	public UsuarioModel buscarUsuarioPorId(Long id);

	
}
