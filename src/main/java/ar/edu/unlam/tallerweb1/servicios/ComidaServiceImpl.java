package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ar.edu.unlam.tallerweb1.modelo.ComidaModel;
import ar.edu.unlam.tallerweb1.repositorios.ComidaRepository;

@Service("comidaService")
@Transactional
public class ComidaServiceImpl implements ComidaService {
	
	@Inject
	private ComidaRepository comidaRepository;
	
	@Inject
    ServletContext servletContext;

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


	@Override
	public ComidaModel consultarComidaPorId(Long id) {
		return comidaRepository.consultarComidaPorId(id);
	}
	
	@Override
	public void editarComida(ComidaModel comida) {
		comidaRepository.editarComida(comida);
	}

	@Override
	public void subirImagenComida(ComidaModel comida, MultipartFile imagen) {
		String fileName = servletContext.getRealPath("/") +
				   "\\img\\comidas\\" +
				   imagen.getOriginalFilename();
			 
			try {
				imagen.transferTo(new File(fileName));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
	}


	@Override
	public void eliminarImagenComidaSiExiste(ComidaModel comida) {
		if (!comida.getImageName().isEmpty()) {
			String fileName = servletContext.getRealPath("/") +
					   "\\img\\comidas\\" +
					   comida.getImageName();

			File imagen = new File(fileName);
			
			imagen.delete();
		}
	}

}
