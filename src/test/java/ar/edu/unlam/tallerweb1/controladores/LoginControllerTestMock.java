package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;
import ar.edu.unlam.tallerweb1.servicios.LoginService;

public class LoginControllerTestMock {
	
	@Test
	public void testDeLoginCorrectoQueRedireccionaAlHome(){
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		HttpSession sessionMock = mock(HttpSession.class);
		LoginService servicioLoginMock = mock(LoginService.class);
		UsuarioModel usuarioMock = mock(UsuarioModel.class);
		ControladorLogin controladorLogin = new ControladorLogin(servicioLoginMock);
		
		when(requestMock.getSession()).thenReturn(sessionMock);
		when(servicioLoginMock.consultarUsuario(usuarioMock)).thenReturn(usuarioMock);
		
		ModelAndView mav = controladorLogin.validarLogin(usuarioMock, requestMock);
		
		assertThat(mav.getViewName()).isEqualTo("redirect:/home");	
	}
	
	@Test
	public void testDeLoginIncorrectoQueRedireccionaAlLogin(){
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		LoginService servicioLoginMock = mock(LoginService.class);
		UsuarioModel usuarioMock = mock(UsuarioModel.class);
		ControladorLogin controladorLogin = new ControladorLogin(servicioLoginMock);
		
		when(servicioLoginMock.consultarUsuario(usuarioMock)).thenReturn(null);
		
		ModelAndView mav = controladorLogin.validarLogin(usuarioMock, requestMock);
		
		assertThat(mav.getViewName()).isEqualTo("login");
		
	}
	
	

}
