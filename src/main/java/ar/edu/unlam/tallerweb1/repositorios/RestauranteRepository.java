package ar.edu.unlam.tallerweb1.repositorios;

import java.util.ArrayList;

import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;


public interface RestauranteRepository {
	
	public ArrayList<RestauranteModel> buscarRestaurantes();
	
	public RestauranteModel buscarRestaurantePorId(Long id);
	
}
