package ar.edu.unlam.tallerweb1.modelo.form;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ClienteModel;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoBusqueda;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoUsuario;

public class FormularioRegistro {
	private List<TipoUsuario> tiposUsuario;
	private Integer tipoUsuarioSeleccionado;
	private String atributoPrueba;
	public String getAtributoPrueba() {
		return atributoPrueba;
	}

	public void setAtributoPrueba(String atributoPrueba) {
		this.atributoPrueba = atributoPrueba;
	}

	public void setTiposUsuario(List<TipoUsuario> tiposUsuario) {
		this.tiposUsuario = tiposUsuario;
	}

	private Usuario datoBuscado;
	private ClienteModel clienteBuscado;

	public FormularioRegistro() {
		// forma de convertir un array a un tipo lista (casteo)
		tiposUsuario = List.of(TipoUsuario.values());
		datoBuscado = new Usuario(); 
		clienteBuscado = new ClienteModel();
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

	public Usuario getDatoBuscado() {
		return datoBuscado;
	}

	public void setDatoBuscado(Usuario datoBuscado) {
		this.datoBuscado = datoBuscado;
	}

	public ClienteModel getClienteBuscado() {
		return clienteBuscado;
	}

	public void setClienteBuscado(ClienteModel clienteBuscado) {
		this.clienteBuscado = clienteBuscado;
	}

}
