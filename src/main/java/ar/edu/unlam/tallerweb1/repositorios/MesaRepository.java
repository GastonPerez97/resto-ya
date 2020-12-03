package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.modelo.MesaModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioNuevaMesa;

import java.util.ArrayList;
import java.util.List;

public interface MesaRepository {
	
	List<MesaModel> getMesasByRestaurante(Long idRestaurante);
	MesaModel getMesaById(Long idMesa);
	void guardarMesa(MesaModel mesa);
	Integer getMaximaUbicacionFilaByRestaurante(Long idRestaurante);
	Integer getMaximaUbicacionColumnaByRestaurante(Long idRestaurante);
	Boolean existeMesaEnRestauranteByNumero(FormularioNuevaMesa formularioNuevaMesa);
	Boolean existeMesaEnRestauranteByFilaYColumna(FormularioNuevaMesa formularioNuevaMesa);
}
