package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.ReservaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteHorarioModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioGeneracionReserva;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioHorarioReserva;

public interface ReservaService {
	
	ReservaModel procesarNuevaReserva(FormularioGeneracionReserva formularioGeneracionReserva);
	
	void guardarReserva(ReservaModel reservaModel);
	
	ReservaModel getReservaByIdReserva(Long idReserva);

	List<FormularioHorarioReserva> getHorariosDisponiblesParaReservaDeMesa(FormularioGeneracionReserva formularioGeneracionReserva);

	List<ReservaModel> getReservasDeCliente(Long idCliente);
}
