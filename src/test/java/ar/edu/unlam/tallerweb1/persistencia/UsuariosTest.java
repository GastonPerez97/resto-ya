package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;
import ar.edu.unlam.tallerweb1.repositorios.UsuarioRepository;
import ar.edu.unlam.tallerweb1.servicios.UsuarioService;

public class UsuariosTest extends SpringTest{
	
	@Inject
	UsuarioRepository usuarioRepository;
	
	@Inject
	UsuarioService usuarioService;
	
	private UsuarioModel usuario1 = new UsuarioModel("lucas","prueba@mail.com","1234");
	private UsuarioModel usuario2 = new UsuarioModel("juan","prueba@mail.com","5678");
	private UsuarioModel usuario3 = new UsuarioModel("pedro","prueba@mail.com","9013");
	
	@Test
    @Transactional @Rollback
    public void pruebaConexion(){
        assertThat(session().isConnected()).isTrue();
    }

	
	@Test
    @Transactional @Rollback
	public void testQueEliminaUsuarioPorId(){
		session().save(usuario1);
		session().save(usuario2);
		session().save(usuario3);
		
		usuarioService.eliminarUsuarioPorId(usuario2.getIdUsuario());
		
		List<UsuarioModel> listaUsuariosEsperados = new LinkedList<UsuarioModel>();
		listaUsuariosEsperados.add(usuario1);
		listaUsuariosEsperados.add(usuario3);
				
		
		List<UsuarioModel> listaUsuariosObtenidos = usuarioRepository.listarUsuarios();
		
		assertEquals(listaUsuariosEsperados, listaUsuariosObtenidos);		
	}

	
	@Test
    @Transactional @Rollback
	public void testQueListaUsuarios(){
		session().save(usuario1);
		session().save(usuario2);
		session().save(usuario3);
		
		List<UsuarioModel> listaUsuariosEsperados = new LinkedList<UsuarioModel>();
		listaUsuariosEsperados.add(usuario1);
		listaUsuariosEsperados.add(usuario2);
		listaUsuariosEsperados.add(usuario3);
		
		List<UsuarioModel> listaUsuariosObtenidos = usuarioRepository.listarUsuarios();
		
		assertEquals(listaUsuariosEsperados, listaUsuariosObtenidos);
	}
	
	
	@Test
    @Transactional @Rollback
	public void testQueValideLaExistenciaDeUnUsuarioPorId(){
		session().save(usuario1);
		
		Boolean valorEsperado = true;
		Boolean valorObtenido = usuarioService.existeUsuarioPorId(usuario1.getIdUsuario());
		
		assertEquals(valorEsperado, valorObtenido);		
	}
	
	
	@Test
    @Transactional @Rollback
	public void testQueValideQueNoExistaUnUsuarioPorId(){
		
		Boolean valorEsperado = false;
		Boolean valorObtenido = usuarioService.existeUsuarioPorId(usuario1.getIdUsuario());
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	
	@Test
    @Transactional @Rollback
	public void testQueValideLaExistenciaDeUnUsuarioPorNombre(){
		session().save(usuario1);
		
		Boolean valorEsperado = true;
		Boolean valorObtenido = usuarioService.existeUsuarioPorNombre(usuario1.getNombreDeUsuario());
		
		assertEquals(valorEsperado, valorObtenido);		
	}
	
	
	@Test
    @Transactional @Rollback
	public void testQueValideQueNoExistaUnUsuarioPorNombre(){

		Boolean valorEsperado = false;
		Boolean valorObtenido = usuarioService.existeUsuarioPorNombre(usuario1.getNombreDeUsuario());
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	
	@Test
    @Transactional @Rollback
	public void testQueBuscaUsuarioPorId(){
		session().save(usuario1);
		session().save(usuario2);
		session().save(usuario3);
		
		UsuarioModel usuarioEsperado = usuario2;
		UsuarioModel usuarioObtenido = usuarioService.buscarUsuarioPorId(usuario2.getIdUsuario());
		
		assertEquals(usuarioEsperado, usuarioObtenido);
	}
	
	

	
	
}
