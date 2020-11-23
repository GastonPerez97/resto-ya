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
	public ModelAndView hacerPedido(@RequestParam("id")Long id, HttpServletRequest request) {
		RestauranteModel restaurante = servRestaurante.buscarRestaurantePorId(id);
		
		ModelMap modelo = new ModelMap();
		
		FormularioPedido formulario = new FormularioPedido();
		formulario.setRestaurante(id);
			
		modelo.put("idRestaurante", restaurante.getIdRestaurante());
		modelo.put("restaurante", restaurante);
		modelo.put("titulo", "Hacer pedido en " + restaurante.getNombre());
		modelo.put("COMIDAS", comidaService.buscarComida());
		modelo.put("formularioPedido", formulario);
		modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		
		return new ModelAndView("hacerPedido", modelo);
		
	}

	@RequestMapping(path="/procesarPedido", method=RequestMethod.POST)
	public ModelAndView procesarPedidoPost(@ModelAttribute("formularioPedido") FormularioPedido formularioPedido, 
											@RequestParam("checkboxComidas") ArrayList<Long> idComidas, HttpServletRequest request) {		
		ModelMap modelo = new ModelMap();	
		
		 DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		 Date date = new Date();
		    
		RestauranteModel restaurante = servRestaurante.buscarRestaurantePorId(formularioPedido.getRestaurante()); 	
		PedidoModel pedido = pedidoService.cargarPedidoComida(idComidas);
		
		pedido.setRestaurante(restaurante);
	
		pedidoService.guardarPedido(pedido);
		
		List<ComidaModel> comidas = new ArrayList<ComidaModel>();
		
		for (Long idComida : idComidas) {
			comidas.add(comidaService.consultarComidaPorId(idComida));
		}
		
		mailService.enviarMail("tallerweb1.proyecto@gmail.com",
							   mailService.getAsuntoConfirmacionPedido(),
							   mailService.getMensajePedido(comidas));
		
		modelo.put("pedidoComidaList", pedido.getPedidoComida());
	    modelo.put("idPedido", pedido.getIdPedido());
	    modelo.put("hora",dateFormat.format(date));
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
