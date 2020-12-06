package ar.edu.unlam.tallerweb1.controladores;

import java.util.Arrays;
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

import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;

import ar.edu.unlam.tallerweb1.modelo.PedidoComidaModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioPedido;
import ar.edu.unlam.tallerweb1.servicios.ComidaService;
import ar.edu.unlam.tallerweb1.servicios.MercadoPagoService;
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
	private MercadoPagoService servicioMercadoPago;
	
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
		request.getSession().setAttribute("idPedido", pedido.getIdPedido());
		
		modelo.put("pedidoComidaList", pedido.getPedidoComida());
	    modelo.put("idPedido", pedido.getIdPedido());
	    modelo.put("hora", pedido.getFechaPedido());
	    modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		
		return new ModelAndView("procesarPedido", modelo);
	}
	
	@RequestMapping(path="/pagar", method = RequestMethod.POST)
	public ModelAndView pagarPedido(HttpServletRequest request) throws MPException {
		ModelMap modelo = new ModelMap();
		modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		
		String[] comidas = request.getParameterValues("comidas");
		String[] preciosString = request.getParameterValues("precios");
		Float[] precios = Arrays.stream(preciosString).map(Float::valueOf).toArray(Float[]::new);
		
		Preference resultado = servicioMercadoPago.procesarPagoDePedido(comidas, precios);
		
		return new ModelAndView("redirect:" + resultado.getSandboxInitPoint());
	}
	
	@RequestMapping("/pagoRealizado")
	public ModelAndView pagoRealizado(HttpServletRequest request) {
		Long idPedido = (Long) request.getSession().getAttribute("idPedido");
		pedidoService.cambiarEstadoDePedido(idPedido, 2L);
		request.getSession().removeAttribute("idPedido");
		return new ModelAndView("pagoRealizado");
	}
	
	@RequestMapping("/pagoFallido")
	public ModelAndView pagoFallido() {	
		return new ModelAndView("pagoFallido");
	}
	
	@RequestMapping("/pagoPendiente")
	public ModelAndView pagoPendiente(@RequestParam("payment_id") Long nroReferencia, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		
		Long idPedido = (Long) request.getSession().getAttribute("idPedido");
		pedidoService.guardarNroReferencia(idPedido, nroReferencia);
		pedidoService.cambiarEstadoDePedido(idPedido, 1L);
		request.getSession().removeAttribute("idPedido");
		
		modelo.put("nroReferencia", nroReferencia);
		return new ModelAndView("pagoPendiente", modelo);
	}
	
	@RequestMapping(path="/detalle-pedido", method=RequestMethod.POST)
	public ModelAndView verDetalleDePedido(@RequestParam("idPedido") Long idPedido, HttpServletRequest request) {		
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
	
	@RequestMapping(path = "/finalizar-pedido", method = RequestMethod.POST)
	public ModelAndView finalizarPedido(@RequestParam("idPedido") Long idPedido) {
		PedidoModel pedido = pedidoService.consultarPedidoPorId(idPedido);
		
		if (pedido.getNroReferenciaMP() != null) {
			ModelMap model = new ModelMap();
			model.put("idPedido", idPedido);
			return new ModelAndView("ingresarNroReferencia", model);
		} else {
			pedidoService.cambiarEstadoDePedido(idPedido, 3L);
			return new ModelAndView("redirect:/pedidosPorRestaurante?id=" + pedido.getRestaurante().getIdRestaurante());
		}
	}
	
	@RequestMapping(path = "/finalizar-pedido/nro-referencia", method = RequestMethod.POST)
	public ModelAndView ingresarNroReferencia(@RequestParam("idPedido") Long idPedido,
											  @RequestParam("nroReferencia") Long nroReferencia) {
		
		PedidoModel pedido = pedidoService.consultarPedidoPorId(idPedido);
		
		if (pedido.getNroReferenciaMP().equals(nroReferencia))  {
			pedidoService.cambiarEstadoDePedido(idPedido, 3L);
			return new ModelAndView("redirect:/pedidosPorRestaurante?id=" + pedido.getRestaurante().getIdRestaurante());
		} else {
			ModelMap model = new ModelMap();
			model.put("idPedido", idPedido);
			model.put("error", "El Nro de Referencia que ingresaste no es correcto, intenta nuevamente");
			return new ModelAndView("ingresarNroReferencia", model);
		}
	}
		
}
