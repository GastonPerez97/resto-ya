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
import ar.edu.unlam.tallerweb1.modelo.enums.TipoUsuario;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioBusqueda;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioRegistro;
import ar.edu.unlam.tallerweb1.modelo.resultadoBusqueda.ResultadoBusqueda;
import ar.edu.unlam.tallerweb1.modelo.resultadoBusqueda.ResultadoRegistro;
import ar.edu.unlam.tallerweb1.servicios.BusquedaService;
import ar.edu.unlam.tallerweb1.servicios.ClienteService;
import ar.edu.unlam.tallerweb1.servicios.ComidaService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;
import ar.edu.unlam.tallerweb1.servicios.LoginService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private LoginService loginService;

	@RequestMapping(path = "/registrarCliente")
	public ModelAndView registro() {
		ModelMap model = new ModelMap();
		FormularioRegistro formulario = new FormularioRegistro();
		model.put("formularioRegistro", formulario);
		return new ModelAndView("registrarCliente", model);
	}

	@RequestMapping(path = "/guardarRegistro", method = RequestMethod.POST)
	public ModelAndView guardarRegistro(@ModelAttribute("formularioRegistro") FormularioRegistro registro) {
		ModelMap modelo = new ModelMap();
		Usuario usuario = loginService.consultarUsuario(registro);
		if (usuario != null) {
			modelo.put("error", "El usuario ya existe");
			return new ModelAndView("registrarCliente", modelo);
		} else {

			loginService.guardarUsuario(registro.getDatoBuscado());
			clienteService.guardarCliente(registro);

			return new ModelAndView("registroRealizado");
		}

	}

}
