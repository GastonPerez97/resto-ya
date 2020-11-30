package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.CalificacionModel;
import ar.edu.unlam.tallerweb1.modelo.HorarioModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoComidaModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioCalificarRestaurante;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioRestauranteHorario;
import ar.edu.unlam.tallerweb1.servicios.CalificacionService;
import ar.edu.unlam.tallerweb1.servicios.HorarioService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteHorarioService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;

@Controller
public class CalificacionController {

	@Autowired
	private CalificacionService servCalificacion;

	// En Proceso

	@RequestMapping(path = "/guardado-calificacion", method = RequestMethod.POST)
	public ModelAndView guardarCalificacion(@ModelAttribute("calificacion") CalificacionModel calificacion)
			throws Exception {
		ModelMap modelo = new ModelMap();
		modelo.put("calificacion", calificacion);

		servCalificacion.guardarCalificaciones(calificacion);

		return null;

	}

	
	
	/*
	 * @RequestMapping(path = "/nueva-calificacion") public ModelAndView
	 * irACalificacion() { List <Long> array= new ArrayList<>();
	 * 
	 * for (int i=0; i <4 ; i++) { array.add((long) (i+1)); }
	 * 
	 * ModelMap model = new ModelMap();
	 * 
	 * model.put("calificacionArray", array);
	 * 
	 * return new ModelAndView("calificarRestaurante2", model); }
	 */
	
	
	/*
	 * @RequestMapping(path="/guardado-calificacion", method=RequestMethod.POST)
	 * public ModelAndView verDetalleDePedido(@RequestParam("calificacion")
	 * CalificacionModel calificacion, HttpServletRequest request) { ModelMap modelo
	 * = new ModelMap();
	 * 
	 * CalificacionModel calificacion =
	 * servCalificacion.guardarCalificaciones(calificacion); List<PedidoComidaModel>
	 * pedidoComidaList = pedidoComidaService.getComidasByPedido(idPedido); Double
	 * total = pedidoService.calcularTotalPedido(pedidoComidaList);
	 * 
	 * modelo.put("pedidoComidaList", pedidoComidaList); modelo.put("pedido",
	 * pedido); modelo.put("total", total); modelo.put("nombreUsuario",
	 * request.getSession().getAttribute("NOMBRE"));
	 * 
	 * return new ModelAndView("detallePedido", modelo); }
	 */

	/*
	 * @RequestMapping(path = "/guardado-calificacion", method = RequestMethod.POST)
	 * public ModelAndView guardarCalificacion(@RequestParam("idCalificacion") Long
	 * idCalificacion, HttpServletRequest request) { ModelMap modelo = new
	 * ModelMap(); return null;
	 * 
	 * }
	 */

}
