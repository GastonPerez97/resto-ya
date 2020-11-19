package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

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
	public ModelAndView restaurantes(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		
		
		modelo.put("titulo", "Lista de Restaurantes");
		modelo.put("RESTAURANTES", servRestaurante.buscarRestaurantes());
		modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		
		return new ModelAndView("restaurantes", modelo);
	}
	
	@RequestMapping(path = "/agregarRestaurante", method = RequestMethod.POST)
	public ModelAndView agregarRestaurante(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		
		RestauranteModel restaurante = new RestauranteModel();
		
		modelo.put("titulo", "Agregar Restaurante");
		modelo.put("restaurante", restaurante);
		modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		
		return new ModelAndView("agregarRestaurante", modelo);
	}
	
	@RequestMapping(path = "/validar-nuevoRestaurante", method = RequestMethod.POST)
	public ModelAndView validarNuevoRestaurante(
			@ModelAttribute("restaurante") RestauranteModel restaurante,
			@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		
		ModelMap modelo = new ModelMap();

		modelo.put("titulo", "Lista de Restaurantes");
		modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		
		return servRestaurante.procesarNuevoRestaurante(restaurante, file, modelo);
	}
	
	@RequestMapping("/editarRestaurante")
	public ModelAndView editarRestaurante(@RequestParam("id") Long id, HttpServletRequest request) {
		
		RestauranteModel restaurante = servRestaurante.buscarRestaurantePorId(id);
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("titulo", "Editar " + restaurante.getNombre());
		modelo.put("restaurante", restaurante);
		modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		
		return new ModelAndView("editarRestaurante", modelo);
	}
	
	@RequestMapping(path = "/validar-editarRestaurante", method = RequestMethod.POST)
	public ModelAndView validarEdicionRestaurante(
			@ModelAttribute("restaurante") RestauranteModel restaurante,
			@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		
		ModelMap modelo = new ModelMap();
		modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		
		servRestaurante.procesarEdicionRestaurante(restaurante, file);
		
		return new ModelAndView("redirect:/restaurantes");
	}
	
	@RequestMapping("/eliminarRestaurante")
	public ModelAndView eliminarRestaurante(@RequestParam("id") Long id, HttpServletRequest request) throws Exception {
		ModelMap modelo = new ModelMap();
		modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		
		RestauranteModel restaurante = servRestaurante.buscarRestaurantePorId(id);
		
		servRestaurante.procesarEliminacionRestaurante(restaurante);
		
		return new ModelAndView("redirect:/restaurantes");
	}
	
	@RequestMapping(path = "/nuevo-horario", method = RequestMethod.POST)
	public ModelAndView generarNuevoHorario(@RequestParam("idRestaurante") Long idRestaurante, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("restaurante", servRestaurante.buscarRestaurantePorId(idRestaurante));
		modelAndView.addObject("horarios", horarioService.getHorariosNoAsignadosARestaurante(idRestaurante));
		modelAndView.addObject("formularioNuevoHorario", new FormularioRestauranteHorario());
		modelAndView.addObject("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		modelAndView.setViewName("generacionNuevoHorario");
		
		return modelAndView;
	}

	@RequestMapping(path = "/guardar-nuevo-horario", method = RequestMethod.POST)
	public ModelAndView generarNuevoHorarioPost(@ModelAttribute("formularioNuevoHorario") FormularioRestauranteHorario formularioRestauranteHorario, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		HorarioModel horario = restauranteHorarioService.procesarNuevoHorarioRestaurante(formularioRestauranteHorario);
		modelAndView.addObject("horario", horario);
		modelAndView.addObject("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		modelAndView.setViewName("nuevoHorarioExitoso");
		
		return modelAndView;
	}
}
