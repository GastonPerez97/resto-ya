package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.MesaModel;
import ar.edu.unlam.tallerweb1.modelo.enums.Rol;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioNuevaMesa;
import ar.edu.unlam.tallerweb1.servicios.MesaService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MesaController {
	
	@Autowired
	private RestauranteService restauranteService;
	
	@Autowired
	private MesaService mesaService;

	@RequestMapping(path = "/nueva-mesa", method = RequestMethod.POST)
	public ModelAndView generarNuevaMesa(@RequestParam("idRestaurante") Long idRestaurante, HttpServletRequest request) {
		Long rol = (Long)request.getSession().getAttribute("ROL");
		if (rol != Rol.ADMIN.getId()) 
			return new ModelAndView ("redirect:/logout");
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("restaurante", restauranteService.buscarRestaurantePorId(idRestaurante));
		modelAndView.addObject("formularioNuevaMesa", new FormularioNuevaMesa());
		modelAndView.addObject("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		modelAndView.addObject("rol", request.getSession().getAttribute("ROL"));
		modelAndView.addObject("titulo", "Generar nueva mesa");
		modelAndView.setViewName("generacionNuevaMesa");
		
		return modelAndView;
	}

	@RequestMapping(path = "/guardar-nueva-mesa", method = RequestMethod.POST)
	public ModelAndView generarNuevaMesaPost(@ModelAttribute("formularioNuevaMesa") FormularioNuevaMesa formularioNuevaMesa, HttpServletRequest request) {
		Long rol = (Long)request.getSession().getAttribute("ROL");
		if (rol != Rol.ADMIN.getId()) 
			return new ModelAndView ("redirect:/logout");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		modelAndView.addObject("titulo", "Generar nueva mesa");
		modelAndView.addObject("rol", request.getSession().getAttribute("ROL"));

		MesaModel mesa = mesaService.procesarNuevaMesa(formularioNuevaMesa);
		if (mesa.getIdMesa() != null) {
			modelAndView.addObject("mesa", mesa);
			modelAndView.setViewName("nuevaMesaExitosa");
		} else {
			modelAndView.addObject("error", "El numero de mesa ni la combinacion de la ubicacion pueden repetirse.");
			modelAndView.addObject("restaurante", restauranteService.buscarRestaurantePorId(formularioNuevaMesa.getIdRestaurante()));
			modelAndView.addObject("formularioNuevaMesa", formularioNuevaMesa);
			modelAndView.setViewName("generacionNuevaMesa");
		}
		
		return modelAndView;
	}
}
