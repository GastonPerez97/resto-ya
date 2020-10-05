package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.repositorios.ComidaRepository;

@Service("comidaService")
@Transactional
public class ComidaServiceImpl implements ComidaService {

	@Autowired
	private ComidaRepository repositorioComida;
	
	
	@Override
	public ArrayList<ComidaModel> buscarComida() {
		return repositorioComida.buscarComida();
	}
	
	
}
