package ar.edu.unlam.tallerweb1.modelo;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "restaurante")
public class RestauranteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_restaurante")
	private Long idRestaurante;
	
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "direccion")
	private String direccion;
    
    @Column(name = "horario")
	private String horario;
    
    @Column(name = "telefono")
	private String telefono;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurante")
	private List<PedidoModel> pedidos = new LinkedList<PedidoModel>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restauranteModel", cascade = CascadeType.ALL)
    private List<RestauranteHorarioModel> restauranteHorarioList;

    public RestauranteModel() {
    	restauranteHorarioList = new ArrayList<RestauranteHorarioModel>();
    }
    
	public Long getIdRestaurante() {
		return idRestaurante;
	}
	
	public void setIdRestaurante(Long idRestaurante) {
		this.idRestaurante = idRestaurante;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	public List<PedidoModel> getPedido() {
		return pedidos;
	}

	public void setPedido(List<PedidoModel> pedido) {
		this.pedidos = pedido;
	}

	public List<RestauranteHorarioModel> getRestauranteHorarioList() {
		return restauranteHorarioList;
	}
	
}
