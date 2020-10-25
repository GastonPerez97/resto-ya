package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ModelAndView validarNuevoRestaurante(@ModelAttribute("restaurante") RestauranteModel restaurante) {
		ModelMap modelo = new ModelMap();
		
		modelo.put("titulo", "Lista de Restaurantes");
		
		if (servRestaurante.validarNuevoRestaurante(restaurante)) {
			if (servRestaurante.guardarRestaurante(restaurante)) {
				return new ModelAndView("redirect:/restaurantes");
			} else {
				modelo.put("errorDB", "Ocurrio un error al insertar el restaurante "
						   + "en la base de datos, intente nuevamente");
			}
		} else {
			modelo.put("errorValidacion", "La direccion del restaurante ya se encuentra"
						+ " en la base de datos, contacte al administrador");
		}
		
		return new ModelAndView("agregarRestaurante", modelo);
	}
	
}
