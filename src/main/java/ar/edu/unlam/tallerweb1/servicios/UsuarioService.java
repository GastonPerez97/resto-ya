package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioAgregarUsuario;

public interface UsuarioService {
	
	public void guardarUsuario(UsuarioModel usuario);
	
	public void modificarUsuario(UsuarioModel usuario);
	
	public void eliminarUsuarioPorId(Long id);

	public List<UsuarioModel> listarUsuarios();

	public Boolean existeUsuarioPorNombre(String nombre);
	
	public Boolean existeUsuarioPorId(Long id);
	
	public Boolean existeUsuarioPorEmail(String email);
	
	public UsuarioModel buscarUsuarioPorId(Long id);
	
	public Boolean validarRegistroUsuario(FormularioAgregarUsuario formularioAgregarUsuario);

	public Boolean validarEliminarUsuario(Long id);
	

	

}
