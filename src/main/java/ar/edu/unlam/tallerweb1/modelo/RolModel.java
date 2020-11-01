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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class RolModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol")
	private Long idRol;
	
	private String nombre;
	private String descripcion;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rolModel", cascade = CascadeType.ALL)
	private List<UsuarioRolModel> listaRolesUsuario;
	
	
	
	public RolModel() {
		listaRolesUsuario = new ArrayList<UsuarioRolModel>();
	}
	
	
	
	
	public Long getId() {
		return idRol;
	}
	public void setId(Long id) {
		this.idRol = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	

}
