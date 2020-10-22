package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;

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
	
	@Override
	public List<ComidaModel> buscarComidaDeseada(String nombre) {
		
		List<ComidaModel> comidasBuscadas = new ArrayList<ComidaModel>();
		List<ComidaModel> comidasDB = comidaRepository.buscarComida();
		/* System.out.println(nombre); */
		for (ComidaModel comidaModel : comidasDB) {
			if (comidaModel.getNombre().toLowerCase().contains(nombre.toLowerCase()))
				comidasBuscadas.add(comidaModel);
		}
		
		return comidasBuscadas;
	}


	@Override
	public ArrayList<ComidaModel> mostrarComidaPedida(ArrayList<Long> id){
		
		ArrayList<ComidaModel> comidas = new ArrayList<ComidaModel>();
		
		for(Long idComida : id) {
			comidas.add(mostrarComidaModel(idComida));
		}
		
		return comidas;
	}



	
	
}
