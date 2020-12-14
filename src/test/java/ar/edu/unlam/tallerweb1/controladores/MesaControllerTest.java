package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.Rollback;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.MesaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioNuevaMesa;
import ar.edu.unlam.tallerweb1.servicios.MesaService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;

@RunWith(MockitoJUnitRunner.class)
public class MesaControllerTest extends SpringTest {
    
	@Mock
	RestauranteService restauranteServiceMock;
	
	@Mock
	MesaService mesaServiceMock;

	@InjectMocks
	MesaController mesaController;
	
    @Test
	@Transactional @Rollback
	public void testChequeaQueSeAgregueRestauranteAModel() {
	    Long idRestaurante = 1L;
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    request.setAttribute("nombreUsuario", "userTest");
	    
	    when(restauranteServiceMock.buscarRestaurantePorId(idRestaurante)).thenReturn(new RestauranteModel(idRestaurante));
	    
	    ModelAndView modelAndView = mesaController.generarNuevaMesa(idRestaurante, request);

	    verify(restauranteServiceMock, times(1)).buscarRestaurantePorId(idRestaurante);
	    
	    assertThat(((RestauranteModel)(modelAndView.getModel().get("restaurante"))).getIdRestaurante()).isEqualTo(idRestaurante);
	}
	
    @Test
	@Transactional @Rollback
	public void testQueChequeaSiSeProcesaUnaNuevaMesa() {
    	FormularioNuevaMesa formularioMesa = new FormularioNuevaMesa();
	    MesaModel mesaModel = new MesaModel();
	    mesaModel.setNumeroDeMesa(1);
	    mesaModel.setCantidad(5);
	    mesaModel.setIdMesa(1L);
	    
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    request.setAttribute("nombreUsuario", "userTest");
	    
	    when(mesaServiceMock.procesarNuevaMesa(formularioMesa)).thenReturn(mesaModel);
	    
	    ModelAndView modelAndView = mesaController.generarNuevaMesaPost(formularioMesa, request);
	    
	    verify(mesaServiceMock, times(1)).procesarNuevaMesa(formularioMesa);

	    assertThat(((MesaModel)(modelAndView.getModel().get("mesa"))).getNumeroDeMesa()).isEqualTo(1);
	}
	
    
}
