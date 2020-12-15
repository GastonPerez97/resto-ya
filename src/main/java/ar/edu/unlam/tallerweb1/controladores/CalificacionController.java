package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioCalificacionRestaurante;
import ar.edu.unlam.tallerweb1.servicios.CalificacionService;

@Controller
public class CalificacionController {

	@Autowired
	private CalificacionService servCalificacion;

	@RequestMapping(path = "/guardado-calificacion", method = RequestMethod.POST)
	public ModelAndView guardarCalificacion(
			@ModelAttribute("formularioCalificacion") FormularioCalificacionRestaurante formularioCalificacion,
			HttpServletRequest request) throws Exception {
		ModelMap modelo = new ModelMap();
		modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		modelo.put("titulo", "Calificacion guardada");
		modelo.put("calificacion", formularioCalificacion);
		
		servCalificacion.guardarCalificaciones(formularioCalificacion);

		return new ModelAndView("calificacionExitosa", modelo);

	}
	
	
	@RequestMapping(path = "calificacionPorRestaurante")
	public ModelAndView irACalificacion(HttpServletRequest request) {

		ModelMap model = new ModelMap();

		model.put("restauranteModel", servCalificacion.buscarCalificaciones());
		model.put("titulo", "Calificaciones por restaurante");
		model.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));

		return new ModelAndView("calificacionPorRestaurante", model);
	}

		
	@RequestMapping(path = "/consultarCalificacionRestaurante", method = RequestMethod.POST)
	public ModelAndView pedidos(@ModelAttribute("restauranteModel") RestauranteModel restaurante,
								HttpServletRequest request) {

		ModelMap modelo = new ModelMap();

		modelo.put("restauranteModel", servCalificacion.buscarCalificacionPorRestaurante(restaurante));
		modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		modelo.put("titulo", "Consultar calificaciones");

		return new ModelAndView("calificacionPorRestaurante", modelo);

	}
	
}
