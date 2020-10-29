package ar.edu.unlam.tallerweb1.controladores;


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
		modelo.put("COMIDAS", servRestaurante.buscarMenuPorRestaurante(restaurante));
		
		return new ModelAndView("menu", modelo);
	}
	
	@RequestMapping(path="/pagar", method=RequestMethod.POST)
	public ModelAndView pagarPedido() {

		return new ModelAndView("pagoRealizado");
	}
	
	@RequestMapping("/editarComida")
	public ModelAndView editarRestaurante(@RequestParam("id") Long id) {
		
		ComidaModel comida = comidaService.consultarComidaPorId(id);
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("titulo", "Editar " + comida.getNombre());
		modelo.put("comida", comida);
		
		return new ModelAndView("editarComida", modelo);
	}
	
//	@RequestMapping(path = "/validar-editarRestaurante", method = RequestMethod.POST)
//	public ModelAndView validarEdicionRestaurante(
//			@ModelAttribute("restaurante") RestauranteModel restaurante,
//			@RequestParam("file") MultipartFile file) {
//		
//		if (!file.isEmpty()) {
//			servRestaurante.eliminarImagenRestauranteSiExiste(restaurante);
//			servRestaurante.subirImagenRestaurante(restaurante, file);
//			restaurante.setImageName(file.getOriginalFilename());
//		}
//
//		servRestaurante.editarRestaurante(restaurante);
//		
//		return new ModelAndView("redirect:/restaurantes");
//	}
//	
//	@RequestMapping("/eliminarRestaurante")
//	public ModelAndView eliminarRestaurante(@RequestParam("id") Long id) throws Exception {
//		
//		RestauranteModel restaurante = servRestaurante.buscarRestaurantePorId(id);
//		
//		servRestaurante.eliminarRestaurante(restaurante);
//		servRestaurante.eliminarImagenRestauranteSiExiste(restaurante);
//		
//		return new ModelAndView("redirect:/restaurantes");
//	}
	
}
