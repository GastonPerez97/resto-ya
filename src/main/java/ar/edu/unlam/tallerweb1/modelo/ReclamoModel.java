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
	
	@OneToOne
	@JoinColumn(name = "id_pedido")
	private PedidoModel idPedido;
	

	public ReclamoModel(Long idReclamo, PedidoModel idPedido) {
		super();
		this.idReclamo = idReclamo;
		this.idPedido = idPedido;
	}


	public Long getIdReclamo() {
		return idReclamo;
	}


	public void setIdReclamo(Long idReclamo) {
		this.idReclamo = idReclamo;
	}


	public PedidoModel getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(PedidoModel idPedido) {
		this.idPedido = idPedido;
	}

}
