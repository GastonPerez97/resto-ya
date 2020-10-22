package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

	@Override
	public ArrayList<RestauranteModel> buscarRestaurantePorNombre(String nombre) {
		ArrayList<RestauranteModel> listaReturn = new ArrayList<>();
		ArrayList<RestauranteModel> listadoDb = repositorioRestaurante.buscarRestaurantePorNombre(nombre);

		for (RestauranteModel list : listadoDb) {
			if (list.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
				listaReturn.add(list);
			}
		}

		return listaReturn;
	}
}
