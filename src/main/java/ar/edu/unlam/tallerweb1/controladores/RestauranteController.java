package ar.edu.unlam.tallerweb1.controladores;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;

@Controller
public class RestauranteController {

	@Autowired
	private RestauranteService servRestaurante;
	
	@RequestMapping("/restaurantes")
	public ModelAndView restaurantes() {
		ModelMap modelo = new ModelMap();
		
		modelo.put("titulo", "Lista de Restaurantes");
		modelo.put("RESTAURANTES", servRestaurante.buscarRestaurantes());
		
		return new ModelAndView("restaurantes", modelo);
	}
	
	@RequestMapping(path = "/agregarRestaurante", method = RequestMethod.POST)
	public ModelAndView agregarRestaurante() {
		ModelMap modelo = new ModelMap();
		
		RestauranteModel restaurante = new RestauranteModel();
		
		modelo.put("titulo", "Agregar Restaurante");
		modelo.put("restaurante", restaurante);
		
		return new ModelAndView("agregarRestaurante", modelo);
	}
	
	@RequestMapping(path = "/validar-nuevoRestaurante", method = RequestMethod.POST)
	public ModelAndView validarNuevoRestaurante(
			@ModelAttribute("restaurante") RestauranteModel restaurante,
			@RequestParam("file") MultipartFile file) {
		
		ModelMap modelo = new ModelMap();

		modelo.put("titulo", "Lista de Restaurantes");
		
		if (servRestaurante.validarRestaurante(restaurante)) {

			if (!file.isEmpty()) {
				servRestaurante.subirImagenRestaurante(restaurante, file);
				restaurante.setImageName(file.getOriginalFilename());
			}
			
			servRestaurante.guardarRestaurante(restaurante);

			return new ModelAndView("redirect:/restaurantes");
			
		} else {
			modelo.put("errorValidacion", "La direccion del restaurante ya se encuentra "
						+ "en la base de datos, contacte al administrador");
		}
		
		return new ModelAndView("agregarRestaurante", modelo);
	}
	
	@RequestMapping("/editarRestaurante")
	public ModelAndView editarRestaurante(@RequestParam("id") Long id) {
		
		RestauranteModel restaurante = servRestaurante.buscarRestaurantePorId(id);
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("titulo", "Editar " + restaurante.getNombre());
		modelo.put("restaurante", restaurante);
		
		return new ModelAndView("editarRestaurante", modelo);
	}
	
	@RequestMapping(path = "/validar-editarRestaurante", method = RequestMethod.POST)
	public ModelAndView validarEdicionRestaurante(
			@ModelAttribute("restaurante") RestauranteModel restaurante,
			@RequestParam("file") MultipartFile file) {
		
		if (!file.isEmpty()) {
			servRestaurante.subirImagenRestaurante(restaurante, file);
			restaurante.setImageName(file.getOriginalFilename());
		}

		servRestaurante.editarRestaurante(restaurante);
		
		return new ModelAndView("redirect:/restaurantes");
	}
	
}
