package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;
import ar.edu.unlam.tallerweb1.repositorios.UsuarioRepository;

@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Inject
	private UsuarioRepository usuarioRepository;
	

	@Override
	public void guardarUsuario(UsuarioModel usuario) {
		usuarioRepository.guardarUsuario(usuario);

	}

	@Override
	public void modificarUsuario(UsuarioModel usuario) {
		usuarioRepository.modificarUsuario(usuario);

	}

	@Override
	public void eliminarUsuarioPorId(Long id) {
		usuarioRepository.eliminarUsuarioPorId(id);

	}

	@Override
	public List<UsuarioModel> listarUsuarios() {
		return usuarioRepository.listarUsuarios();
	}

	@Override
	public Boolean existeUsuarioPorNombre(String nombre) {
		Boolean existe = false;

		if (usuarioRepository.existeUsuarioPorNombre(nombre) != null)
			existe = true;
		return existe;
	}
	
	@Override
	public Boolean existeUsuarioPorId(Long id) {
		Boolean existe = false;

		if (usuarioRepository.existeUsuarioPorId(id) != null)
			existe = true;
		return existe;
	}
	
	@Override
	public Boolean existeUsuarioPorEmail(String email) {
		Boolean existe = false;

		if (usuarioRepository.existeUsuarioPorEmail(email) != null)
			existe = true;
		return existe;
	}

	@Override
	public UsuarioModel buscarUsuarioPorId(Long id) {
		return usuarioRepository.buscarUsuarioPorId(id);
	}

	@Override
	public ModelAndView validarUsuario(UsuarioModel usuario) {
		ModelMap modelo = new ModelMap();

		modelo.put("titulo", "Agregar Usuario");

		if (existeUsuarioPorNombre(usuario.getNombreDeUsuario()) || existeUsuarioPorEmail(usuario.getEmail()) )  {
			modelo.put("errorValidacion", "El nombre de usuario o email ya existe, contacte al administrador");
			return new ModelAndView("agregarUsuario", modelo);
		} else {
			guardarUsuario(usuario);
			return new ModelAndView("redirect:/usuarios");
		}
	}
	
	@Override
	public ModelAndView validarEliminarUsuario(Long id) {
		ModelMap modelo = new ModelMap();
		
		if (existeUsuarioPorId(id)) {
			modelo.put("estadoEliminar", "El usuario se elimino exitosamente");
			eliminarUsuarioPorId(id);
			return new ModelAndView("usuarios", modelo);
		} else {
			modelo.put("estadoEliminar", "Usuario no encontrado, contacte al administrador ");
			return new ModelAndView("usuarios", modelo);
		}
	}


}
