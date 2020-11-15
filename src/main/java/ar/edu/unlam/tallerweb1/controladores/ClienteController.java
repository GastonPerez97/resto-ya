package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioRegistro;
import ar.edu.unlam.tallerweb1.servicios.ClienteService;
import ar.edu.unlam.tallerweb1.servicios.LoginService;

@Controller
public class ClienteController {

	
	  @Autowired private ClienteService clienteService;
	  
	  @Autowired private LoginService loginService;
	  
	  @RequestMapping(path = "/registrarCliente") public ModelAndView registro() {
	  ModelMap model = new ModelMap(); FormularioRegistro formulario = new
	  FormularioRegistro(); model.put("formularioRegistro", formulario); return new
	  ModelAndView("registrarCliente", model); }
	  
	  @RequestMapping(path = "/guardarRegistro", method = RequestMethod.POST)
	  public ModelAndView guardarRegistro(@ModelAttribute("formularioRegistro")
	  FormularioRegistro registro) { ModelMap modelo = new ModelMap(); Usuario
	  usuario = loginService.consultarUsuarioRegistrado(registro); if (usuario !=
	  null) { modelo.put("error", "El usuario ya existe"); return new
	  ModelAndView("registrarCliente", modelo); } else {
	  
	  loginService.guardarUsuarioRegistrado(registro.getDatoBuscado());
	  clienteService.guardarClienteRegistrado(registro);
	  
	  return new ModelAndView("registroRealizado"); }
	  
	  }
	 

}
