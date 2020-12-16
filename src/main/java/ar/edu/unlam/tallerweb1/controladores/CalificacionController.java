package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioCalificacionComida;

import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioCalificacionRestaurante;
import ar.edu.unlam.tallerweb1.servicios.CalificacionService;

@Controller
public class CalificacionController {

	@Autowired
	private CalificacionService servCalificacion;

	@RequestMapping(path = "/guardado-calificacion-restaurante", method = RequestMethod.POST)
	public ModelAndView guardarCalificacion(
			@ModelAttribute("formularioCalificacion") FormularioCalificacionRestaurante formularioCalificacion,
			HttpServletRequest request) throws Exception {
		ModelMap modelo = new ModelMap();
		servCalificacion.guardarCalificaciones(formularioCalificacion);
		modelo.put("calificacion", servCalificacion.buscarCalificaciones());
		return new ModelAndView("calificacionRestauranteExitosa", modelo);

	}

	@RequestMapping(path = "/guardado-calificacion-comida", method = RequestMethod.POST)
	public ModelAndView guardarCalificacionComidas(

			@ModelAttribute("formularioCalificacionComida") FormularioCalificacionComida formularioCalificacionComida,
			HttpServletRequest request) throws Exception {
		ModelMap modelo = new ModelMap();
		servCalificacion.guardarCalificacionesComidas(formularioCalificacionComida);
		modelo.put("calificacion", servCalificacion.buscarCalificacionesComidas());
		return new ModelAndView("calificacionComidasExitosa", modelo);

	}

	@RequestMapping(path = "/consultarCalificacionRestaurante", method = RequestMethod.POST)
	public ModelAndView pedidos(@ModelAttribute("calificacionRestaurante") Long idRestaurante) {

		ModelMap modelo = new ModelMap();

		modelo.put("restaurante", servCalificacion.buscarCalificacionPorRestaurante(idRestaurante));

		return new ModelAndView("calificacionPorRestaurante", modelo);

	}

}
