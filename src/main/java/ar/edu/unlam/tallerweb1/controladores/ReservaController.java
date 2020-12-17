package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.ReservaModel;
import ar.edu.unlam.tallerweb1.modelo.enums.EstadoReserva;
import ar.edu.unlam.tallerweb1.modelo.enums.Rol;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioGeneracionReserva;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioHorarioReserva;
import ar.edu.unlam.tallerweb1.servicios.EstadoReservaService;
import ar.edu.unlam.tallerweb1.servicios.MesaService;
import ar.edu.unlam.tallerweb1.servicios.ReservaService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;

import java.sql.Date;
import java.util.Calendar;
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
	
	@Autowired
	private EstadoReservaService estadoReservaService;

	@RequestMapping(path = "/reservar", method = RequestMethod.POST)
	public ModelAndView reservar(@RequestParam("idRestaurante") Long idRestaurante, @RequestParam("fechaReserva") Date fechaReserva, HttpServletRequest request) {
		Long rol = (Long)request.getSession().getAttribute("ROL");
		if (rol != Rol.CLIENTE.getId()) 
			return new ModelAndView ("redirect:/logout");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("titulo", "Reservar");

		modelAndView.addObject("matriz", mesaService.generarMapaDeMesas(mesaService.getMesasDisponiblesParaReservaByRestaurante(idRestaurante)));

		modelAndView.addObject("formularioGeneracionReserva", new FormularioGeneracionReserva(fechaReserva));
		modelAndView.addObject("restaurante", restauranteService.buscarRestaurantePorId(idRestaurante));
		modelAndView.addObject("mesas", mesaService.getMesasDisponiblesParaReservaByRestaurante(idRestaurante));
		modelAndView.addObject("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		modelAndView.addObject("rol", request.getSession().getAttribute("ROL"));
		modelAndView.setViewName("generacionDeReserva");
		
		return modelAndView;
	}

	@RequestMapping(path = "/confirmar-reserva", method = RequestMethod.POST)
	public ModelAndView confirmarReserva(@ModelAttribute("formularioGeneracionReserva") FormularioGeneracionReserva formularioGeneracionReserva, HttpServletRequest request) {
		Long rol = (Long)request.getSession().getAttribute("ROL");
		if (rol != Rol.CLIENTE.getId()) 
			return new ModelAndView ("redirect:/logout");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("titulo", "Reserva exitosa");
		modelAndView.addObject("rol", request.getSession().getAttribute("ROL"));

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
	
	@RequestMapping(path = "/restaurante/reservas", method = RequestMethod.GET)
	public ModelAndView reservasPorResutauranteGet(@RequestParam("idRestaurante") Long idRestaurante, HttpServletRequest request) {
		Long rol = (Long)request.getSession().getAttribute("ROL");
		if (rol != Rol.ADMIN.getId()) 
			return new ModelAndView ("redirect:/logout");
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("titulo", "Reservas");
		modelAndView.addObject("restaurante", restauranteService.buscarRestaurantePorId(idRestaurante));
		modelAndView.addObject("estados", estadoReservaService.buscarEstadosReserva());
		modelAndView.addObject("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		modelAndView.addObject("rol", request.getSession().getAttribute("ROL"));
		modelAndView.setViewName("reservasDeRestaurante");
		
		return modelAndView;
	}
	
	@RequestMapping(path = "/restaurante/reservas", method = RequestMethod.POST)
	public ModelAndView reservasPorResutaurantePost(@RequestParam("idRestaurante") Long idRestaurante, 
													@RequestParam("idEstadoReserva") Long idEstadoReserva,
													@RequestParam(name = "fechaDesde", required = false) Date fechaDesde,
													@RequestParam(name = "fechaHasta", required = false) Date fechaHasta, HttpServletRequest request) {
		Long rol = (Long)request.getSession().getAttribute("ROL");
		if (rol != Rol.ADMIN.getId()) 
			return new ModelAndView ("redirect:/logout");
		
		ModelAndView modelAndView = new ModelAndView();
		
		List<ReservaModel> reservas = reservaService.buscarReservasPorRestauranteYEstadoYFechaDesdeHasta(idRestaurante, idEstadoReserva, fechaDesde, fechaHasta);
		
		modelAndView.addObject("titulo", "Reservas");
		modelAndView.addObject("reservas", reservas);
		modelAndView.addObject("restaurante", restauranteService.buscarRestaurantePorId(idRestaurante));
		modelAndView.addObject("fechaDesde", fechaDesde);
		modelAndView.addObject("fechaHasta", fechaHasta);		
		modelAndView.addObject("estados", estadoReservaService.buscarEstadosReserva());
		modelAndView.addObject("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		modelAndView.addObject("rol", request.getSession().getAttribute("ROL"));

		modelAndView.setViewName("reservasDeRestaurante");
		
		return modelAndView;
	}
	
	@RequestMapping(path = "/reserva/modificarEstado", method = RequestMethod.POST)
	public ModelAndView modificarEstadoReserva(@RequestParam("idRestaurante") Long idRestaurante, 
											   @RequestParam("idReserva") Long idReserva,
											   @RequestParam(name = "fechaDesde", required = false) Date fechaDesde,
											   @RequestParam(name = "fechaHasta", required = false) Date fechaHasta, 
											   @RequestParam("idEstadoReserva") Long idEstadoReserva, HttpServletRequest request) {
		Long rol = (Long)request.getSession().getAttribute("ROL");
		if (rol != Rol.ADMIN.getId()) 
			return new ModelAndView ("redirect:/logout");
		
		ModelAndView modelAndView = new ModelAndView();
		reservaService.modificarEstadoReserva(idReserva, idEstadoReserva);
		
		List<ReservaModel> reservas = reservaService.buscarReservasPorRestauranteYEstadoYFechaDesdeHasta(idRestaurante, EstadoReserva.PENDIENTE_DE_CONFIRMACION.getId(), fechaDesde, fechaHasta);

		modelAndView.addObject("titulo", "Reservas");
		modelAndView.addObject("reservas", reservas);
		modelAndView.addObject("restaurante", restauranteService.buscarRestaurantePorId(idRestaurante));
		modelAndView.addObject("fechaDesde", fechaDesde);
		modelAndView.addObject("fechaHasta", fechaHasta);
		modelAndView.addObject("estados", estadoReservaService.buscarEstadosReserva());
		modelAndView.addObject("mensaje", "Reserva modificada exitosamente");
		modelAndView.addObject("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		modelAndView.addObject("rol", request.getSession().getAttribute("ROL"));

		modelAndView.setViewName("reservasDeRestaurante");
		
		return modelAndView;
	}
	
	@RequestMapping(path = "/reserva/modificarMiReserva", method = RequestMethod.POST)
	public ModelAndView modificarMiReserva(@RequestParam("idReserva") Long idReserva,
											@RequestParam("idEstadoReserva") Long idEstadoReserva, HttpServletRequest request) {
		Long rol = (Long)request.getSession().getAttribute("ROL");
		if (rol != Rol.CLIENTE.getId()) 
			return new ModelAndView ("redirect:/logout");
		
		ModelAndView modelAndView = new ModelAndView();
		reservaService.modificarEstadoReserva(idReserva, idEstadoReserva);
		
		List<ReservaModel> reservas = reservaService.getReservasDeCliente((Long)request.getSession().getAttribute("id"));
		
		modelAndView.addObject("titulo", "Mis Reservas");
		modelAndView.addObject("reservas", reservas);
		modelAndView.addObject("mensaje", "Reserva modificada exitosamente");
		modelAndView.addObject("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		modelAndView.addObject("rol", request.getSession().getAttribute("ROL"));

		modelAndView.setViewName("misReservas");
		
		return modelAndView;
	}
}
