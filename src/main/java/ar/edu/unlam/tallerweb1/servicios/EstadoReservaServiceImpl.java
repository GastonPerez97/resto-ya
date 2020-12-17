package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.EstadoReservaModel;
import ar.edu.unlam.tallerweb1.modelo.HorarioModel;
import ar.edu.unlam.tallerweb1.modelo.MesaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioNuevaMesa;
import ar.edu.unlam.tallerweb1.repositorios.EstadoReservaRepository;
import ar.edu.unlam.tallerweb1.repositorios.HorarioRespository;
import ar.edu.unlam.tallerweb1.repositorios.MesaRepository;

@Service("estadoReservaService")
@Transactional
public class EstadoReservaServiceImpl implements EstadoReservaService {

	@Autowired
	private EstadoReservaRepository estadoReservaRepository ;

	@Override
	public List<EstadoReservaModel> buscarEstadosReserva() {
		return estadoReservaRepository.getEstadosReserva();
	}


}
