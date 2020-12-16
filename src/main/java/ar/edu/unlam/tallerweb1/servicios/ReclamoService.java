package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.ReclamoModel;

public interface ReclamoService {
	
	void guardarReclamo(ReclamoModel reclamo);

	ReclamoModel buscarReclamoPorIdPedido(Long idPedido);
	
	public void actualizarReclamo(ReclamoModel reclamo);

}
