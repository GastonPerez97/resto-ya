package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorContacto {

	@RequestMapping("/mostrarContacto")
	public ModelAndView contact() {
		ModelMap modelo = new ModelMap();
		modelo.put("titulo", "Contacto");
		
		return new ModelAndView("contacto", modelo);
	}
	
	@RequestMapping(path = "/mostrarDatos", method = RequestMethod.GET)
	public ModelAndView datos() {
		ModelMap modelo = new ModelMap();
		modelo.put("materia", "Taller Web 1");
		modelo.put("lenguaje", "Java");
		modelo.put("titulo", "Datos");
		
		return new ModelAndView("datos", modelo);
	}
	
	@RequestMapping("/mostrarConfirmacion")
	public ModelAndView confirmacion(@RequestParam(value="nombre", required = false) String name,
									 @RequestParam(value="apellido", required = false) String surname) {
		ModelMap modelo = new ModelMap();
		modelo.put("nombreM", name);
		modelo.put("apellidoM", surname);
		modelo.put("titulo", "Confirmacion");
		
		return new ModelAndView("confirmacion", modelo);
	}
	
}
