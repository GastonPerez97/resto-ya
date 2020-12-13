package ar.edu.unlam.tallerweb1.controladores;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.ReclamoModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioGeneracionReclamo;
import ar.edu.unlam.tallerweb1.servicios.PedidoService;
import ar.edu.unlam.tallerweb1.servicios.ReclamoService;

@Controller
public class ReclamoController {

	@Inject
	private PedidoService pedidoService;
	
	@Inject
	private ReclamoService reclamoService;
	
	@RequestMapping(path="/generarReclamo", method=RequestMethod.POST)
	public ModelAndView generarReclamo(@RequestParam("idPedido")Long idPedido, HttpServletRequest request) {		
		ModelMap modelo = new ModelMap();	
		
		FormularioGeneracionReclamo formulario = new FormularioGeneracionReclamo(); 
		formulario.setPedido(pedidoService.consultarPedidoPorId(idPedido));

		modelo.put("titulo", "Generar Reclamo");
		modelo.put("formularioGeneracionReclamo", formulario);
	    modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		
		return new ModelAndView("generarReclamo", modelo);
	}
	
	@RequestMapping(path="/reclamoGenerado", method=RequestMethod.POST)
	public ModelAndView reclamoGenerado(@ModelAttribute("formularioGeneracionReclamo") FormularioGeneracionReclamo formularioGeneracionReclamo,
										HttpServletRequest request) {		
		
		ModelMap modelo = new ModelMap();
		modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		modelo.put("titulo", "Reclamo generado");
		
		ReclamoModel reclamo = new ReclamoModel(formularioGeneracionReclamo.getReclamo().getDetalle(), formularioGeneracionReclamo.getPedido());
		reclamoService.guardarReclamo(reclamo);
		
		return new ModelAndView("reclamoGeneradoExitoso", modelo);
	}
	
	@RequestMapping(path="/verReclamo")
	public ModelAndView verReclamo(@RequestParam("id")Long idPedido, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		
		ReclamoModel reclamo = reclamoService.buscarReclamoPorIdPedido(idPedido);
		
		modelo.put("titulo", "Ver Reclamo");
		modelo.put("reclamo", reclamo);
		modelo.put("idPedido", idPedido);
		modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
				  		
		return new ModelAndView("verReclamo", modelo);
	}
		
}
