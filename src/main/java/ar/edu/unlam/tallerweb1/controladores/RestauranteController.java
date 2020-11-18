package ar.edu.unlam.tallerweb1.controladores;

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

import ar.edu.unlam.tallerweb1.modelo.HorarioModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioRestauranteHorario;
import ar.edu.unlam.tallerweb1.servicios.HorarioService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteHorarioService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;

@Controller
public class RestauranteController {

	@Autowired
	private RestauranteService servRestaurante;
	
	@Autowired
	private RestauranteHorarioService restauranteHorarioService;
	
	@Autowired
	private HorarioService horarioService;
	
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
		
		return servRestaurante.procesarNuevoRestaurante(restaurante, file, modelo);
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
		
		servRestaurante.procesarEdicionRestaurante(restaurante, file);
		
		return new ModelAndView("redirect:/restaurantes");
	}
	
	@RequestMapping("/eliminarRestaurante")
	public ModelAndView eliminarRestaurante(@RequestParam("id") Long id) throws Exception {
		
		RestauranteModel restaurante = servRestaurante.buscarRestaurantePorId(id);
		
		servRestaurante.procesarEliminacionRestaurante(restaurante);
		
		return new ModelAndView("redirect:/restaurantes");
	}
	
	@RequestMapping(path = "/nuevo-horario", method = RequestMethod.POST)
	public ModelAndView generarNuevaMesa(@RequestParam("idRestaurante") Long idRestaurante) {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("restaurante", servRestaurante.buscarRestaurantePorId(idRestaurante));
		modelAndView.addObject("horarios", horarioService.getHorariosNoAsignadosARestaurante(idRestaurante));
		modelAndView.addObject("formularioNuevoHorario", new FormularioRestauranteHorario());
		modelAndView.setViewName("generacionNuevoHorario");
		
		return modelAndView;
	}

	@RequestMapping(path = "/guardar-nuevo-horario", method = RequestMethod.POST)
	public ModelAndView generarNuevaMesaPost(@ModelAttribute("formularioNuevoHorario") FormularioRestauranteHorario formularioRestauranteHorario) {
		ModelAndView modelAndView = new ModelAndView();
		
		HorarioModel horario = restauranteHorarioService.procesarNuevoHorarioRestaurante(formularioRestauranteHorario);
		modelAndView.addObject("horario", horario);
		modelAndView.setViewName("nuevoHorarioExitoso");
		
		return modelAndView;
	}
}
