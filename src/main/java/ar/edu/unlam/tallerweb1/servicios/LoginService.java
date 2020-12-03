package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioRegistro;

public interface LoginService {

	void guardarUsuarioRegistrado(UsuarioModel usuario);

	UsuarioModel consultarUsuarioRegistrado(FormularioRegistro registro);
	
	UsuarioModel consultarUsuario(UsuarioModel usuario);

}
