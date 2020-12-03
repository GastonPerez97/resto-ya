package ar.edu.unlam.tallerweb1.controladores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoComidaModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioPedido;
import ar.edu.unlam.tallerweb1.servicios.ComidaService;
import ar.edu.unlam.tallerweb1.servicios.MailService;
import ar.edu.unlam.tallerweb1.servicios.PedidoComidaService;
import ar.edu.unlam.tallerweb1.servicios.PedidoService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;

@Controller
public class PedidoController {

	
	@Inject
	private ComidaService comidaService;
	
	@Inject
	private PedidoService pedidoService;
	
	@Autowired
	private PedidoComidaService pedidoComidaService;
	
	@Autowired
	private RestauranteService servRestaurante;
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping("/hacerPedido")
	public ModelAndView hacerPedido(@RequestParam("id")Long idRestaurante, HttpServletRequest request) {
		RestauranteModel restaurante = servRestaurante.buscarRestaurantePorId(idRestaurante);
		
		ModelMap modelo = new ModelMap();
		
		FormularioPedido formulario = new FormularioPedido();
		formulario.setRestaurante(idRestaurante);
			
		modelo.put("idRestaurante", restaurante.getIdRestaurante());
		modelo.put("restaurante", restaurante);
		modelo.put("titulo", "Hacer pedido en " + restaurante.getNombre());
		modelo.put("COMIDAS", comidaService.buscarComidasDisponiblesDeRestaurante(idRestaurante));
		modelo.put("formularioPedido", formulario);
		modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		
		return new ModelAndView("hacerPedido", modelo);
		
	}

	@RequestMapping(path="/procesarPedido", method=RequestMethod.POST)
	public ModelAndView procesarPedidoPost(@ModelAttribute("formularioPedido") FormularioPedido formularioPedido, HttpServletRequest request) {		
		ModelMap modelo = new ModelMap();	
		
		formularioPedido.setIdCliente((Long) request.getSession().getAttribute("id"));
		PedidoModel pedido = pedidoService.procesarPedido(formularioPedido);
		
		modelo.put("pedidoComidaList", pedido.getPedidoComida());
	    modelo.put("idPedido", pedido.getIdPedido());
	    modelo.put("hora", pedido.getFechaPedido());
	    modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		
		return new ModelAndView("procesarPedido", modelo);
	}
	
	@RequestMapping(path="/detalle-pedido", method=RequestMethod.POST)
	public ModelAndView verDetalleDePedido(@RequestParam("idPedido")Long idPedido, HttpServletRequest request) {		
		ModelMap modelo = new ModelMap();	
		
		PedidoModel pedido = pedidoService.consultarPedidoPorId(idPedido);
		List<PedidoComidaModel> pedidoComidaList = pedidoComidaService.getComidasByPedido(idPedido);
		Double total = pedidoService.calcularTotalPedido(pedidoComidaList);
		
		modelo.put("pedidoComidaList", pedidoComidaList);
	    modelo.put("pedido", pedido);
	    modelo.put("total", total);
	    modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		
		return new ModelAndView("detallePedido", modelo);
	}
		
}
