package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import java.util.ArrayList;

public interface ComidaRepository {
	ComidaModel consultarComidaPorId(Long id);
	public ArrayList<ComidaModel> buscarComida();
	//ComidaModel consultarComidaPorId(Long id);
	
	
	
}
