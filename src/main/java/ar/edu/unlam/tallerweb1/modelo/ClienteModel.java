package ar.edu.unlam.tallerweb1.modelo;

import java.util.LinkedList;
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

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "dni")
	private String dni;

	@Column(name = "telefono")
	private String telefono;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clienteModel", cascade = CascadeType.ALL) 
	private List<PedidoModel> pedidos = new LinkedList<PedidoModel>();
			 
	
	  public List<PedidoModel> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoModel> pedidos) {
		this.pedidos = pedidos;
	}


	
	public Usuario getUsuario() {
	return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public ClienteModel() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
