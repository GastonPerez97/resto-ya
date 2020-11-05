package ar.edu.unlam.tallerweb1.servicios;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.EstadoReservaModel;
import ar.edu.unlam.tallerweb1.modelo.MesaModel;
import ar.edu.unlam.tallerweb1.modelo.ReservaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteHorarioModel;
import ar.edu.unlam.tallerweb1.modelo.enums.EstadoReserva;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioGeneracionReserva;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioHorarioReserva;
import ar.edu.unlam.tallerweb1.repositorios.MesaRepository;
import ar.edu.unlam.tallerweb1.repositorios.ReservaRepository;
import ar.edu.unlam.tallerweb1.repositorios.RestauranteHorarioRepository;

@Service("reservaService")
@Transactional
public class ReservaServiceImpl implements ReservaService {
	
	@Autowired
	private ReservaRepository reservaRepository;

	@Autowired
	private MesaService mesaService;
	
	@Autowired
	private RestauranteHorarioService restauranteHorarioService;
	
	@Override
	public void guardarReserva(ReservaModel reservaModel) {
		reservaRepository.guardarReserva(reservaModel);
	}

	@Override
	public ReservaModel procesarNuevaReserva(FormularioGeneracionReserva formularioGeneracionReserva) {
		
		ReservaModel reserva = new ReservaModel();
		reserva.setFechaReserva(formularioGeneracionReserva.getFechaReserva());
		reserva.setEstadoReservaModel(new EstadoReservaModel(EstadoReserva.PENDIENTE_DE_CONFIRMACION.getId()));
		reserva.setRestauranteHorarioModel(restauranteHorarioService.getRestauranteHorarioById(formularioGeneracionReserva.getIdRestauranteHorario()));
		reserva.setMesaModel(mesaService.getMesaById(formularioGeneracionReserva.getIdMesa()));
		
		guardarReserva(reserva);
		
		return reserva;
	}
	
	@Override
	public ReservaModel getReservaByIdReserva(Long idReserva) {
		return reservaRepository.getReservaByIdReserva(idReserva);
	}

	@Override
	public List<FormularioHorarioReserva> getHorariosDisponiblesParaReservaDeMesa(
			FormularioGeneracionReserva formularioGeneracionReserva) {
		
		List<FormularioHorarioReserva> horariosDisponibles = new ArrayList<FormularioHorarioReserva>();
		List<RestauranteHorarioModel> restauranteHorarioModelList = reservaRepository.getHorariosDisponiblesParaReservaDeMesa(formularioGeneracionReserva);
		
		for (RestauranteHorarioModel restauranteHorarioModel : restauranteHorarioModelList) {
			horariosDisponibles.add(new FormularioHorarioReserva(
					restauranteHorarioModel.getIdRestauranteHorario(),
					restauranteHorarioModel.getHorarioModel().getHorario()));
		}
		
		return horariosDisponibles;
	}

}
