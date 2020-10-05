package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;

public interface ComidaRepository {
	ComidaModel consultarComidaPorId(Long id);
}
