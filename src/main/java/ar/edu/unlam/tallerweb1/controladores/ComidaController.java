package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping("/restaurante/menu")
	public ModelAndView verMenu(@RequestParam("id") Long id) {
		
		RestauranteModel restaurante = servRestaurante.buscarRestaurantePorId(id);
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("titulo", "Menu de " + restaurante.getNombre());
		modelo.put("restaurante", restaurante);
		modelo.put("COMIDAS", servRestaurante.buscarMenuPorRestauranteId(id));
		
		return new ModelAndView("menu", modelo);
	}
	
	@RequestMapping("/hacerPedido")
	public ModelAndView hacerPedido(@RequestParam("id")Long id) {
		RestauranteModel restaurante = servRestaurante.buscarRestaurantePorId(id);
		
		ModelMap modelo = new ModelMap();
		modelo.put("restaurante", restaurante);
		modelo.put("titulo", "Hacer pedido en " + restaurante.getNombre());
		modelo.put("COMIDAS", comidaService.buscarComida());
		return new ModelAndView("hacerPedido", modelo);
		
	}
	
	@RequestMapping(path="/procesarPedido", method=RequestMethod.POST)
	public ModelAndView procesarPedidoPost(@RequestParam("checkboxComidas") ArrayList<Long> idComidas) {		
		ModelMap modelo = new ModelMap();
		
		List<ComidaModel> comidas = new ArrayList<ComidaModel>();
		
		for(Long idComida : idComidas) {
			comidas.add(comidaService.mostrarComidaModel((idComida)));
		}
		
		modelo.put("Comidas", comidas);
		
		return new ModelAndView("procesarPedido", modelo);
	}
	
	@RequestMapping(path="/pagar", method=RequestMethod.POST)
	public ModelAndView pagarPedido() {

		return new ModelAndView("pagoRealizado");
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
		modelo.put("resultadoBusqueda", comidaService.buscarComidaDeseada(comidaBuscada.getNombre()));

		return new ModelAndView("resultadoBusquedaComida", modelo);
	}
}
