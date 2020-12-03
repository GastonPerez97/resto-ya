package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import java.util.List;

public interface ComidaRepository {
	ComidaModel consultarComidaPorId(Long id);
	
	public List<ComidaModel> buscarComida();
	
	List<ComidaModel> getComidasDisponiblesByRestaurante(Long idRestaurante);
	
	public void editarComida(ComidaModel comida);
	
	public void eliminarComida(ComidaModel comida);
	
	public void guardarComidaEnDB(ComidaModel comida);
}
