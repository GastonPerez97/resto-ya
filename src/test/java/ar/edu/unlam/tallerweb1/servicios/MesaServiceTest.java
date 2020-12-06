package ar.edu.unlam.tallerweb1.servicios;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import ar.edu.unlam.tallerweb1.modelo.MesaModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioNuevaMesa;
import ar.edu.unlam.tallerweb1.repositorios.MesaRepository;


@RunWith(MockitoJUnitRunner.class)
public class MesaServiceTest {
	
	@Mock
	private MesaRepository mesaRepositoryMock;
	
	@InjectMocks
	private MesaService mesaService = new MesaServiceImpl();
	
	@Test
	public void testQueRecibeMesasDeUnRestaurante() {
		Long idRestaurante = 1L;
		MesaModel mesa1 = new MesaModel();
		MesaModel mesa2 = new MesaModel();
		
		when(mesaRepositoryMock.getMesasByRestaurante(idRestaurante)).thenReturn(Arrays.asList(mesa1, mesa2));
		
		List<MesaModel> listaDeMesasActual = mesaService.getMesasDisponiblesParaReservaByRestaurante(idRestaurante);
		
		assertThat(listaDeMesasActual).isEqualTo(Arrays.asList(mesa1, mesa2));
		verify(mesaRepositoryMock).getMesasByRestaurante(idRestaurante);
	}
	
	@Test
	public void testQueAlSolicitarMesasDeUnRestauranteEsteNoTenga() {
		Long idRestaurante = 1L;
		
		when(mesaRepositoryMock.getMesasByRestaurante(idRestaurante)).thenReturn(Collections.emptyList());
		
		List<MesaModel> listaDeMesasActual = mesaService.getMesasDisponiblesParaReservaByRestaurante(idRestaurante);
		
		assertThat(listaDeMesasActual).isEmpty();
		verify(mesaRepositoryMock).getMesasByRestaurante(idRestaurante);
	}
	
	@Test
	public void testQueRecibeMesaPorId() {
		Long idMesa = 1L;
		MesaModel mesa = new MesaModel();
		
		when(mesaRepositoryMock.getMesaById(idMesa)).thenReturn(mesa);
		
		MesaModel mesaActual = mesaService.getMesaById(idMesa);

		assertThat(mesaActual).isEqualTo(mesa);
		verify(mesaRepositoryMock).getMesaById(idMesa);
	}
	
	@Test
	public void testQueNoRecibeMesaPorId() {
		Long idMesa = 1L;
		
		when(mesaRepositoryMock.getMesaById(idMesa)).thenReturn(null);

		MesaModel mesaActual = mesaService.getMesaById(idMesa);
		
		assertThat(mesaActual).isNull();
		verify(mesaRepositoryMock).getMesaById(idMesa);
	}
	
	@Test
	public void testQueGuardaUnaMesa() {
		MesaModel mesa = new MesaModel();
		
		doAnswer(new Answer<Void>() {
	        @Override
	        public Void answer(InvocationOnMock invocation) throws Throwable {
	        	mesa.setIdMesa(1L);
	            return null;
	        }
	    }).when(mesaRepositoryMock).guardarMesa(mesa);
		
		mesaService.guardarMesa(mesa);
		
		assertThat(mesa.getIdMesa()).isNotNull();
		verify(mesaRepositoryMock).guardarMesa(mesa);
	}
	
	@Test
	public void testQueProcesaNuevaMesa() {
		FormularioNuevaMesa formulario = new FormularioNuevaMesa();
		formulario.setNumeroDeMesa(1);
		formulario.setCantidad(2);
		formulario.setIdRestaurante(3L);

		MesaModel mesaActual;
		
		doAnswer(new Answer<Void>() {
	        @Override
	        public Void answer(InvocationOnMock invocation) throws Throwable {
	        	Object[] args = invocation.getArguments();
	        	
	            ((MesaModel)args[0]).setIdMesa(1L);
	            
	            return null;
	        }
	    }).when(mesaRepositoryMock).guardarMesa(any(MesaModel.class));
		
		mesaActual = mesaService.procesarNuevaMesa(formulario);
		
		
		assertThat(mesaActual.getNumeroDeMesa()).isEqualTo(formulario.getNumeroDeMesa());
		assertThat(mesaActual.getCantidad()).isEqualTo(formulario.getCantidad());
		assertThat(mesaActual.getRestaurante().getIdRestaurante()).isEqualTo(formulario.getIdRestaurante());
		
		assertThat(mesaActual.getIdMesa()).isNotNull();
		verify(mesaRepositoryMock).guardarMesa(any(MesaModel.class));
	}
}
