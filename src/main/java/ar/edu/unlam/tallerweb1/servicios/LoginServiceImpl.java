package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.form.FormularioRegistro;
import ar.edu.unlam.tallerweb1.repositorios.UsuarioRepository;
import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;

@Service("servicioLogin")
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void guardarUsuarioRegistrado(UsuarioModel usuario) {
		usuarioRepository.guardarUsuario(usuario);
	}

	@Override
	public UsuarioModel consultarUsuarioRegistrado(FormularioRegistro registro) {
		return usuarioRepository.existeUsuarioPorEmail(registro.getUsuarioModel().getEmail());
	}

	@Override
	public UsuarioModel consultarUsuario (UsuarioModel usuario) {
		return usuarioRepository.consultarUsuario(usuario);
	}

}
