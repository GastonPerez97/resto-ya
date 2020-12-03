package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.ReclamoModel;

public interface ReclamoRepository {
	
	void guardarReclamo(ReclamoModel reclamo);

	ReclamoModel buscarReclamoPorIdPedido(Long idPedido);

}
