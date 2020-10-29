package ar.edu.unlam.tallerweb1.controladores;


import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	public ModelAndView editarComida(@RequestParam("id") Long id) {
		
		ComidaModel comida = comidaService.consultarComidaPorId(id);
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("titulo", "Editar " + comida.getNombre());
		modelo.put("comida", comida);
		
		return new ModelAndView("editarComida", modelo);
	}
	
	@RequestMapping(path = "/validar-editarComida", method = RequestMethod.POST)
	public ModelAndView validarEdicionComida(
			@ModelAttribute("comida") ComidaModel comida,
			@RequestParam("file") MultipartFile file) {
		
//		if (!file.isEmpty()) {
//			comidaService.eliminarImagenComidaSiExiste(comida);
//			comidaService.subirImagenComida(comida, file);
//			comida.setImageName(file.getOriginalFilename());
//		}
//
//		comidaService.editarComida(comida);
		
		return new ModelAndView("redirect:/restaurantes/menu?id=" + comida.getRestaurante().getIdRestaurante());
	}
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
