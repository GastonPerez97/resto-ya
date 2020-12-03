package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;

public interface ComidaService {
	
	ComidaModel mostrarComidaModel(Long id);

	public List<ComidaModel> buscarComida();
	
	List<ComidaModel> buscarComidasDisponiblesDeRestaurante(Long idRestaurante);

	public List<ComidaModel> buscarComidaDeseada(String nombre);
	
	public ComidaModel consultarComidaPorId(Long id);

	public ArrayList<ComidaModel> mostrarComidaPedida(ArrayList<Long> id);
	
	public void editarComida(ComidaModel comida);
	
	public void subirImagenComida(MultipartFile imagen);
	
	public void eliminarImagenComidaSiExiste(ComidaModel comida);
	
	public void procesarEdicionComida(ComidaModel comida, MultipartFile imagen);
	
	public Boolean verificarExtensionDeImagen(MultipartFile imagen);
	
	public void procesarEliminacionComida(ComidaModel comida);
	
	public void eliminarComida(ComidaModel comida);
	
	public void procesarNuevaComida(ComidaModel comida, MultipartFile imagen);
	
	public void guardarComidaEnDB(ComidaModel comida);
}