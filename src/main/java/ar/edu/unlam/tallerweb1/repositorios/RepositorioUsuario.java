package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioRegistro;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {

	void guardarUsuarioRegistrado(Usuario usuario);

	Usuario consultarUsuarioRegistrado(Usuario usuario);

}
