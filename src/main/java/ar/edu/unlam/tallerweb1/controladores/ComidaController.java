package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.servicios.ComidaService;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;


@Controller
public class ComidaController {
	
	@Inject
	private ComidaService comidaService;
	
	@Autowired
	private RestauranteService servRestaurante;
	
	@RequestMapping("/hacerPedido")
	public ModelAndView hacerPedido(
			@RequestParam(value="id", required = true)Long id) {
		ComidaModel comida = comidaService.mostrarComidaModel(id);
		ModelMap modelo = new ModelMap();
		modelo.put("hacerPedido", comida);
		return new ModelAndView("hacerPedido", modelo);
		
	}
	
	@RequestMapping("/restaurante/menu")
	public ModelAndView verMenu(@RequestParam("id") Long id) {
		
		RestauranteModel restaurante = servRestaurante.buscarRestaurantePorId(id);
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("titulo", "Menu de " + restaurante.getNombre());
		modelo.put("restaurante", restaurante);
		modelo.put("COMIDAS", comidaService.buscarComida());
		
		return new ModelAndView("menu", modelo);
	}
	
}
