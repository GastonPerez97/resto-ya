package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.MesaModel;
import ar.edu.unlam.tallerweb1.modelo.form.FormularioNuevaMesa;

public interface MesaService {
	
	List<MesaModel> getMesasDisponiblesParaReservaByRestaurante(Long idRestaurante);
	MesaModel getMesaById(Long idMesa);
	void guardarMesa(MesaModel mesa);
	MesaModel procesarNuevaMesa(FormularioNuevaMesa formulario);
	Boolean validarNuevaMesa(FormularioNuevaMesa formulario);
	Integer getMaximaUbicacionFilaByRestaurante(Long idRestaurante);
	Integer getMaximaUbicacionColumnaByRestaurante(Long idRestaurante);
	MesaModel[][] generarMapaDeMesas(List<MesaModel> mesas);

}
