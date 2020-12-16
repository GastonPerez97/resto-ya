package ar.edu.unlam.tallerweb1.servicios;

import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;

public interface MercadoPagoService {
	
	public Preference procesarPagoDePedido(String[] items, Integer[] cantidades, Float[] precios) throws MPException;
	
}
