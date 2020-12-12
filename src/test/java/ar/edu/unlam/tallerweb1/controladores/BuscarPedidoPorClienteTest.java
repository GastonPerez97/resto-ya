package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.annotation.Rollback;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ClienteController;
import ar.edu.unlam.tallerweb1.modelo.ClienteModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoModel;
import ar.edu.unlam.tallerweb1.servicios.ClienteService;
import ar.edu.unlam.tallerweb1.servicios.LoginService;

public class BuscarPedidoPorClienteTest extends SpringTest {

	@Mock
	private ClienteService clienteService;

	@Mock
	private LoginService loginService;

	@Test
	@Transactional
	@Rollback
	public void pruebaConexion() {
		assertThat(session().isConnected()).isTrue();
	}

	@Test
	@Transactional
	@Rollback
	public void testQueTraigaLosPedidosPorCliente() {
		// preparación
		ClienteService clienteServiceMock = mock(ClienteService.class);
		LoginService loginServiceMock = mock(LoginService.class);
		ClienteController clienteController = new ClienteController(clienteServiceMock, loginServiceMock);
		ClienteModel cliente = new ClienteModel();
		cliente.setNombre("pepe");
		cliente.setIdCliente(1L);
		List<PedidoModel> listaPedidos = new LinkedList<PedidoModel>();
		PedidoModel pedido = new PedidoModel();
		pedido.setIdPedido(1L);
		pedido.setCliente(cliente);
		listaPedidos.add(pedido);
		
		when(clienteServiceMock.buscarPedidosCliente(cliente)).thenReturn(listaPedidos);

		// ejecución

		ModelAndView mav = clienteController.pedidos(cliente);

		// validación
		assertThat(mav).isNotNull();
		assertThat(mav.getViewName()).isEqualTo("pedidosPorCliente");

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
	 * 
	 * /*
	 * 
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

	/*
	 * @Test
	 * 
	 * @Transactional
	 * 
	 * @Rollback public void testQueListePedidosPorCliente() {
	 * 
	 * assertThat(session().isConnected()).isTrue();
	 * 
	 * // preparacion ClienteModel clienteMock = mock(ClienteModel.class); //
	 * ClienteService clienteServicemock = mock(ClienteService.class);
	 * List<PedidoModel> pedidoMock = mock(List.class); ClienteController
	 * clienteController = new ClienteController(clienteService, null); //
	 * when(clienteServicemock.buscarPedidosCliente(clienteMock)).thenReturn(
	 * pedidoMock);
	 * 
	 * // ejecución ModelAndView mav = clienteController.pedidos(clienteMock);
	 * 
	 * // validacion assertThat(mav.getViewName()).isEqualTo("/pedidosPorCliente");
	 * 
	 * }
	 */

}