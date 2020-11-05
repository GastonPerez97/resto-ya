package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;



public interface RestauranteService {

	public ArrayList<RestauranteModel> buscarRestaurantes();
	
	public RestauranteModel buscarRestaurantePorId(Long id);
	
	public ArrayList<RestauranteModel> buscarRestaurantePorNombre(String nombre);
	
	public List<ComidaModel> buscarMenuPorRestaurante(RestauranteModel restaurante);
	
	public RestauranteModel buscarRestaurantePorDireccion(String direccion);
	
	public Boolean validarRestaurante(RestauranteModel restaurante);
	
	public void guardarRestaurante(RestauranteModel restaurante);
	
	public void editarRestaurante(RestauranteModel restaurante);
	
	public void subirImagenRestaurante(MultipartFile imagen);
	
	public void eliminarRestaurante(RestauranteModel restaurante);
	
	public void eliminarImagenRestauranteSiExiste(RestauranteModel restaurante);
	
	public void subirImagenSiNoEstaVacia(RestauranteModel restaurante, MultipartFile imagen);
	
	public void reemplazarImagenRestauranteSiNuevaImagenNoEstaVacia(RestauranteModel restaurante,
			MultipartFile imagen);
	
	public ModelAndView procesarNuevoRestaurante(RestauranteModel restaurante, MultipartFile imagen, ModelMap modelo);
	
	public void procesarEdicionRestaurante(RestauranteModel restaurante, MultipartFile imagen);
	
	public void procesarEliminacionRestaurante(RestauranteModel restaurante);
	
	public Boolean verificarExtensionDeImagen(MultipartFile imagen);
}


