package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;

public interface ComidaService {
	ComidaModel mostrarComidaModel(Long id);

	public ArrayList<ComidaModel> buscarComida();

	public List<ComidaModel> buscarComidaDeseada(String nombre);
	
	public ComidaModel consultarComidaPorId(Long id);

	public ArrayList<ComidaModel> mostrarComidaPedida(ArrayList<Long> id);
	
	public void editarComida(ComidaModel comida);
	
	public void subirImagenComida(ComidaModel comida, MultipartFile imagen);
	
	public void eliminarImagenComidaSiExiste(ComidaModel comida);
}