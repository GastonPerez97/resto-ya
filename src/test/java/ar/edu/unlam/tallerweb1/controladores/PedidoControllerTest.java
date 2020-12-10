package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.Rollback;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.HorarioModel;
import ar.edu.unlam.tallerweb1.modelo.MesaModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoComidaModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioNuevaMesa;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioPedido;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioRestauranteHorario;
import ar.edu.unlam.tallerweb1.servicios.ComidaService;
import ar.edu.unlam.tallerweb1.servicios.HorarioService;
import ar.edu.unlam.tallerweb1.servicios.MercadoPagoService;
import ar.edu.unlam.tallerweb1.servicios.MesaService;
import ar.edu.unlam.tallerweb1.servicios.PedidoComidaService;
import ar.edu.unlam.tallerweb1.servicios.PedidoService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteHorarioService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;

@RunWith(MockitoJUnitRunner.class)
public class PedidoControllerTest {

	@Mock
	private ComidaService comidaServiceMock;
	
	@Mock
	private PedidoService pedidoServiceMock;
	
	@Mock
	private PedidoComidaService pedidoComidaServiceMock;
	
	@Mock
	private RestauranteService servRestauranteMock;
	
	@Mock
	private MercadoPagoService servicioMercadoPagoMock;

	@InjectMocks
	PedidoController pedidoController;
	
    @Test
	@Transactional @Rollback
	public void testQuePreparaParaHacerUnPedido() {
    	Long idRestaurante = 1L;
	    RestauranteModel restaurante = new RestauranteModel();
	    restaurante.setIdRestaurante(idRestaurante);
	    restaurante.setNombre("restaurante1");
	    
	    List<ComidaModel> listaComidas = null;
	    
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    request.getSession().setAttribute("NOMBRE", "nombreUsuario");
	    
	    when(servRestauranteMock.buscarRestaurantePorId(idRestaurante)).thenReturn(restaurante);
	    when(comidaServiceMock.buscarComidasDisponiblesDeRestaurante(idRestaurante)).thenReturn(listaComidas);
	    
	    ModelAndView modelAndView = pedidoController.hacerPedido(idRestaurante, request);

	    verify(servRestauranteMock, times(1)).buscarRestaurantePorId(idRestaurante);
	    verify(comidaServiceMock, times(1)).buscarComidasDisponiblesDeRestaurante(idRestaurante);
	    
	    assertThat(((RestauranteModel)(modelAndView.getModel().get("restaurante"))).getIdRestaurante()).isEqualTo(idRestaurante);
	    assertThat((((FormularioPedido) modelAndView.getModel().get("formularioPedido"))).getRestaurante()).isEqualTo(idRestaurante);
	    assertThat(modelAndView.getModel().get("nombreUsuario")).isEqualTo("nombreUsuario");
	}
    
    @Test
	@Transactional @Rollback
	public void testQueProcesaUnPedido() {
    	FormularioPedido formularioPedido = new FormularioPedido();
    	
    	PedidoModel pedido = new PedidoModel();
    	pedido.setIdPedido(2L);
    	pedido.setFechaPedido("2020-12-10");
    	pedido.setPedidoComida(new ArrayList<PedidoComidaModel>());
    	
    	MockHttpServletRequest request = new MockHttpServletRequest();
    	request.getSession().setAttribute("id", 1L);
    	request.getSession().setAttribute("NOMBRE", "nombreUsuario");

    	when(pedidoServiceMock.procesarPedido(formularioPedido)).thenReturn(pedido);
    	
    	ModelAndView mav = pedidoController.procesarPedidoPost(formularioPedido, request);
    	
    	assertThat(formularioPedido.getIdCliente()).isEqualTo(1L);
    	assertThat(request.getSession().getAttribute("idPedido")).isEqualTo(pedido.getIdPedido());
    	assertThat(mav.getModel().get("idPedido")).isEqualTo(2L);
    	assertThat(mav.getModel().get("hora")).isEqualTo("2020-12-10");
    	assertThat(mav.getModel().get("nombreUsuario")).isEqualTo("nombreUsuario");
    	assertThat(mav.getModel().get("pedidoComidaList")).isEqualTo(pedido.getPedidoComida());
    	verify(pedidoServiceMock, times(1)).procesarPedido(formularioPedido);
	}

}
