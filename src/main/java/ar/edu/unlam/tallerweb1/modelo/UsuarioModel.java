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
@Table(name = "usuario")
public class UsuarioModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;
	
	private String nombreDeUsuario;
	private String email;
	private String clave;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioModel", cascade = CascadeType.ALL)
	private List<UsuarioRolModel> listaUsuarioRoles;
	
	
	
	public UsuarioModel() {
		listaUsuarioRoles = new ArrayList<UsuarioRolModel>();
	}
	
	
	
	
	
	public Long getId() {
		return idUsuario;
	}
	public void setId(Long id) {
		this.idUsuario = id;
	}
	public String getNombre() {
		return nombreDeUsuario;
	}
	public void setNombre(String nombre) {
		this.nombreDeUsuario = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
	
	
	

}
