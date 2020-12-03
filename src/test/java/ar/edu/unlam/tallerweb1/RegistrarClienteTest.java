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
		registro.setClienteModel(cliente);

		servicioCliente.guardarClienteRegistrado(registro);

		assertEquals("Apellido", registro.getClienteModel().getApellido());

	}

	@Test
	@Transactional
	@Rollback
	public void queElClienteNoSeGuardeCorrectamenteSiNoSeCompletaronLosDatos() {
		FormularioRegistro registro = new FormularioRegistro();
		servicioCliente.guardarClienteRegistrado(registro);

		assertThat(registro);

	}

}