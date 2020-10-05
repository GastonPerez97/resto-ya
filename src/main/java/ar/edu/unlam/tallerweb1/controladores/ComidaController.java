package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.servicios.ComidaService;

@Controller
public class ComidaController {
	
	@Inject
	private ComidaService comidaService;
	
	@RequestMapping("/hacerPedido")
	public ModelAndView hacerPedido(
			@RequestParam(value="id", required = true)Long id) {
		ComidaModel comida = comidaService.mostrarComidaModel(id);
		ModelMap modelo = new ModelMap();
		modelo.put("hacerPedido", comida);
		return new ModelAndView("hacerPedido", modelo);
		
	}
					
	
	
	
	
}
