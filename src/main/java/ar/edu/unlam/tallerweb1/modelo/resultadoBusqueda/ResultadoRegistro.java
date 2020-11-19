package ar.edu.unlam.tallerweb1.modelo.resultadoBusqueda;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ClienteModel;
import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;
import ar.edu.unlam.tallerweb1.modelo.enums.TipoUsuario;

public class ResultadoRegistro {

	private List<ClienteModel> listaClientes;
	private List<UsuarioModel> listaUsuarios;
	private List<TipoUsuario> tiposUsuario;

	public ResultadoRegistro() {
		// forma de convertir un array a un tipo lista
		setTiposUsuario(List.of(TipoUsuario.values()));
		listaClientes = new ArrayList<ClienteModel>();
		listaUsuarios = new ArrayList<UsuarioModel>();
	}

	public List<TipoUsuario> getTiposBusqueda() {
		return tiposUsuario;
	}

	public void setTiposUsuario(List<TipoUsuario> tiposUsuario) {
		this.tiposUsuario = tiposUsuario;
	}
}
