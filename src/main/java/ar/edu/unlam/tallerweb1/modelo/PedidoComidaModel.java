package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido_comida")
public class PedidoComidaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private PedidoModel pedidoModel;
	
	@ManyToOne
	@JoinColumn(name = "id_comida")
	private ComidaModel comidaModel;
	
	private Double cantidad;
	
	
	
	public Long getIdPedidoComida() {
		return id;
	}

	public void setIdPedidoComida(Long idPedidoComida) {
		this.id = idPedidoComida;
	}

	public PedidoModel getPedidoModel() {
		return pedidoModel;
	}

	public void setPedidoModel(PedidoModel pedido) {
		this.pedidoModel = pedido;
	}

	public ComidaModel getComidaModel() {
		return comidaModel;
	}

	public void setComidaModel(ComidaModel comida) {
		this.comidaModel = comida;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
