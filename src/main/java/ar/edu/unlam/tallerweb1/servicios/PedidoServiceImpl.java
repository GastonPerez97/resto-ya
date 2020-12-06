package ar.edu.unlam.tallerweb1.servicios;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.ClienteModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoComidaModel;
import ar.edu.unlam.tallerweb1.modelo.PedidoModel;
import ar.edu.unlam.tallerweb1.modelo.RestauranteModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioPedido;
import ar.edu.unlam.tallerweb1.repositorios.PedidoRepository;

@Service
@Transactional
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository repositorioPedido;
	
	@Autowired
	private ComidaService comidaService;
	
	@Autowired
	private RestauranteService restauranteService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private MailService mailService;

	@Override
	public PedidoModel procesarPedido(FormularioPedido formularioPedido) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = new Date();
		
		RestauranteModel restaurante = restauranteService.buscarRestaurantePorId(formularioPedido.getRestaurante());
		ClienteModel cliente = clienteService.buscarClienteLogueado(formularioPedido.getIdCliente());
		PedidoModel pedido = cargarPedidoComida(formularioPedido.getPedidoSinFormato());
		
		pedido.setRestaurante(restaurante);
		pedido.setFechaPedido(dateFormat.format(date));
		guardarPedido(pedido);

		mailService.enviarMail(cliente.getUsuario().getEmail(),
							   mailService.getAsuntoConfirmacionPedido(),
							   mailService.getMensajePedido(pedido.getListaPedidosComidas()));
		
		return pedido;
	}
	
	@Override
	public void guardarPedido(PedidoModel pedido) {
		repositorioPedido.guardarPedido(pedido);

	}

	@Override
	public PedidoModel consultarPedidoPorId(Long id) {
		return repositorioPedido.consultarPedidoPorId(id);
	}

	@Override
	public PedidoModel cargarPedidoComida(String pedidoSinFormato) {
        
		String[] comidasYCantidades = pedidoSinFormato.split(";");
		List<String> comidasYCantidadesList = Arrays.asList(comidasYCantidades);
		
		PedidoModel pedido = new PedidoModel();
		
		for (String comidaCantidad : comidasYCantidadesList) {
			PedidoComidaModel pedidoComida = new PedidoComidaModel();
			pedidoComida.setCantidad(Double.parseDouble(comidaCantidad.split("-")[1]));
			pedidoComida.setComidaModel(comidaService.consultarComidaPorId((Long.parseLong(comidaCantidad.split("-")[0]))));
			pedidoComida.setPedidoModel(pedido);
			pedido.getPedidoComida().add(pedidoComida);
		}
	
		return pedido;
	}

	@Override
	public Double calcularTotalPedido(List<PedidoComidaModel> pedidoComidaList) {
		Double total = 0D;
		for (PedidoComidaModel pedidoComidaModel : pedidoComidaList)
			total += (pedidoComidaModel.getComidaModel().getPrecio() * pedidoComidaModel.getCantidad());
		
		return total;
	}

	@Override
	public void guardarNroReferencia(Long idPedido, Long nroReferencia) {
		repositorioPedido.guardarNroReferencia(idPedido, nroReferencia);
	}

}
