package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.ReservaModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioGeneracionReserva;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioHorarioReserva;
import ar.edu.unlam.tallerweb1.servicios.MesaService;
import ar.edu.unlam.tallerweb1.servicios.ReservaService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReservaController {

	@Autowired
	private ReservaService reservaService;
	
	@Autowired
	private RestauranteService restauranteService;
	
	@Autowired
	private MesaService mesaService;

	@RequestMapping(path = "/reservar", method = RequestMethod.POST)
	public ModelAndView reservar(@RequestParam("idRestaurante") Long idRestaurante, @RequestParam("fechaReserva") Date fechaReserva, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("titulo", "Reservar");

		modelAndView.addObject("matriz", mesaService.generarMapaDeMesas(mesaService.getMesasDisponiblesParaReservaByRestaurante(idRestaurante)));

		modelAndView.addObject("formularioGeneracionReserva", new FormularioGeneracionReserva(fechaReserva));
		modelAndView.addObject("restaurante", restauranteService.buscarRestaurantePorId(idRestaurante));
		modelAndView.addObject("mesas", mesaService.getMesasDisponiblesParaReservaByRestaurante(idRestaurante));
		modelAndView.addObject("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		modelAndView.setViewName("generacionDeReserva");
		
		return modelAndView;
	}

	@RequestMapping(path = "/confirmar-reserva", method = RequestMethod.POST)
	public ModelAndView confirmarReserva(@ModelAttribute("formularioGeneracionReserva") FormularioGeneracionReserva formularioGeneracionReserva, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("titulo", "Reserva exitosa");
		
		formularioGeneracionReserva.setIdCliente((Long)request.getSession().getAttribute("id"));
		
		ReservaModel reserva = reservaService.procesarNuevaReserva(formularioGeneracionReserva);
		
		modelAndView.addObject("reserva", reserva);
		modelAndView.addObject("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		modelAndView.setViewName("reservaExitosa");
		
		return modelAndView;
	}
	
	@RequestMapping(path = "/get-horarios-mesa", method = RequestMethod.POST)
	public @ResponseBody List<FormularioHorarioReserva> getHorariosParaMesa(@RequestParam("fechaReserva") Date fechaReserva, @RequestParam("idMesa") Long idMesa) {
		
		FormularioGeneracionReserva formularioGeneracionReserva = new FormularioGeneracionReserva(fechaReserva);
		formularioGeneracionReserva.setIdMesa(idMesa);
				
		return reservaService.getHorariosDisponiblesParaReservaDeMesa(formularioGeneracionReserva);
	}
}
