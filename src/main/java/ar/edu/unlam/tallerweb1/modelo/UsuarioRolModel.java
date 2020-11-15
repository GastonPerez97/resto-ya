package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_rol")
public class UsuarioRolModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario_rol")
	private Long idUsuarioRol;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private UsuarioModel usuarioModel;
	
	@ManyToOne
	@JoinColumn(name = "id_rol")
	private RolModel rolModel;
	
	

	public Long getIdUsuarioRol() {
		return idUsuarioRol;
	}

	public void setIdUsuarioRol(Long idUsuarioRol) {
		this.idUsuarioRol = idUsuarioRol;
	}

	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}

	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}

	public RolModel getRolModel() {
		return rolModel;
	}

	public void setRolModel(RolModel rolModel) {
		this.rolModel = rolModel;
	}

	
	
	
	
	
}
