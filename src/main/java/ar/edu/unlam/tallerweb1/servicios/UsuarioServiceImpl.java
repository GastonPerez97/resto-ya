package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;
import ar.edu.unlam.tallerweb1.repositorios.UsuarioRepository;

@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

	
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
	public void eliminarUsuario(Long id) {
		usuarioRepository.eliminarUsuario(id);
		
	}

	@Override
	public List<UsuarioModel> buscarUsuarios() {
		return usuarioRepository.buscarUsuarios();
	}

	@Override
	public Boolean existeUsuarioPorNombre(String nombre) {
		Boolean existe = false;
		
		if(usuarioRepository.existeUsuarioPorNombre(nombre) != null){
			existe = true;
		}
		
		return existe;
	}
	
	
	@Override
	public UsuarioModel buscarUsuarioPorId(Long id) {
		return usuarioRepository.buscarUsuarioPorId(id);
	} 

	
	
}
