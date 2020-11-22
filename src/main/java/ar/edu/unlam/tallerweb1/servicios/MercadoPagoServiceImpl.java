package ar.edu.unlam.tallerweb1.servicios;

import com.mercadopago.*;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;
import com.mercadopago.resources.datastructures.preference.Payer;

import ar.edu.unlam.tallerweb1.modelo.PedidoModel;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("mercadoPagoService")
@Transactional
public class MercadoPagoServiceImpl implements MercadoPagoService {

	@Override
	public Preference procesarPago() throws MPException {
		MercadoPago.SDK.configure("TEST-867780493823573-112218-33ab1227d9d3f3d6db2332eb892bd369-200165530");
		
		Payer payer = new Payer();
		Preference preference = new Preference();
		
		preference.setPayer(payer);

		preference.setBackUrls(
				new BackUrls().setFailure("http://localhost:8080/proyecto-limpio-spring-master/pagoFallido")
							  .setPending("http://localhost:8080/proyecto-limpio-spring-master/pagoPendiente")
							  .setSuccess("http://localhost:8080/proyecto-limpio-spring-master/pagoRealizado")
		);
		
		Item item = new Item();
		item.setTitle("Test item").setQuantity(1).setUnitPrice(3F);
		
		preference.appendItem(item);
		
		return preference.save();
	}
	
}
