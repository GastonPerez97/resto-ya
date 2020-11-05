package ar.edu.unlam.tallerweb1.servicios;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.EstadoReservaModel;
import ar.edu.unlam.tallerweb1.modelo.HorarioModel;
import ar.edu.unlam.tallerweb1.modelo.MesaModel;
import ar.edu.unlam.tallerweb1.modelo.ReservaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteHorarioModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioGeneracionReserva;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioHorarioReserva;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioRestauranteHorario;
import ar.edu.unlam.tallerweb1.repositorios.MesaRepository;
import ar.edu.unlam.tallerweb1.repositorios.ReservaRepository;
import ar.edu.unlam.tallerweb1.repositorios.RestauranteHorarioRepository;

@Service("restauranteHorarioService")
@Transactional
public class RestauranteHorarioServiceImpl implements RestauranteHorarioService {
	
	@Autowired
	private RestauranteHorarioRepository restauranteHorarioRepository;
	
	@Autowired
	private HorarioService horarioService;

	@Override
	public RestauranteHorarioModel getRestauranteHorarioById(Long idRestauranteHorario) {
		return restauranteHorarioRepository.getRestauranteHorarioById(idRestauranteHorario);
	}

	@Override
	public void guardarRestauranteHorario(RestauranteHorarioModel restauranteHorarioModel) {
		restauranteHorarioRepository.guardarRestauranteHorario(restauranteHorarioModel);
	}

	@Override
	public HorarioModel procesarNuevoHorarioRestaurante(FormularioRestauranteHorario formulario) {
		RestauranteHorarioModel restauranteHorario = new RestauranteHorarioModel();
		restauranteHorario.setHorarioModel(new HorarioModel(formulario.getIdHorario()));
		restauranteHorario.setRestauranteModel(new RestauranteModel(formulario.getIdRestaurante()));
		
		guardarRestauranteHorario(restauranteHorario);
		
		HorarioModel horario = horarioService.getHorarioById(formulario.getIdHorario());
		
		return horario;
	}

}
