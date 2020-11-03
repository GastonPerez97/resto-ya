package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;

public interface UsuarioService {
	
	public void guardarUsuario(UsuarioModel usuario);
	
	public void modificarUsuario(UsuarioModel usuario);
	
	public void eliminarUsuarioPorId(Long id);

	public List<UsuarioModel> listarUsuarios();

	public Boolean existeUsuarioPorNombre(String nombre);
	
	public Boolean existeUsuarioPorId(Long id);
	
	public UsuarioModel buscarUsuarioPorId(Long id);
	
	public ModelAndView validarUsuario(UsuarioModel usuario);

	public ModelAndView validarEliminarUsuario(Long id);
	

}
