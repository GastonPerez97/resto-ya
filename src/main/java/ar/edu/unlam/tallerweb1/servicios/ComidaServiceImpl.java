package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.repositorios.ComidaRepository;


@Service("comidaService")
@Transactional
public class ComidaServiceImpl implements ComidaService {
	
	@Inject
	private ComidaRepository comidaRepository;

	@Override
	public ComidaModel mostrarComidaModel(Long id) {
		ComidaModel comida = comidaRepository.consultarComidaPorId(id);
		return comida ;
	}
	
	
	@Override
	public ArrayList<ComidaModel> buscarComida() {
		return comidaRepository.buscarComida();
	}
	
	
}
