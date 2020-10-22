package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.EstadoReservaModel;
import ar.edu.unlam.tallerweb1.modelo.ReservaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.servicios.ReservaService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReservaController {

	@Autowired
	private ReservaService reservaService;
	
	@Autowired
	private RestauranteService restauranteService;

	@RequestMapping("/reservar")
	public ModelAndView reservar(@RequestParam("idRestaurante") Long idRestaurante) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("reserva", new ReservaModel());
		modelAndView.addObject("restaurante", restauranteService.buscarRestaurantePorId(idRestaurante));
		modelAndView.setViewName("generacionDeReserva");
		
		return modelAndView;
	}

	@RequestMapping(path = "/confirmar-reserva", method = RequestMethod.POST)
	public ModelAndView confirmarReserva(@ModelAttribute("reserva") ReservaModel reservaModel) {
		ModelAndView modelAndView = new ModelAndView();
		
		reservaService.procesarNuevaReserva(reservaModel);
		
		modelAndView.addObject("reserva", reservaService.getReservaByIdReserva(reservaModel.getIdReserva()));
		modelAndView.setViewName("reservaExitosa");
		
		return modelAndView;
	}
}
