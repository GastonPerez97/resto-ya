package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorSaludar {
	
	@RequestMapping(path = "/saludar-input", method = RequestMethod.GET)
	public ModelAndView irASaludarInput() {
		return new ModelAndView("saludar-input");
	}
	
	@RequestMapping("/saludar")
	public ModelAndView saludar(@RequestParam("nombre") String nombreRecibido, @RequestParam("apellido") String apellidoRecibido) {
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("nombre", nombreRecibido);
		modelo.put("apellido", apellidoRecibido);
		
		return new ModelAndView("saludar", modelo);
	}
	
	@RequestMapping("/hola/{nombre}/{apellido}")
	public ModelAndView hola(@PathVariable("nombre") String nombreRecibido, @PathVariable("apellido") String apellidoRecibido) {
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("nombre", nombreRecibido);
		modelo.put("apellido", apellidoRecibido);
		
		return new ModelAndView("saludar", modelo);
	}
	
}
