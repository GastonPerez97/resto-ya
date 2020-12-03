package ar.edu.unlam.tallerweb1.modelo.form;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ClienteModel;
import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoUsuario;

public class FormularioRegistro {
	private List<TipoUsuario> tiposUsuario;
	private Integer tipoUsuarioSeleccionado;
	
	public void setTiposUsuario(List<TipoUsuario> tiposUsuario) {
		this.tiposUsuario = tiposUsuario;
	}

	private UsuarioModel usuarioModel;
	private ClienteModel clienteModel;

	public FormularioRegistro() {
		// forma de convertir un array a un tipo lista (casteo)
		tiposUsuario = List.of(TipoUsuario.values());
		usuarioModel = new UsuarioModel(); 
		clienteModel = new ClienteModel();
	}

	public List<TipoUsuario> getTiposUsuario() {
		return tiposUsuario;
	}

	public Integer getTipoUsuarioSeleccionado() {
		return tipoUsuarioSeleccionado;
	}

	public void setTipoUsuarioSeleccionado(Integer tipoUsuarioSeleccionado) {
		this.tipoUsuarioSeleccionado = tipoUsuarioSeleccionado;
	}

	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}

	public void setUsuarioModel(UsuarioModel usuario) {
		this.usuarioModel = usuario;
	}

	public ClienteModel getClienteModel() {
		return clienteModel;
	}

	public void setClienteModel(ClienteModel cliente) {
		this.clienteModel = cliente;
	}

}
