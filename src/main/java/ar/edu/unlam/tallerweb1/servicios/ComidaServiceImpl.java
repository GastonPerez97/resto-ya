package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

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
	
	@Override
	public List<ComidaModel> buscarComidaDeseada(String nombre) {
		
		List<ComidaModel> comidasBuscadas = new ArrayList<ComidaModel>();
		List<ComidaModel> comidasDB = repositorioComida.buscarComida();
		
		for (ComidaModel comidaModel : comidasDB) {
			if (comidaModel.getNombre().toLowerCase().contains(nombre.toLowerCase()))
				comidasBuscadas.add(comidaModel);
		}
		
		return comidasBuscadas;
	}
}
