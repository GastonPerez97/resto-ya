package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoComidaModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoModel;
import ar.edu.unlam.tallerweb1.repositorios.PedidoComidaRepository;

@Service
public class PedidoComidaServiceImpl {

	@Inject
	private PedidoComidaRepository repositorioPedidoComida;
	

	
	public void guardarPedidoComida(PedidoComidaModel pedidoComida) {
		repositorioPedidoComida.guardarPedidoComida(pedidoComida);
		
	}
	
	

		
	
	
}
