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
import ar.edu.unlam.tallerweb1.servicios.CalificacionService;
import ar.edu.unlam.tallerweb1.servicios.HorarioService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteHorarioService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;

@Controller
public class CalificacionController {

	@Autowired
	private CalificacionService servCalificacion;

	/*
	 * @RequestMapping(path = "/nueva-calificacion") public ModelAndView
	 * irACalificacion() {
	 * 
	 * ModelMap model = new ModelMap();
	 * 
	 * model.put("calificacionModel", servCalificacion.buscarCalificaciones());
	 * 
	 * return new ModelAndView("calificarRestaurante", model); }
	 */

	// En Proceso

	@RequestMapping(path = "/guardado-calificacion", method = RequestMethod.POST)
	public ModelAndView guardarCalificacion(@RequestParam("id") Long id, HttpServletRequest request) throws Exception {
		ModelMap modelo = new ModelMap();
		return null;

	}

}
