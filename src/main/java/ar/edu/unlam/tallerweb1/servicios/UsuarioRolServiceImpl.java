package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.UsuarioRolModel;
import ar.edu.unlam.tallerweb1.repositorios.UsuarioRolRepository;

@Service("usuarioRolService")
@Transactional
public class UsuarioRolServiceImpl implements UsuarioRolService {
	
	@Inject
	private UsuarioRolRepository usuarioRolRepository;

	@Override
	public UsuarioRolModel buscarUsuarioRolPorId(Long id) {
		return usuarioRolRepository.buscarUsuarioRolPorId(id);
	}
	
	
	

}
