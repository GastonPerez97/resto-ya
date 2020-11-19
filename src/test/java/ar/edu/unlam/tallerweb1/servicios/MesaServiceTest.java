package ar.edu.unlam.tallerweb1.servicios;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import ar.edu.unlam.tallerweb1.modelo.MesaModel;
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

}
