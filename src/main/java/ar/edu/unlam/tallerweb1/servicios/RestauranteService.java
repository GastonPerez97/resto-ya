package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;



public interface RestauranteService {

	public ArrayList<RestauranteModel> buscarRestaurantes();
	
	public RestauranteModel buscarRestaurantePorId(Long id);
	
	public ArrayList<RestauranteModel> buscarRestaurantePorNombre(String nombre);
	
	public List<ComidaModel> buscarMenuPorRestauranteId(Long id);
}


