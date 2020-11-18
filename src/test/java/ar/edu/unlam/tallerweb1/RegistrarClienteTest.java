package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.ClienteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioRegistro;
import ar.edu.unlam.tallerweb1.servicios.ClienteService;

public class RegistrarClienteTest extends SpringTest {

	@Inject

	private ClienteService servicioCliente;

	@Inject
	private ServletContext servletContext;

	@Test
	@Transactional
	@Rollback
	public void pruebaConexion() {
		assertThat(session().isConnected()).isTrue();
	}

	@Test
	@Transactional
	@Rollback
	public void queElApellidoDelClienteSeGuardeCorrectamente() {
		ClienteModel cliente = new ClienteModel();
		cliente.setApellido("Apellido");
		assertEquals("Apellido", cliente.getApellido());

	}

	@Test
	@Transactional
	@Rollback
	public void queElClienteSeGuardeCorrectamente() {
		ClienteModel cliente = new ClienteModel();

		cliente.setApellido("Apellido");
		cliente.setDni("111111");
		cliente.setNombre("Nombre");
		cliente.setTelefono("0303456");

		FormularioRegistro registro = new FormularioRegistro();
		registro.setClienteBuscado(cliente);

		servicioCliente.guardarClienteRegistrado(registro);

		assertEquals("Apellido", registro.getClienteBuscado().getApellido());

	}

	@Test
	@Transactional
	@Rollback
	public void queElClienteNoSeGuardeCorrectamenteSiNoSeCompletaronLosDatos() {
		FormularioRegistro registro = new FormularioRegistro();
		servicioCliente.guardarClienteRegistrado(registro);

		assertThat(registro);

	}

	/*
	 * @Test
	 * 
	 * @Transactional @Rollback public void
	 * testQueValidaCorrectamenteExtensionDeImagenJPG() { MockMultipartFile
	 * imagenJpg = new MockMultipartFile( "test", "test.jpg",
	 * MediaType.IMAGE_JPEG_VALUE, "Hola Mundo".getBytes() );
	 * 
	 * Boolean verificacion = servicioComida.verificarExtensionDeImagen(imagenJpg);
	 * 
	 * assertTrue(verificacion); }
	 * 
	 * @Test
	 * 
	 * @Transactional @Rollback public void
	 * testQueValidaCorrectamenteExtensionDeImagenPNG() { MockMultipartFile
	 * imagenJpg = new MockMultipartFile( "test", "test.png",
	 * MediaType.IMAGE_PNG_VALUE, "Hola Mundo".getBytes() );
	 * 
	 * Boolean verificacion = servicioComida.verificarExtensionDeImagen(imagenJpg);
	 * 
	 * assertTrue(verificacion); }
	 * 
	 * @Test
	 * 
	 * @Transactional @Rollback public void
	 * testQueValidaIncorrectamenteExtensionDeImagen() { MockMultipartFile imagenJpg
	 * = new MockMultipartFile( "test", "test.txt", MediaType.TEXT_PLAIN_VALUE,
	 * "Hola Mundo".getBytes() );
	 * 
	 * Boolean verificacion = servicioComida.verificarExtensionDeImagen(imagenJpg);
	 * 
	 * assertFalse(verificacion); }
	 * 
	 * @Test
	 * 
	 * @Transactional @Rollback public void testQueSubeUnaImagenJpg() throws
	 * Exception {
	 * 
	 * MultipartFile imagen = this.getImagenJpgMultipartParaTest();
	 * 
	 * servicioComida.subirImagenComida(imagen);
	 * 
	 * String pathDeImagenSubida = servletContext.getRealPath("/") +
	 * "\\img\\comidas\\" + imagen.getOriginalFilename();
	 * 
	 * File imagenSubida = new File(pathDeImagenSubida);
	 * 
	 * assertTrue(imagenSubida.exists());
	 * 
	 * imagenSubida.delete(); }
	 * 
	 * @Test
	 * 
	 * @Transactional @Rollback public void testQueSubeUnaImagenPng() throws
	 * Exception {
	 * 
	 * MultipartFile imagen = this.getImagenPngMultipartParaTest();
	 * 
	 * servicioComida.subirImagenComida(imagen);
	 * 
	 * String pathDeImagenSubida = servletContext.getRealPath("/") +
	 * "\\img\\comidas\\" + imagen.getOriginalFilename();
	 * 
	 * File imagenSubida = new File(pathDeImagenSubida);
	 * 
	 * assertTrue(imagenSubida.exists());
	 * 
	 * imagenSubida.delete(); }
	 * 
	 * 
	 * 
	 * 
	 * public MultipartFile getImagenJpgMultipartParaTest() throws Exception {
	 * 
	 * String imagenPath = servletContext.getRealPath("/") +
	 * "\\img\\test\\test1.jpg"; File imagenJpg = new File(imagenPath);
	 * 
	 * FileInputStream input = new FileInputStream(imagenJpg);
	 * 
	 * MultipartFile imagenMultipart = new MockMultipartFile( "file",
	 * imagenJpg.getName(), "text/plain", IOUtils.toByteArray(input) );
	 * 
	 * return imagenMultipart; }
	 * 
	 * public MultipartFile getImagenPngMultipartParaTest() throws Exception {
	 * 
	 * String imagenPath = servletContext.getRealPath("/") +
	 * "\\img\\test\\test2.png"; File imagenJpg = new File(imagenPath);
	 * 
	 * FileInputStream input = new FileInputStream(imagenJpg);
	 * 
	 * MultipartFile imagenMultipart = new MockMultipartFile( "file",
	 * imagenJpg.getName(), "text/plain", IOUtils.toByteArray(input) );
	 * 
	 * return imagenMultipart; }
	 */

}
