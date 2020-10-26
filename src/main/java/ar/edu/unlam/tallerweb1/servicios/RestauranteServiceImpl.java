package ar.edu.unlam.tallerweb1.servicios;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.repositorios.RestauranteRepository;

@Service("restauranteService")
@Transactional
public class RestauranteServiceImpl implements RestauranteService {

	@Autowired
	private RestauranteRepository repositorioRestaurante;
	
	@Autowired
    ServletContext servletContext;

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
	
	@Override
	public List<ComidaModel> buscarMenuPorRestaurante(RestauranteModel restaurante){
		return repositorioRestaurante.buscarMenuPorRestaurante(restaurante);
	}
	
	@Override
	public RestauranteModel buscarRestaurantePorDireccion(String direccion) {
		String direccionToLower = direccion.toLowerCase();
		return repositorioRestaurante.buscarRestaurantePorDireccion(direccionToLower);
	}

	@Override
	public Boolean validarRestaurante(RestauranteModel restaurante) {
		Boolean valido = false;
		
		if (repositorioRestaurante.buscarRestaurantePorDireccion(restaurante.getDireccion()) == null) {
			valido = true;
		}
		
		return valido;
	}

	@Override
	public void guardarRestaurante(RestauranteModel restaurante) {
		repositorioRestaurante.guardarRestaurante(restaurante);
	}

	@Override
	public void editarRestaurante(RestauranteModel restaurante) {
		repositorioRestaurante.editarRestaurante(restaurante);
	}

	@Override
	public void subirImagenRestaurante(RestauranteModel restaurante, MultipartFile imagen) {		
		String fileName = servletContext.getRealPath("/") +
			   "\\img\\restaurantes\\" +
			   imagen.getOriginalFilename();
		 
		try {
			imagen.transferTo(new File(fileName));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}

}
