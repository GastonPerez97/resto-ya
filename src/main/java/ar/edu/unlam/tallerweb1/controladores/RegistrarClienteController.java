package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoBusqueda;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioBusqueda;
import ar.edu.unlam.tallerweb1.modelo.resultadoBusqueda.ResultadoBusqueda;
import ar.edu.unlam.tallerweb1.servicios.BusquedaService;
import ar.edu.unlam.tallerweb1.servicios.ComidaService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class RegistrarClienteController {

	@Autowired
	private ServicioLogin servicioLogin;

	@RequestMapping(path = "/registrarCliente")
	public ModelAndView registro() {
		ModelMap model = new ModelMap();
		Usuario usuario = new Usuario();
		model.put("usuario", usuario);
		return new ModelAndView("registrarCliente", model);
	}
	
	@RequestMapping(path = "/guardarRegistro", method = RequestMethod.POST)
	public ModelAndView guardarRegistro(@ModelAttribute("usuario") Usuario usuario) {
		ModelMap model = new ModelMap();
		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		if (usuarioBuscado != null) {
			model.put("error", "El usuario ya existe");
			return new ModelAndView("registrarCliente", model);
		}
		usuario.setRol("usuario");
		servicioLogin.agregarUsuario(usuario);
		return new ModelAndView("redirect:/home");
	}

}
