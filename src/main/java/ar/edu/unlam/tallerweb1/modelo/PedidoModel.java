package ar.edu.unlam.tallerweb1.modelo;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class PedidoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long idPedido;
	
	@ManyToOne
	@JoinColumn(name = "id_restaurante")
	private RestauranteModel restaurante;
	
	public List<PedidoComidaModel> getListaPedidosComidas() {
		return listaPedidosComidas;
	}
	
	

	public void setListaPedidosComidas(List<PedidoComidaModel> listaPedidosComidas) {
		this.listaPedidosComidas = listaPedidosComidas;
	}

	public ClienteModel getCliente() {
		return clienteModel;
	}

	public void setCliente(ClienteModel cliente) {
		this.clienteModel = cliente;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedidoModel", cascade = CascadeType.ALL)
	private List<PedidoComidaModel> listaPedidosComidas;
	
	public ClienteModel getClienteModel() {
		return clienteModel;
	}

	public void setClienteModel(ClienteModel clienteModel) {
		this.clienteModel = clienteModel;
	}

	@ManyToOne
	@JoinColumn(name="id_cliente")
	private ClienteModel clienteModel;
	
	public PedidoModel() {
		listaPedidosComidas = new ArrayList<PedidoComidaModel>();
		
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}


	public RestauranteModel getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(RestauranteModel restaurante) {
		this.restaurante = restaurante;
	}

	public List<PedidoComidaModel> getPedidoComida() {
		return listaPedidosComidas;
	}

	public void setPedidoComida(List<PedidoComidaModel> pedidoComida) {
		this.listaPedidosComidas = pedidoComida;
	}

	
}
