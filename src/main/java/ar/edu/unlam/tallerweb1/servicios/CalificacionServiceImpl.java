package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.repositorios.CalificacionRepository;
import ar.edu.unlam.tallerweb1.repositorios.ClienteRepository;
import ar.edu.unlam.tallerweb1.repositorios.PedidoRepository;
import ar.edu.unlam.tallerweb1.modelo.CalificacionRestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.ClienteModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioCalificacionRestaurante;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioRegistro;
import ar.edu.unlam.tallerweb1.modelo.resultadoBusqueda.ResultadoRegistro;

@Service("servicioCalificacion")
@Transactional
public class CalificacionServiceImpl implements CalificacionService {

	@Autowired
	private CalificacionRepository calificacionRepository;

	@Override
	public List<CalificacionRestauranteModel> buscarCalificaciones() {
		return calificacionRepository.buscarCalificaciones();

	}

	public void guardarCalificaciones(FormularioCalificacionRestaurante calificacion) {
		
		calificacionRepository.guardarCalificaciones(calificacion);
	
		
	}
}