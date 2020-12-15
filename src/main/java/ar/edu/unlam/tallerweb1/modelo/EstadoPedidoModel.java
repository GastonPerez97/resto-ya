package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado_pedido")
public class EstadoPedidoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado_pedido")
	private Long idEstadoPedido;
	
	@Column(name = "nombre_estado")
	private String nombreEstado;

    public EstadoPedidoModel() {
    	
    }
    
    public EstadoPedidoModel(Long idEstadoPedido) {
    	this.idEstadoPedido = idEstadoPedido;
    }

	public Long getIdEstadoPedido() {
		return idEstadoPedido;
	}

	public void setIdEstadoPedido(Long idEstadoPedido) {
		this.idEstadoPedido = idEstadoPedido;
	}

	public String getNombreEstado() {
		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}
    
}
