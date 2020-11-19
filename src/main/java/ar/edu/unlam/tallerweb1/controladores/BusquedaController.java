package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoBusqueda;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioBusqueda;
import ar.edu.unlam.tallerweb1.modelo.resultadoBusqueda.ResultadoBusqueda;
import ar.edu.unlam.tallerweb1.servicios.BusquedaService;
import ar.edu.unlam.tallerweb1.servicios.ComidaService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;

@Controller
public class BusquedaController {

	@Autowired
	private BusquedaService busquedaService;

	@RequestMapping("/home")
	public ModelAndView buscar(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		modelo.put("formularioBusqueda", new FormularioBusqueda());
		modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		return new ModelAndView("buscador", modelo);
	}

	@RequestMapping(path = "/buscar", method = RequestMethod.POST)
	public ModelAndView buscarPost(@ModelAttribute("formularioBusqueda") FormularioBusqueda busqueda, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		ResultadoBusqueda resultadoBusqueda = busquedaService.buscar(busqueda);  
		modelo.put("resultadoBusqueda", resultadoBusqueda);
		modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));

		if (busqueda.getTipoBusquedaSeleccionada().equals(TipoBusqueda.COMIDA.ordinal()))
			return new ModelAndView("comidasBuscadas", modelo);
		else
			return new ModelAndView("restaurantesBuscados", modelo);
	}

}
