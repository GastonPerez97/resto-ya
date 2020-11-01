package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import java.util.ArrayList;
import java.util.List;

public interface ComidaRepository {
	ComidaModel consultarComidaPorId(Long id);
	
	public List<ComidaModel> buscarComida();
	
	public void editarComida(ComidaModel comida);
}
