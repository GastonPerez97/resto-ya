package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class ClienteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long idCliente;
	
    @Column(name = "nombre")
    private String nombre;
    
	/*
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "clienteModel", cascade =
	 * CascadeType.ALL)
	 * 
	 * @Column(name = "id_pedido") private PedidoModel idPedido;
	 */
	public ClienteModel() {
    	
    }

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
