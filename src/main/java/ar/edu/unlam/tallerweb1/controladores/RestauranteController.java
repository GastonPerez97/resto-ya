package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.HorarioModel;
import ar.edu.unlam.tallerweb1.modelo.MesaModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioNuevaMesa;
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
