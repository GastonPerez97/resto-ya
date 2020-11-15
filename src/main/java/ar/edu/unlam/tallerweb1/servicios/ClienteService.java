package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.form.FormularioRegistro;
import ar.edu.unlam.tallerweb1.modelo.resultadoBusqueda.ResultadoRegistro;

// Interface que define los metodos del Servicio de Usuarios.
public interface ClienteService {

	ResultadoRegistro consultarClienteRegistrado(FormularioRegistro registro);

	void guardarClienteRegistrado(FormularioRegistro registro);

}
