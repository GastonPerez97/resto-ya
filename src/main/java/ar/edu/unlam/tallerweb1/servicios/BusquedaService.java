package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.form.FormularioBusqueda;
import ar.edu.unlam.tallerweb1.modelo.resultadoBusqueda.ResultadoBusqueda;

public interface BusquedaService {
	
	ResultadoBusqueda buscar(FormularioBusqueda formulario);

}
