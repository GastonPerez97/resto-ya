package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import ar.edu.unlam.tallerweb1.modelo.ComidaModel;

public interface ComidaService {
	ComidaModel mostrarComidaModel(Long id);

	public ArrayList<ComidaModel> buscarComida();
	
}
