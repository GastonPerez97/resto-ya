package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

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

}
