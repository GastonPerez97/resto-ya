package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reclamo")
public class ReclamoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reclamo")
	private Long idReclamo;
	
	@Column(name = "detalle_reclamo")
	private String detalle;

	@OneToOne
	@JoinColumn(name = "id_pedido")
	private PedidoModel pedido;
	

	public ReclamoModel() {
	}
	

	public ReclamoModel(String detalle, PedidoModel pedido) {
		super();
		this.detalle = detalle;
		this.pedido = pedido;
	}




	public Long getIdReclamo() {
		return idReclamo;
	}


	public void setIdReclamo(Long idReclamo) {
		this.idReclamo = idReclamo;
	}

	
	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public PedidoModel getIdPedido() {
		return pedido;
	}


	public void setIdPedido(PedidoModel idPedido) {
		this.pedido = idPedido;
	}

}
