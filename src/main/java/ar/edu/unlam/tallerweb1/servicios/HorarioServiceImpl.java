package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.HorarioModel;
import ar.edu.unlam.tallerweb1.modelo.MesaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioNuevaMesa;
import ar.edu.unlam.tallerweb1.repositorios.HorarioRespository;
import ar.edu.unlam.tallerweb1.repositorios.MesaRepository;

@Service("horarioService")
@Transactional
public class HorarioServiceImpl implements HorarioService {

	@Autowired
	private HorarioRespository horarioRepository;

	@Override
	public List<HorarioModel> getHorariosNoAsignadosARestaurante(Long idRestaurante) {
		return horarioRepository.getHorariosNoAsignadosARestaurante(idRestaurante);
	}
	
	@Override
	public HorarioModel getHorarioById(Long idHorario) {
		return horarioRepository.getHorarioById(idHorario);
	}

}
