package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.repositorios.RestauranteRepository;

@Service("restauranteService")
@Transactional
public class RestauranteServiceImpl implements RestauranteService {

	@Autowired
	private RestauranteRepository repositorioRestaurante;
	
	@Override
	public ArrayList<RestauranteModel> buscarRestaurantes() {
		return repositorioRestaurante.buscarRestaurantes();
	}

	@Override
	public RestauranteModel buscarRestaurantePorId(Long id) {
		return repositorioRestaurante.buscarRestaurantePorId(id);
	}

}
