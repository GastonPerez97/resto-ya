package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.RolModel;
import ar.edu.unlam.tallerweb1.repositorios.RolRepository;

@Service("rolService")
@Transactional
public class RolServiceImpl implements RolService {

	@Inject
	private RolRepository rolRepository;
	/*
	@Override
	public RolModel mostrarRolModel(Long id) {
		RolModel rol = rolRepository.consultarRolPorId(id);
		return rol ;
	}
	*/
	@Override
	public List<RolModel> listarRolUsuario() {
		List<RolModel> roles = rolRepository.listarRoles();
		return roles;
	}

}
