package ar.edu.unlam.tallerweb1.modelo;

import java.util.LinkedList;
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
    
	private String direccion;
	private String horario;
	private String telefono;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurante")
	private List<ComidaModel> menu = new LinkedList<ComidaModel>();

    public RestauranteModel() {

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

	public List<ComidaModel> getMenu() {
		return menu;
	}

	public void setMenu(List<ComidaModel> menu) {
		this.menu = menu;
	}
	
}
