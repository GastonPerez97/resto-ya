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

	@Column(name = "nombre_usuario")
	private String nombreDeUsuario;
	private String email;
	private String clave;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioModel", cascade = CascadeType.ALL)
	private List<UsuarioRolModel> listaUsuarioRoles;

	public UsuarioModel() {
		listaUsuarioRoles = new ArrayList<UsuarioRolModel>();
	}

	
	//Constructor test	
	public UsuarioModel(String nombreDeUsuario, String email, String clave) {
		super();
		this.nombreDeUsuario = nombreDeUsuario;
		this.email = email;
		this.clave = clave;
	}



	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
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

	public List<UsuarioRolModel> getListaUsuarioRoles() {
		return listaUsuarioRoles;
	}

	public void setListaUsuarioRoles(List<UsuarioRolModel> listaUsuarioRoles) {
		this.listaUsuarioRoles = listaUsuarioRoles;
	}

}
