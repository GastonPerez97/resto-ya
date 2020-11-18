package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.RolModel;
import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioAgregarUsuario;
import ar.edu.unlam.tallerweb1.servicios.RolService;
import ar.edu.unlam.tallerweb1.servicios.UsuarioService;

@Controller
public class UsuarioController {

	@Inject
	private UsuarioService usuarioService;
	
	@Inject
	private RolService rolService;

	@RequestMapping("/usuarios")
	public ModelAndView usuarios(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		
		String rol = (String) request.getSession().getAttribute("ROL");
		
		if (!rol.equals("Admin")) {
			ModelAndView modelAndView =  new ModelAndView("redirect:/login.html");
			return modelAndView;
		}
		

		modelo.put("titulo", "Lista de Usuarios");
		modelo.put("usuarios", usuarioService.listarUsuarios());
		modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));

		return new ModelAndView("usuarios", modelo);
	}

	@RequestMapping(path = "/agregarUsuario", method = RequestMethod.POST)
	public ModelAndView agregarUsuario() {
		ModelMap modelo = new ModelMap();


		FormularioAgregarUsuario formulario = new FormularioAgregarUsuario();
		List<RolModel> listDeRoles = rolService.listarRolUsuario();
		

		modelo.put("titulo", "Agregar Usuario");
		modelo.put("formularioAgregarUsuario", formulario);
		modelo.put("listaDeRoles", listDeRoles);
		

		return new ModelAndView("agregarUsuario", modelo);
	}

	@RequestMapping(path = "/validarUsuario", method = RequestMethod.POST)
	public ModelAndView validarUsuario(@ModelAttribute("formularioAgregarUsuario") FormularioAgregarUsuario formularioAgregarUsuario) {
		return usuarioService.validarUsuario(formularioAgregarUsuario);
	}

	@RequestMapping("/editarUsuario")
	public ModelAndView editarUsuario(@RequestParam("id") Long id) {
		ModelMap modelo = new ModelMap();

		UsuarioModel usuario = usuarioService.buscarUsuarioPorId(id);
		
		
		modelo.put("titulo", "Editar " + usuario.getNombreDeUsuario());
		modelo.put("usuario", usuario);

		return new ModelAndView("editarUsuario", modelo);
	}

	@RequestMapping(path = "/validarEditarUsuario", method = RequestMethod.POST)
	public ModelAndView validarEditarUsuario(@ModelAttribute("usuario") UsuarioModel usuario) {
		ModelMap modelo = new ModelMap();

		modelo.put("titulo", "Editar Usuario");

		usuarioService.modificarUsuario(usuario);
		return new ModelAndView("redirect:/usuarios");

	}

	@RequestMapping("/validarEliminarUsuario")
	public ModelAndView validarEliminarUsuario(@RequestParam("id") Long id) {

		return usuarioService.validarEliminarUsuario(id);
	}

}
