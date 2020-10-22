package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoBusqueda;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioBusqueda;
import ar.edu.unlam.tallerweb1.modelo.resultadoBusqueda.ResultadoBusqueda;
import ar.edu.unlam.tallerweb1.repositorios.ComidaRepository;

@Service("busquedaService")
@Transactional
public class BusquedaServiceImpl implements BusquedaService {

	@Autowired
	private ComidaService comidaService;
	
	@Autowired
	private RestauranteService restauranteService;

	@Override
	public ResultadoBusqueda buscar(FormularioBusqueda busqueda) {
		ResultadoBusqueda resultado = new ResultadoBusqueda();
		
		System.out.println(busqueda.getDatoBuscado());
		
		if (busqueda.getTipoBusquedaSeleccionada().equals(TipoBusqueda.COMIDA.ordinal()))
			resultado.getListaComidas().addAll(comidaService.buscarComidaDeseada(busqueda.getDatoBuscado()));
		else 
			resultado.getListaRestaurantes().addAll(restauranteService.buscarRestaurantePorNombre(busqueda.getDatoBuscado()));
		
		System.out.println(resultado.getListaComidas().size());
		System.out.println(resultado.getListaRestaurantes().size());

		return resultado;
	}

}
