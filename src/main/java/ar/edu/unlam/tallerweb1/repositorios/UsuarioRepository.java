package ar.edu.unlam.tallerweb1.repositorios;

import java.util.ArrayList;

import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;

public interface UsuarioRepository {

	
	public void guardarUsuario (UsuarioModel usuario);
	
	public void modificarUsuario (UsuarioModel usuario);
	
	public void eliminarUsuario (Long id);

	public ArrayList<UsuarioModel> buscarUsuarios();

	public UsuarioModel existeUsuarioPorNombre(String nombre);

	public UsuarioModel buscarUsuarioPorId(Long id);
	
}
