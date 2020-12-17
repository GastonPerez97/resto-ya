
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
import ar.edu.unlam.tallerweb1.modelo.enums.Rol;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioAgregarUsuario; 
import ar.edu.unlam.tallerweb1.servicios.RolService; 
import ar.edu.unlam.tallerweb1.servicios.UsuarioRolService; 
import ar.edu.unlam.tallerweb1.servicios.UsuarioService;
  
@Controller public class UsuarioController {
  
	@Inject private UsuarioService usuarioService;
  
	@Inject private RolService rolService;
  
	@Inject private UsuarioRolService usuarioRolService;
  
	@RequestMapping("/usuarios") 
	public ModelAndView usuarios(HttpServletRequest request) {
		Long rol = (Long)request.getSession().getAttribute("ROL");
		if (rol != Rol.ADMIN.getId()) 
			return new ModelAndView ("redirect:/logout");
  
		ModelMap modelo = new ModelMap();
		modelo.put("titulo", "Lista de Usuarios"); 
		modelo.put("usuarios", usuarioService.listarUsuarios()); 
		modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		modelo.put("rol", request.getSession().getAttribute("ROL"));
  
		return new ModelAndView("usuarios", modelo); 
	}
  
	@RequestMapping(path = "/agregarUsuario", method = RequestMethod.POST) 
	public ModelAndView agregarUsuario(HttpServletRequest request) { 
		Long rol = (Long)request.getSession().getAttribute("ROL");
		if (rol != Rol.ADMIN.getId()) 
			return new ModelAndView ("redirect:/logout");
		
		FormularioAgregarUsuario formulario = new FormularioAgregarUsuario();
		List<RolModel> listDeRoles = rolService.listarRolUsuario();
	  
		ModelMap modelo = new ModelMap();
		modelo.put("titulo", "Agregar Usuario");
		modelo.put("formularioAgregarUsuario", formulario);
		modelo.put("listaDeRoles", listDeRoles); modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		modelo.put("rol", request.getSession().getAttribute("ROL"));

		return new ModelAndView("agregarUsuario", modelo); 
	}
  
	@RequestMapping(path = "/validarRegistroUsuario", method = RequestMethod.POST) 
	public ModelAndView validarRegistroUsuario(@ModelAttribute("formularioAgregarUsuario") FormularioAgregarUsuario formularioAgregarUsuario, HttpServletRequest request) { 
		Long rol = (Long)request.getSession().getAttribute("ROL");
		if (rol != Rol.ADMIN.getId()) 
			return new ModelAndView ("redirect:/logout");
		
		UsuarioModel usuario = formularioAgregarUsuario.getUsuario();
		List<RolModel> listDeRoles = rolService.listarRolUsuario();
		
		ModelMap modelo = new ModelMap();
		modelo.put("titulo", "Agregar Usuario"); modelo.put("listaDeRoles", listDeRoles); 
		modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		modelo.put("rol", request.getSession().getAttribute("ROL"));

		if (usuarioService.validarRegistroUsuario(formularioAgregarUsuario) == false) { 
			modelo.put("errorValidacion", "El nombre de usuario o email ya existe, contacte al administrador"); 
			return new ModelAndView("agregarUsuario", modelo);
		} else { 
			usuarioService.guardarUsuario(usuario);
			usuarioRolService.guardarUsuarioRol(usuario.getIdUsuario(), formularioAgregarUsuario.getIdRol()); 
			return new ModelAndView("redirect:/usuarios"); 
		} 
	}
	  
	@RequestMapping("/editarUsuario") 
	public ModelAndView editarUsuario(@RequestParam("id") Long id, HttpServletRequest request) {
		Long rol = (Long)request.getSession().getAttribute("ROL");
		if (rol != Rol.ADMIN.getId()) 
			return new ModelAndView ("redirect:/logout");
		
		UsuarioModel usuario = usuarioService.buscarUsuarioPorId(id);
		ModelMap modelo = new ModelMap();
		modelo.put("titulo", "Editar " + usuario.getNombreDeUsuario());
		modelo.put("usuario", usuario); modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		modelo.put("rol", request.getSession().getAttribute("ROL"));

		return new ModelAndView("editarUsuario", modelo); 
	}
	  
	@RequestMapping(path = "/validarEditarUsuario", method = RequestMethod.POST)
	public ModelAndView validarEditarUsuario(@ModelAttribute("usuario") UsuarioModel usuario, HttpServletRequest request) { 
		Long rol = (Long)request.getSession().getAttribute("ROL");
		if (rol != Rol.ADMIN.getId()) 
			return new ModelAndView ("redirect:/logout");
		
		ModelMap modelo = new ModelMap();
		modelo.put("titulo", "Editar Usuario"); modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		modelo.put("rol", request.getSession().getAttribute("ROL"));

		usuarioService.modificarUsuario(usuario); 
		return new ModelAndView("redirect:/usuarios");
  
	}
  
	@RequestMapping("/validarEliminarUsuario") 
	public ModelAndView validarEliminarUsuario(@RequestParam("id") Long id, HttpServletRequest request) { 
		Long rol = (Long)request.getSession().getAttribute("ROL");
		if (rol != Rol.ADMIN.getId()) 
			return new ModelAndView ("redirect:/logout");
		
		ModelMap modelo = new ModelMap();
		modelo.put("nombreUsuario", request.getSession().getAttribute("NOMBRE"));
		modelo.put("rol", request.getSession().getAttribute("ROL"));

		if (usuarioService.validarEliminarUsuario(id) == true) {
			modelo.put("estadoEliminar", "El usuario se elimino exitosamente");
			usuarioService.eliminarUsuarioPorId(id); 
			return new ModelAndView("usuarios", modelo); 
		} else { 
			modelo.put("estadoEliminar", "Usuario no encontrado, contacte al administrador "); 
			return new ModelAndView("usuarios", modelo); 
		} 
	} 
}
 