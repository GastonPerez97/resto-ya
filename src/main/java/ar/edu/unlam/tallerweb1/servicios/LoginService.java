package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioRegistro;
import ar.edu.unlam.tallerweb1.modelo.resultadoBusqueda.ResultadoRegistro;

// Interface que define los metodos del Servicio de Usuarios.
public interface LoginService {



	void guardarUsuario(Usuario usuario);

	Usuario consultarUsuario(FormularioRegistro registro);
	
	Usuario consultarUsuario2(Usuario usuario);

}
