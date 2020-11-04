package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Servicio de Usuarios.
public interface LoginService {

	void guardarUsuario(Usuario usuario);

	Usuario consultarUsuario(Usuario usuario);

}
