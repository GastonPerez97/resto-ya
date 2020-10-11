package ar.edu.unlam.tallerweb1.repositorios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;


public interface RestauranteRepository {
	
	public ArrayList<RestauranteModel> buscarRestaurantes();
	
	public RestauranteModel buscarRestaurantePorId(Long id);
	
	public ArrayList<RestauranteModel> buscarRestaurantePorNombre(String nombre);
	
	public List<ComidaModel> buscarMenuPorRestauranteId(Long id);
}
