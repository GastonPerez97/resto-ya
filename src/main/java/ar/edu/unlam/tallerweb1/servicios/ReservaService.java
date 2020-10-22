package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.ReservaModel;

public interface ReservaService {
	
	void procesarNuevaReserva(ReservaModel reservaModel);
	
	void guardarReserva(ReservaModel reservaModel);
	
	ReservaModel getReservaByIdReserva(Long idReserva);

}
