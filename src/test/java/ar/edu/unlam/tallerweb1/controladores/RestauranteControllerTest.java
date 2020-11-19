package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

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
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.HorarioModel;
import ar.edu.unlam.tallerweb1.modelo.MesaModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioNuevaMesa;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioRestauranteHorario;
import ar.edu.unlam.tallerweb1.servicios.HorarioService;
import ar.edu.unlam.tallerweb1.servicios.MesaService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteHorarioService;
import ar.edu.unlam.tallerweb1.servicios.RestauranteService;

@RunWith(MockitoJUnitRunner.class)
public class RestauranteControllerTest extends SpringTest {

	@Mock
	private RestauranteService restauranteServiceMock;
	
	@Mock
	private RestauranteHorarioService restauranteHorarioServiceMock;
	
	@Mock
	private HorarioService horarioServiceMock;

	@InjectMocks
	RestauranteController restauranteController;
	
    @Test
	@Transactional @Rollback
	public void testChequeaQueSeAgregueRestauranteAModel() {
	    Long idRestaurante = 1L;
	    MockHttpServletRequest request = new MockHttpServletRequest();

	    when(restauranteServiceMock.buscarRestaurantePorId(idRestaurante)).thenReturn(new RestauranteModel(idRestaurante));
	    
	    ModelAndView modelAndView = restauranteController.generarNuevoHorario(idRestaurante, request);

	    verify(restauranteServiceMock, times(1)).buscarRestaurantePorId(idRestaurante);
	    
	    assertThat(((RestauranteModel)(modelAndView.getModel().get("restaurante"))).getIdRestaurante()).isEqualTo(idRestaurante);
	}
	
    @Test
	@Transactional @Rollback
	public void testQueChequeaSiSeProcesaUnNuevoHorario() {
    	FormularioRestauranteHorario formularioHorario = new FormularioRestauranteHorario();
	    HorarioModel horarioModel = new HorarioModel(1L);

	    MockHttpServletRequest request = new MockHttpServletRequest();
	    
	    when(restauranteHorarioServiceMock.procesarNuevoHorarioRestaurante(formularioHorario)).thenReturn(horarioModel);
	    
	    ModelAndView modelAndView = restauranteController.generarNuevoHorarioPost(formularioHorario, request);
	    
	    verify(restauranteHorarioServiceMock, times(1)).procesarNuevoHorarioRestaurante(formularioHorario);
	    
	    assertThat(((HorarioModel)(modelAndView.getModel().get("horario"))).getIdHorario()).isEqualTo(1L);
	}
	
    
}
