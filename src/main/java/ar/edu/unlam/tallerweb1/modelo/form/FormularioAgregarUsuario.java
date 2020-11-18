package ar.edu.unlam.tallerweb1.modelo.form;

import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;

public class FormularioAgregarUsuario {
	
	private UsuarioModel usuario = new UsuarioModel();
	private Long idRol;
	
	
	public UsuarioModel getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
	public Long getIdRol() {
		return idRol;
	}
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}
	
	

}
