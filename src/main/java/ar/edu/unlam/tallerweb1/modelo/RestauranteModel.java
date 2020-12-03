package ar.edu.unlam.tallerweb1.modelo;

import java.util.LinkedList;
import java.util.List;

import java.util.ArrayList;
import javax.persistence.*;

import org.hibernate.annotations.Type;

import ar.edu.unlam.tallerweb1.modelo.enums.Calificacion;

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
    
    @Column(name = "urlMaps")
    private String urlMaps;
    
    @Column(name = "horario")
	private String horario;

	@Column(name = "telefono")
	private String telefono;
	private String imageName;
	
	private Integer promedioCalificaciones;

	@Type(type = "org.hibernate.type.TrueFalseType")
	private Boolean disponible;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurante")
	private List<ComidaModel> menu = new LinkedList<ComidaModel>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurante")
	private List<PedidoModel> pedidos = new LinkedList<PedidoModel>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "restauranteModel", cascade = CascadeType.ALL)
	private List<RestauranteHorarioModel> restauranteHorarioList = new LinkedList<RestauranteHorarioModel>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurante", cascade = CascadeType.ALL)
	private List<MesaModel> mesas = new LinkedList<MesaModel>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "restauranteModel", cascade = CascadeType.ALL)
	private List<CalificacionRestauranteModel> calificacion = new LinkedList<CalificacionRestauranteModel>();

	public List<PedidoModel> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoModel> pedidos) {
		this.pedidos = pedidos;
	}

	public List<CalificacionRestauranteModel> getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(List<CalificacionRestauranteModel> calificacion) {
		this.calificacion = calificacion;
	}

	public void setRestauranteHorarioList(List<RestauranteHorarioModel> restauranteHorarioList) {
		this.restauranteHorarioList = restauranteHorarioList;
	}

	// Constructores para tests
	public RestauranteModel(String nombre) {
		this.nombre = nombre;
	}

	public RestauranteModel(String nombre, Long id) {
		this.nombre = nombre;
		this.idRestaurante = idRestaurante;
	}

	public RestauranteModel() {
		// restauranteHorarioList = new ArrayList<RestauranteHorarioModel>();
		// mesas = new ArrayList<MesaModel>();
	}

	public RestauranteModel(Long idRestaurante) {
		this.idRestaurante = idRestaurante;
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

	public List<ComidaModel> getMenu() {
		return menu;
	}

	public void setMenu(List<ComidaModel> menu) {
		this.menu = menu;
	}

	public List<RestauranteHorarioModel> getRestauranteHorarioList() {
		return restauranteHorarioList;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imagen) {
		this.imageName = imagen;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public List<MesaModel> getMesas() {
		return mesas;
	}

	public void setMesas(List<MesaModel> mesas) {
		this.mesas = mesas;
	}

	public Integer getPromedioCalificaciones() {
		return promedioCalificaciones;
	}

	public void setPromedioCalificaciones(Integer promedioCalificaciones) {
		this.promedioCalificaciones = promedioCalificaciones;
	}
	
	public String getUrlMaps() {
		return urlMaps;
	}

	public void setUrlMaps(String urlMaps) {
		this.urlMaps = urlMaps;
	}
	
}
