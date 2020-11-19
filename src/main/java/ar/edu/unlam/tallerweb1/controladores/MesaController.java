package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.EstadoReservaModel;
import ar.edu.unlam.tallerweb1.modelo.MesaModel;
import ar.edu.unlam.tallerweb1.modelo.ReservaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteHorarioModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioGeneracionReserva;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioHorarioReserva;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioNuevaMesa;
import ar.edu.unlam.tallerweb1.servicios.MesaService;
import ar.edu.unlam.tallerweb1.servicios.ReservaService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MesaController {
	
	@Autowired
	private RestauranteService restauranteService;
	
	@Autowired
	private MesaService mesaService;

	@RequestMapping(path = "/nueva-mesa", method = RequestMethod.POST)
	public ModelAndView generarNuevaMesa(@RequestParam("idRestaurante") Long idRestaurante, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("restaurante", restauranteService.buscarRestaurantePorId(idRestaurante));
		modelAndView.addObject("formularioNuevaMesa", new FormularioNuevaMesa());
		modelAndView.setViewName("generacionNuevaMesa");
		
		return modelAndView;
	}

	@RequestMapping(path = "/guardar-nueva-mesa", method = RequestMethod.POST)
	public ModelAndView generarNuevaMesaPost(@ModelAttribute("formularioNuevaMesa") FormularioNuevaMesa formularioNuevaMesa, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		MesaModel mesa = mesaService.ProcesarNuevaMesa(formularioNuevaMesa);
		modelAndView.addObject("mesa", mesa);
		modelAndView.setViewName("nuevaMesaExitosa");
		
		return modelAndView;
	}
}
