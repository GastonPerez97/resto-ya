package ar.edu.unlam.tallerweb1.servicios;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;

public class MercadoPagoServiceTest {
	
	private MercadoPagoService mpService;
	
	@Before
	public void init() {
		mpService = new MercadoPagoServiceImpl();
	}

	@Test
	public void testQueProcesaElPagoDeUnPedido() throws MPException {
		String[] items = {"Item1", "Item2"};
		Float[] precios = {200F, 300F};
		
		Preference preferenceActual;
		
		preferenceActual = mpService.procesarPagoDePedido(items, precios);
		
		assertThat(preferenceActual.getItems()).hasSize(2);
		
		assertThat((preferenceActual.getItems().get(0).getTitle())).isEqualTo("Item1");
		assertThat((preferenceActual.getItems().get(0).getUnitPrice())).isEqualTo(200.0f);
		
		assertThat((preferenceActual.getItems().get(1).getTitle())).isEqualTo("Item2");
		assertThat((preferenceActual.getItems().get(1).getUnitPrice())).isEqualTo(300.0f);
		
		assertThat(preferenceActual.getBackUrls().getSuccess())
							.isEqualTo("http://localhost:8080/proyecto-limpio-spring-master/pagoRealizado");
		assertThat(preferenceActual.getBackUrls().getPending())
							.isEqualTo("http://localhost:8080/proyecto-limpio-spring-master/pagoPendiente");
		assertThat(preferenceActual.getBackUrls().getFailure())
							.isEqualTo("http://localhost:8080/proyecto-limpio-spring-master/pagoFallido");
		
		assertThat(preferenceActual.getPayer()).isNotNull();
	}

}
