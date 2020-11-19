package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.UsuarioModel;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {

	UsuarioModel consultarUsuario(UsuarioModel usuario);
}

