package ar.edu.unlam.tallerweb1.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.ClienteModel;
import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioRegistro;
import ar.edu.unlam.tallerweb1.servicios.ClienteService;
import ar.edu.unlam.tallerweb1.servicios.LoginService;
import ar.edu.unlam.tallerweb1.servicios.MailService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private MailService mailService;

	@RequestMapping(path = "/registrate")
	public ModelAndView registro() {

		ModelMap model = new ModelMap();

		FormularioRegistro formulario = new FormularioRegistro();

		model.put("formularioRegistro", formulario);

		return new ModelAndView("registrarCliente", model);
	}

	@RequestMapping(path = "/guardarRegistro", method = RequestMethod.POST)
	public ModelAndView guardarRegistro(@ModelAttribute("formularioRegistro") FormularioRegistro registro) {

		ModelMap modelo = new ModelMap();

		UsuarioModel usuario = loginService.consultarUsuarioRegistrado(registro);

		if (usuario != null) {

			modelo.put("error", "El usuario ya existe");

			return new ModelAndView("registrarCliente", modelo);

		} else {

			loginService.guardarUsuarioRegistrado(registro.getUsuarioModel());

			clienteService.guardarClienteRegistrado(registro);

			mailService.enviarMail(registro.getUsuarioModel().getEmail(),
								   mailService.getAsuntoConfirmacionRegistro(),
								   mailService.getMensajeRegistro(registro.getClienteModel().getNombre()));

			return new ModelAndView("redirect:/login");
		}

	}

	@RequestMapping(path = "/historicoPedidos")
	public ModelAndView irAHistorico() {

		ModelMap model = new ModelMap();

		model.put("clienteModel", clienteService.buscarClientes());
	
		return new ModelAndView("consultarHistorico", model);
	}

	@RequestMapping(path = "/consultarPedidos", method = RequestMethod.POST)
	public ModelAndView pedidos(@ModelAttribute("clienteModel") ClienteModel cliente) {

		ModelMap modelo = new ModelMap();

		modelo.put("pedidoModel", clienteService.buscarPedidosCliente(cliente));

		return new ModelAndView("pedidosPorCliente", modelo);

	}
}
