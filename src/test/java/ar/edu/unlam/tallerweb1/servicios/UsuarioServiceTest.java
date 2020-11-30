package ar.edu.unlam.tallerweb1.servicios;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ReclamoModel;
import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;
import ar.edu.unlam.tallerweb1.repositorios.UsuarioRepository;



@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceTest {
	
	private UsuarioModel usuario1 = new UsuarioModel();
	private UsuarioModel usuario2 = new UsuarioModel();
	private UsuarioModel usuario3 = new UsuarioModel();
	
	@Mock
	private UsuarioRepository usuarioRepositoryMock;
	
	@InjectMocks
	private UsuarioService usuarioService = new UsuarioServiceImpl();
	
	@Test
	public void testQueGuardaUnUsuario() {
		
		doAnswer(new Answer<Void>() {
	        @Override
	        public Void answer(InvocationOnMock invocation) throws Throwable {
	        	usuario1.setIdUsuario(1L);
	            return null;
	        }
	    }).when(usuarioRepositoryMock).guardarUsuario(usuario1);
		
		usuarioService.guardarUsuario(usuario1);
		
		assertThat(usuario1.getIdUsuario()).isNotNull();
		verify(usuarioRepositoryMock).guardarUsuario(usuario1);
	}
	
	
	@Test
	public void testQueEliminaUsuarioPorId(){
		
		doAnswer(new Answer<Void>() {
	        @Override
	        public Void answer(InvocationOnMock invocation) throws Throwable {
	            return null;
	        }
	    }).when(usuarioRepositoryMock).eliminarUsuarioPorId(usuario1.getIdUsuario());
		
		usuarioService.eliminarUsuarioPorId(usuario1.getIdUsuario());
		
		assertThat(usuario1.getIdUsuario()).isNull();
		verify(usuarioRepositoryMock).eliminarUsuarioPorId(usuario1.getIdUsuario());	
	}
	
	
	@Test
	public void testQueListaDeUsuarios() {
	
		List<UsuarioModel> listaUsuariosActual = new LinkedList<UsuarioModel>();
		listaUsuariosActual.add(usuario1);
		listaUsuariosActual.add(usuario2);
		listaUsuariosActual.add(usuario3);
		
		when(usuarioRepositoryMock.listarUsuarios()).thenReturn(Arrays.asList(usuario1, usuario2, usuario3));
		
		assertThat(listaUsuariosActual).isEqualTo(usuarioRepositoryMock.listarUsuarios());
	    verify(usuarioRepositoryMock).listarUsuarios();	
	}

	
	@Test
	public void testQueValideLaExistenciaDeUnUsuarioPorId(){
		
		when(usuarioRepositoryMock.existeUsuarioPorId(usuario1.getIdUsuario())).thenReturn(usuario1);
		
		Boolean usuarioActual = usuarioService.existeUsuarioPorId(usuario1.getIdUsuario());
		
		assertThat(usuarioActual).isTrue();
	}
	
	
	@Test
	public void testQueValideLaNoExistenciaDeUnUsuarioPorId(){
		
		Long idUsuario = 1L;

		when(usuarioRepositoryMock.existeUsuarioPorId(idUsuario)).thenReturn(null);
		
		Boolean usuarioActual = usuarioService.existeUsuarioPorId(idUsuario);
		
		assertThat(usuarioActual).isFalse();
	}
	
	
	@Test
	public void testQueValideLaExistenciaDeUnUsuarioPorNombre(){
		
		when(usuarioRepositoryMock.existeUsuarioPorNombre(usuario1.getNombreDeUsuario())).thenReturn(usuario1);
		
		Boolean usuarioActual = usuarioService.existeUsuarioPorNombre(usuario1.getNombreDeUsuario());
		
		assertThat(usuarioActual).isTrue();
	}
	
	@Test
	public void testQueValideLaNoExistenciaDeUnUsuarioPorNombre(){

		when(usuarioRepositoryMock.existeUsuarioPorNombre(usuario1.getNombreDeUsuario())).thenReturn(null);
		
		Boolean usuarioActual = usuarioService.existeUsuarioPorNombre(usuario1.getNombreDeUsuario());
		
		assertThat(usuarioActual).isFalse();
	}
	
	
	@Test 
	public void testQueBuscaUsuarioPorId() {
		
		when(usuarioRepositoryMock.buscarUsuarioPorId(usuario1.getIdUsuario())).thenReturn(usuario1);
		
		UsuarioModel usuarioBuscado = usuarioService.buscarUsuarioPorId(usuario1.getIdUsuario());
		
		assertThat(usuarioBuscado).isEqualTo(usuario1);
		
	}
	
	

}
