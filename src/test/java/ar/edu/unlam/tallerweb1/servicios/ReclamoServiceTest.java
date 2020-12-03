package ar.edu.unlam.tallerweb1.servicios;

import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import ar.edu.unlam.tallerweb1.modelo.ReclamoModel;
import ar.edu.unlam.tallerweb1.repositorios.ReclamoRepository;

@RunWith(MockitoJUnitRunner.class)
public class ReclamoServiceTest {
	
	@Mock
	private ReclamoRepository reclamoRepositoryMock;
	
	@InjectMocks
	private ReclamoService reclamoService = new ReclamoServiceImpl();
	
	@Test
	public void testQueGuardaUnReclamo() {
		ReclamoModel reclamo = new ReclamoModel();
		
		doAnswer(new Answer<Void>() {
	        @Override
	        public Void answer(InvocationOnMock invocation) throws Throwable {
	        	reclamo.setIdReclamo(1L);
	            return null;
	        }
	    }).when(reclamoRepositoryMock).guardarReclamo(reclamo);
		
		reclamoService.guardarReclamo(reclamo);
		
		assertThat(reclamo.getIdReclamo()).isNotNull();
		verify(reclamoRepositoryMock).guardarReclamo(reclamo);
	}

}
