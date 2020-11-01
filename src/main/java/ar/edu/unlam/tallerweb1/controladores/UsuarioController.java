package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;
import ar.edu.unlam.tallerweb1.servicios.UsuarioService;

@Controller 
public class UsuarioController {
	
	@Inject
	private UsuarioService usuarioService;
	
	
	@RequestMapping("/usuarios")
	public ModelAndView usuarios() {
		ModelMap modelo = new ModelMap();
		
		modelo.put("titulo", "Lista de Usuarios");
		modelo.put("USUARIOS", usuarioService.buscarUsuarios());
		
		return new ModelAndView("usuarios", modelo);
	}
	
	@RequestMapping(path = "/agregarUsuario", method = RequestMethod.POST)
	public ModelAndView agregarUsuario() {
		ModelMap modelo = new ModelMap();
		
		UsuarioModel usuario = new UsuarioModel();
		
		modelo.put("titulo", "Agregar Usuario");
		modelo.put("usuario", usuario);
		
		return new ModelAndView("agregarUsuario", modelo);
	}
	
	
	@RequestMapping(path = "/validarUsuario", method = RequestMethod.POST)
	public ModelAndView validarUsuario(
			@ModelAttribute("usuario") UsuarioModel usuario) {
		ModelMap modelo = new ModelMap();

		modelo.put("titulo", "Agregar Usuario");
		
		if (usuarioService.existeUsuarioPorNombre(usuario.getNombre())) {
			modelo.put("errorValidacion", "El nombre de usuario ya existe, contacte al administrador");
			return new ModelAndView("agregarUsuario", modelo);
		} else {
			usuarioService.guardarUsuario(usuario);
			return new ModelAndView("redirect:/usuarios");
		}
	}
	
	
	@RequestMapping("/editarUsuario")
	public ModelAndView editarUsuario(@RequestParam("id") Long id) {
		
		UsuarioModel usuario = usuarioService.buscarUsuarioPorId(id);
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("titulo", "Editar " + usuario.getNombre());
		modelo.put("usuario", usuario);
		
		return new ModelAndView("editarUsuario", modelo);
	}
	
	@RequestMapping(path = "/validarEditarUsuario", method = RequestMethod.POST)
	public ModelAndView validarEditarUsuario(
			@ModelAttribute("usuario") UsuarioModel usuario) {
		ModelMap modelo = new ModelMap();

		modelo.put("titulo", "Editar Usuario");
		
		if (usuarioService.existeUsuarioPorNombre(usuario.getNombre())) {
			modelo.put("errorValidacion", "El nombre de usuario ya existe, contacte al administrador");
			return new ModelAndView("editarUsuario", modelo);
		} else { 
			usuarioService.modificarUsuario(usuario);
			return new ModelAndView("redirect:/usuarios");
		}
	}
	
	
	
	
	@RequestMapping("/eliminarUsuario")
	public ModelAndView eliminarUsuario(@RequestParam("id") Long id) {
		
		usuarioService.eliminarUsuario(id);
		
		return new ModelAndView("redirect:/usuarios");
	}
	


	
	

}
