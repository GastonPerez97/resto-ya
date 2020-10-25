package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;



public interface RestauranteService {

	public ArrayList<RestauranteModel> buscarRestaurantes();
	
	public RestauranteModel buscarRestaurantePorId(Long id);
	
	public ArrayList<RestauranteModel> buscarRestaurantePorNombre(String nombre);
	
	public List<ComidaModel> buscarMenuPorRestaurante(RestauranteModel restaurante);
	
	public RestauranteModel buscarRestaurantePorDireccion(String direccion);
	
	public Boolean validarNuevoRestaurante(RestauranteModel restaurante);
	
	public Boolean guardarRestaurante(RestauranteModel restaurante);
}


