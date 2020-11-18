package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.Rollback;

import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.ClienteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioRegistro;
import ar.edu.unlam.tallerweb1.servicios.ClienteService;

public class PedidosPorClienteTest extends SpringTest {

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

}