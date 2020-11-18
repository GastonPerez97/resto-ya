package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorLogin {


	private ServicioLogin servicioLogin;

	@Autowired
	public ControladorLogin(ServicioLogin servicioLogin){
		this.servicioLogin = servicioLogin;
	}


	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		UsuarioModel usuario = new UsuarioModel();

		modelo.put("titulo", "Login");
		modelo.put("usuario", usuario);
		
		return new ModelAndView("login", modelo);
	}


	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") UsuarioModel usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		model.put("titulo", "Contacto");
		

		UsuarioModel usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		if (usuarioBuscado != null) {
			request.getSession().setAttribute("ROL", "Admin");
			request.getSession().setAttribute("NOMBRE", usuarioBuscado.getNombreDeUsuario());
			return new ModelAndView("redirect:/home");
		} else {

			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);
	}

	@RequestMapping("/logout")
	public ModelAndView irAlogout(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		request.getSession().setAttribute("ROL", null);
		request.getSession().setAttribute("NOMBRE", null);

		
		return new ModelAndView("logout", modelo);
	}
	
	
	public ModelAndView irAHome() {
		ModelMap modelo = new ModelMap();
		modelo.put("titulo", "Home");
		
		return new ModelAndView("home", modelo);
	}


	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/home");
	}
}

