package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.servicios.ComidaService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;

@Controller
public class ComidaController {

	@Autowired
	private ComidaService servComida;
	
	@Autowired
	private RestauranteService servRestaurante;
	
	@RequestMapping("/restaurante/menu")
	public ModelAndView verMenu(@RequestParam("id") Long id) {
		
		RestauranteModel restaurante = servRestaurante.buscarRestaurantePorId(id);
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("titulo", "Menu de " + restaurante.getNombre());
		modelo.put("restaurante", restaurante);
		modelo.put("COMIDAS", servComida.buscarComida());
		
		return new ModelAndView("menu", modelo);
	}
	
	@RequestMapping("/busqueda")
	public ModelAndView buscarComida() {
		
		ModelMap modelo = new ModelMap();
		modelo.put("busqueda", new ComidaModel());
		
		return new ModelAndView("buscadorDeComidas", modelo);
	}
	
	@RequestMapping(path = "/busqueda", method = RequestMethod.POST)
	public ModelAndView buscarComidaPost(@ModelAttribute("busqueda") ComidaModel comidaBuscada) {
		
		ModelMap modelo = new ModelMap();
		modelo.put("resultadoBusqueda", servComida.buscarComidaDeseada(comidaBuscada.getNombre()));
		modelo.put("busqueda", new ComidaModel());

		return new ModelAndView("resultadoBusquedaComida", modelo);
	}
	
}
