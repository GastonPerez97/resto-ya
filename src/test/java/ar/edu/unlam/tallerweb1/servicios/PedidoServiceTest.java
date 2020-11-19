package ar.edu.unlam.tallerweb1.servicios;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoModel;
import ar.edu.unlam.tallerweb1.repositorios.PedidoRepository;

@RunWith(MockitoJUnitRunner.class)
public class PedidoServiceTest {
	
	@Mock
	private PedidoRepository pedidoRepositoryMock;
	
	@Mock
	private ComidaService comidaServiceMock;
	
	@InjectMocks
	private PedidoService pedidoService = new PedidoServiceImpl();
	
	@Test
	public void testQueDevuelvePedidoCuandoSeConsultaPorId() {
		Long idPedido = 1L;
		PedidoModel pedido = new PedidoModel();
		pedido.setIdPedido(idPedido);
		
		when(pedidoRepositoryMock.consultarPedidoPorId(idPedido)).thenReturn(pedido);
		
		PedidoModel pedidoObtenido = pedidoService.consultarPedidoPorId(idPedido);
		
		assertThat(pedidoObtenido).isEqualTo(pedido);
		
		verify(pedidoRepositoryMock, times(1)).consultarPedidoPorId(idPedido);
	}
	
	@Test
	public void testQueNoDevuelvePedidoCuandoSeConsultaPorId() {
		Long idPedido = 1L;
		
		when(pedidoRepositoryMock.consultarPedidoPorId(idPedido)).thenReturn(null);		
		
		assertThat(pedidoService.consultarPedidoPorId(idPedido)).isNull();
		
		verify(pedidoRepositoryMock, times(1)).consultarPedidoPorId(idPedido);
	}
	
	@Test
	public void testQueCargaComidasAUnPedidoComidaDeUnPedidoModel() {
		PedidoModel pedido = new PedidoModel();
		
		ArrayList<Long> idComidas = new ArrayList<Long>();
		ArrayList<ComidaModel> comidasAgregadas = new ArrayList<ComidaModel>();
		
		ComidaModel comida1 = new ComidaModel("Hamburguesa");
		ComidaModel comida2 = new ComidaModel("Empanadas");
		
		comidasAgregadas.add(comida1);
		comidasAgregadas.add(comida2);
		
		when(comidaServiceMock.mostrarComidaPedida(idComidas)).thenReturn(comidasAgregadas);
		
		pedido = pedidoService.cargarPedidoComida(idComidas);
		
		verify(comidaServiceMock).mostrarComidaPedida(idComidas);
		assertThat(pedido.getPedidoComida()).isNotEmpty();
	}
	
	@Test
	public void testQueNoCargaComidasAUnPedidoComidaDeUnPedidoModel() {
		PedidoModel pedido = new PedidoModel();
		
		ArrayList<Long> idComidas = new ArrayList<Long>();
		ArrayList<ComidaModel> comidasAgregadas = new ArrayList<ComidaModel>();
		
		when(comidaServiceMock.mostrarComidaPedida(idComidas)).thenReturn(comidasAgregadas);
		
		pedido = pedidoService.cargarPedidoComida(idComidas);
		
		verify(comidaServiceMock).mostrarComidaPedida(idComidas);
		assertThat(pedido.getPedidoComida()).isEmpty();
	}
	
	@Test
	public void testQueGuardaUnPedido() {
		PedidoModel pedido = new PedidoModel();
		
		doAnswer(new Answer<Void>() {
	        @Override
	        public Void answer(InvocationOnMock invocation) throws Throwable {
	        	pedido.setIdPedido(1L);
	            return null;
	        }
	    }).when(pedidoRepositoryMock).guardarPedido(pedido);
		
		pedidoService.guardarPedido(pedido);
		
		assertThat(pedido.getIdPedido()).isNotNull();
		verify(pedidoRepositoryMock).guardarPedido(pedido);
	}
}
