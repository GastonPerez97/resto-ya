package ar.edu.unlam.tallerweb1.controladores;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.mockito.Mockito.*;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioGeneracionReclamo;
import ar.edu.unlam.tallerweb1.servicios.PedidoService;
import ar.edu.unlam.tallerweb1.servicios.ReclamoService;


@RunWith(MockitoJUnitRunner.class)
public class ReclamoControllerTest extends SpringTest{
	
	@Mock
	private PedidoService pedidoServiceMock;
	
	@Mock
	private ReclamoService reclamoServiceMock;
	
	@InjectMocks
	ReclamoController reclamoController;
	
    @Test
	@Transactional @Rollback
	public void testQueSeGenereUnReclamo() {

    	
    }
    

}
