package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.Rollback;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ClienteController;
import ar.edu.unlam.tallerweb1.modelo.ClienteModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioRegistro;
import ar.edu.unlam.tallerweb1.repositorios.ClienteRepository;
import ar.edu.unlam.tallerweb1.servicios.ClienteService;
import ar.edu.unlam.tallerweb1.servicios.ComidaService;

public class BuscarPedidoPorClienteTest extends SpringTest {

	@Inject
	private ClienteService clienteService;

	@Inject
	private ServletContext servletContext;

	@Test
	@Transactional
	@Rollback
	public void pruebaConexion() {
		assertThat(session().isConnected()).isTrue();
	}

	/*
	 * @Test
	 * 
	 * @Transactional
	 * 
	 * @Rollback public void testQueLaBusquedaDeClientesSeaExitosa() {
	 * assertThat(session().isConnected()).isTrue();
	 * 
	 * // preparacion ClienteModel cm = new ClienteModel();
	 * 
	 * ClienteController cliente2 = new ClienteController(); // ejecución
	 * 
	 * ModelAndView mav = cliente2.irAHistorico(); // validacion
	 * assertThat(mav.getViewName()).isEqualTo("consultarHistorico");
	 * 
	 * }
	 */

	@Test

	@Transactional

	@Rollback
	public void testQueListePedidosPorCliente() {

		assertThat(session().isConnected()).isTrue();

		// preparacion ClienteModel clienteMock = mock(ClienteModel.class);
		// ClienteService clienteServicemock = mock(ClienteService.class);
		List<PedidoModel> pedidoMock = mock(List.class);
		ClienteController clienteController = new ClienteController();
		// when(clienteServicemock.buscarPedidosCliente(clienteMock)).thenReturn(pedidoMock);

		// ejecución ModelAndView mav = clienteController.pedidos(clienteMock);

		// validacion assertThat(mav.getViewName()).isEqualTo("/pedidosPorCliente");

	}

	@Test
	@Transactional
	@Rollback
	public void testQueTraigaLosPedidosPorCliente() {
		//preparación
		ClienteService clienteServiceMock = mock(ClienteService.class);
		ClienteController clienteController = new ClienteController();
		ClienteModel cliente = new ClienteModel();
		cliente.setNombre("pepe");
		cliente.setIdCliente(1L);
		List<PedidoModel> listaPedidos = new LinkedList<PedidoModel>();
		PedidoModel pedido = new PedidoModel();
		pedido.setIdPedido(1L);
		pedido.setCliente(cliente);
		listaPedidos.add(pedido);
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		HttpSession sessionMock = mock(HttpSession.class);

		when(requestMock.getSession()).thenReturn(sessionMock);

		//ejecución
		ModelAndView mav = clienteController.pedidos(cliente);

		//validación
		assertThat(mav).isNotNull();
		assertThat(mav.getViewName()).isEqualTo("/pedidosPorCliente");

	}

	/*
	 * @Test
	 * 
	 * @Transactional
	 * 
	 * @Rollback
	 * 
	 * //preparacion public void testQueLaBusquedaDeClientesSeaExitosa() {
	 * ClienteService clienteServiceMock = mock(ClienteService.class); ClienteModel
	 * clienteMock = mock(ClienteModel.class); ClienteModel clienteBuscadoMock =
	 * mock(ClienteModel.class);
	 * 
	 * HttpServletRequest requestMock = mock(HttpServletRequest.class); HttpSession
	 * sessionMock = mock(HttpSession.class); ClienteController clienteController =
	 * new ClienteController();
	 * 
	 * when(requestMock.getSession()).thenReturn(sessionMock);
	 * when(clienteBuscadoMock).buscarClientes()).thenReturn(null);
	 * when(((OngoingStubbing<HttpSession>)
	 * clienteServiceMock.buscarClientes()).thenReturn((HttpSession) clienteMock));
	 * 
	 * 
	 * //ejecucion
	 * 
	 * List<ClienteModel> mav = clienteService.buscarClientes();
	 * 
	 * //validacion assertThat(mav.getViewName())isEqualTo()
	 * 
	 * asserthat()
	 * 
	 * 
	 * }
	 */

}