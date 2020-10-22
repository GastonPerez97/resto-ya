package ar.edu.unlam.tallerweb1.controladores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.PedidoModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioPedido;
import ar.edu.unlam.tallerweb1.servicios.ComidaService;
import ar.edu.unlam.tallerweb1.servicios.PedidoService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;

@Controller
public class PedidoController {

	
	@Inject
	private ComidaService comidaService;
	
	@Inject
	private PedidoService pedidoService;
	
	
	@Autowired
	private RestauranteService servRestaurante;
	
@RequestMapping("/hacerPedido")
public ModelAndView hacerPedido(@RequestParam("id")Long id) {
	RestauranteModel restaurante = servRestaurante.buscarRestaurantePorId(id);
	
	ModelMap modelo = new ModelMap();
	
	FormularioPedido formulario = new FormularioPedido();
	formulario.setRestaurante(id);
		
	modelo.put("idRestaurante", restaurante.getIdRestaurante());
	modelo.put("restaurante", restaurante);
	modelo.put("titulo", "Hacer pedido en " + restaurante.getNombre());
	modelo.put("COMIDAS", comidaService.buscarComida());
	modelo.put("formularioPedido", formulario);
	
	return new ModelAndView("hacerPedido", modelo);
	
}



@RequestMapping(path="/procesarPedido", method=RequestMethod.POST)
public ModelAndView procesarPedidoPost(@ModelAttribute("formularioPedido") FormularioPedido formularioPedido, 
										@RequestParam("checkboxComidas") ArrayList<Long> idComidas) {		
	ModelMap modelo = new ModelMap();	
	
	 DateFormat dateFormat = new SimpleDateFormat("HH:mm");
	 Date date = new Date();
	    
	RestauranteModel restaurante = servRestaurante.buscarRestaurantePorId(formularioPedido.getRestaurante()); 	
	PedidoModel pedido = pedidoService.cargarPedidoComida(idComidas);
	
	pedido.setRestaurante(restaurante);

	pedidoService.guardarPedido(pedido);
	
	modelo.put("pedidoComidaList", pedido.getPedidoComida());
    modelo.put("idPedido", pedido.getIdPedido());
    modelo.put("hora",dateFormat.format(date));
	
	return new ModelAndView("procesarPedido", modelo);
}
	
}
