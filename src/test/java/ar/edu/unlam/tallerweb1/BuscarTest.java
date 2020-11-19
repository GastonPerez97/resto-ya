package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import javax.inject.Inject;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.controladores.BusquedaController;
import ar.edu.unlam.tallerweb1.modelo.ClienteModel;
import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioBusqueda;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioRegistro;
import ar.edu.unlam.tallerweb1.servicios.BusquedaService;
import ar.edu.unlam.tallerweb1.servicios.ClienteService;

public class BuscarTest extends SpringTest {

	@Inject

	private BusquedaService busquedaService;

	@Test
	@Transactional
	@Rollback
	public void pruebaConexion() {
		assertThat(session().isConnected()).isTrue();
	}

	@Test
	@Transactional
	@Rollback
	public void queElBuscadorTraigaComidas() {
		FormularioBusqueda formulario = new FormularioBusqueda();
		ComidaModel comida = new ComidaModel();
		String dato="COMIDA";
		formulario.setDatoBuscado(dato);
		
		
	}

	/*
	 * @Test
	 * 
	 * @Transactional
	 * 
	 * @Rollback public void queElClienteSeGuardeCorrectamente() { ClienteModel
	 * cliente = new ClienteModel();
	 * 
	 * cliente.setApellido("Apellido"); cliente.setDni("111111");
	 * cliente.setNombre("Nombre"); cliente.setTelefono("0303456");
	 * 
	 * FormularioRegistro registro = new FormularioRegistro();
	 * registro.setClienteBuscado(cliente);
	 * 
	 * servicioCliente.guardarClienteRegistrado(registro);
	 * 
	 * assertEquals("Apellido", registro.getClienteBuscado().getApellido());
	 * 
	 * }
	 */
	/*
	 * @Test
	 * 
	 * @Transactional
	 * 
	 * @Rollback public void
	 * queElClienteNoSeGuardeCorrectamenteSiNoSeCompletaronLosDatos() {
	 * FormularioRegistro registro = new FormularioRegistro();
	 * servicioCliente.guardarClienteRegistrado(registro);
	 * 
	 * assertThat(registro);
	 * 
	 * }
	 */

}