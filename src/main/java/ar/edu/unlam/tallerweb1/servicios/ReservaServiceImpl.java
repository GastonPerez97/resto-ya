package ar.edu.unlam.tallerweb1.servicios;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.EstadoReservaModel;
import ar.edu.unlam.tallerweb1.modelo.ReservaModel;
import ar.edu.unlam.tallerweb1.repositorios.ReservaRepository;

@Service("reservaService")
@Transactional
public class ReservaServiceImpl implements ReservaService {
	
	@Autowired
	private ReservaRepository reservaRepository;

	@Override
	public void guardarReserva(ReservaModel reservaModel) {
		reservaRepository.guardarReserva(reservaModel);
	}

	@Override
	public void procesarNuevaReserva(ReservaModel reservaModel) {
		reservaModel.setFechaReserva(new Date(System.currentTimeMillis()));
		reservaModel.setEstadoReservaModel(new EstadoReservaModel(1L));
		
		guardarReserva(reservaModel);
	}
	
	@Override
	public ReservaModel getReservaByIdReserva(Long idReserva) {
		return reservaRepository.getReservaByIdReserva(idReserva);
	}

}
